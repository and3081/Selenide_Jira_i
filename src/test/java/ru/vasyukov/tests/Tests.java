package ru.vasyukov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.vasyukov.custom.properties.TestData;
import ru.vasyukov.hooks.WebHooks;
import ru.vasyukov.pageSteps.*;

import static ru.vasyukov.pageObjects.BaseElems.clickSideBarTaskListButton;

public class Tests extends WebHooks {

    @DisplayName("Тест Авторизации")
    @Test
    public void TestLogin() {
        AuthSteps.auth();
    }

    @DisplayName("Тест проекта")
    @Test
    public void TestProject() {
        AuthSteps.auth();
        SysDashboardSteps.enteringProject(TestData.application.projectFullName(),
                TestData.application.projectName());
    }

    @DisplayName("Тест количества задач проекта")
    @Test
    public void TestCountInProject() {
        AuthSteps.auth();
        SysDashboardSteps.enteringProject(TestData.application.projectFullName(),
                TestData.application.projectName());
        clickSideBarTaskListButton();
        TaskListSteps.assertTaskCount();
    }

    @DisplayName("Тест задачи")
    @Test
    public void TestTaskInProject() {
        AuthSteps.auth();
        TaskListSteps.enteringTask(TestData.application.projectFullName(),
                TestData.application.taskName());
        TaskListSteps.assertHeadTaskDetail();
    }

    @DisplayName("Тест создания задачи: ")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("ru.vasyukov.tests.TestParams#providerCreate")
    public void TestCreateTask(String themeTask, String typeTask, String version,
                               String description, String environment,
                               String statDo, String statInWork, String statDone) {
        AuthSteps.auth();
        SysDashboardSteps.enteringProject(TestData.application.projectFullName(),
                TestData.application.projectName());
        TasksSteps.assertHeadOpenTasks();
        TasksSteps.clickTaskCreateButton();
        TasksSteps.clickTaskCreateOpenDialogButton();

        TestCreateSteps.CreateTask(themeTask, typeTask, version, description, environment);
        TasksSteps.assertTaskCreated(themeTask);
        TasksSteps.assertMyTaskStatus(statDo);

        TasksSteps.clickStatusInWorkButton();
        TasksSteps.assertMyTaskStatus(statInWork);

        TasksSteps.clickStatusProcessButton();
        TasksSteps.clickStatusDoneButton();
        TasksSteps.assertMyTaskStatus(statDone);
    }
}
