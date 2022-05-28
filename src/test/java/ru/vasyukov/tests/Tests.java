package ru.vasyukov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.vasyukov.custom.properties.PropertyData;
import ru.vasyukov.hooks.WebHooks;
import ru.vasyukov.pageSteps.*;

import static ru.vasyukov.pageObjects.BaseElems.clickSideBarTaskListButton;

/**
 * Класс тестов для Jira
 */
public class Tests extends WebHooks {

    /**
     * Тест Авторизации Jira
     */
    @DisplayName("Тест Авторизации")
    @Tag("1")
    @Test
    public void TestLogin() {
        AuthSteps.auth();
    }

    /**
     * Тест входа в проект Jira
     */
    @DisplayName("Тест проекта")
    @Tag("2")
    @Test
    public void TestProject() {
        AuthSteps.auth();
        SysDashboardSteps.enteringProject(PropertyData.application.projectFullName(),
                PropertyData.application.projectName());
    }

    /**
     * Тест проверки количества открытых задач в проекте Jira
     */
    @DisplayName("Тест количества задач проекта")
    @Tag("3")
    @Test
    public void TestCountInProject() {
        AuthSteps.auth();
        SysDashboardSteps.enteringProject(PropertyData.application.projectFullName(),
                PropertyData.application.projectName());
        clickSideBarTaskListButton();
        TaskListSteps.assertTaskCount();
    }

    /**
     * Тест входа в задачу проекта Jira
     */
    @DisplayName("Тест задачи")
    @Tag("4")
    @Test
    public void TestTaskInProject() {
        AuthSteps.auth();
        TaskListSteps.enteringTask(PropertyData.application.projectFullName(),
                PropertyData.application.taskName());
        TaskListSteps.assertHeadTaskDetail();
    }

    /**
     * Тест создания новой задачи в проекте и проведение ее по статусам СДЕЛАТЬ > В РАБОТЕ > ГОТОВО
     */
    @DisplayName("Тест создания задачи: ")
    @Tag("5")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("ru.vasyukov.tests.Params#providerCreate")
    public void TestCreateTask(String themeTask, String typeTask, String version,
                               String description, String environment,
                               String statDo, String statInWork, String statDone) {
        AuthSteps.auth();
        SysDashboardSteps.enteringProject(PropertyData.application.projectFullName(),
                PropertyData.application.projectName());
        TasksSteps.assertHeadOpenTasks();
        TasksSteps.clickTaskCreateButton();
        TasksSteps.clickTaskCreateOpenDialogButton();

        CreateSteps.CreateTask(themeTask, typeTask, version, description, environment);
        TasksSteps.assertTaskCreated(themeTask);
        TasksSteps.assertMyTaskStatus(statDo);

        TasksSteps.clickStatusInWorkButton();
        TasksSteps.assertMyTaskStatus(statInWork);

        TasksSteps.clickStatusProcessButton();
        TasksSteps.clickStatusDoneButton();
        TasksSteps.assertMyTaskStatus(statDone);
    }
}
