package ru.vasyukov;

import ru.vasyukov.Hooks.WebHooks;
import ru.vasyukov.PageObject.TaskListElems;
import ru.vasyukov.PageSteps.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Tests extends WebHooks {
    @DisplayName("Тестирование Jira")
    @ParameterizedTest(name = "{displayName}")
    @MethodSource("ru.vasyukov.TestParams#providerJira")
    public void TestJira(String taskName, String themeTask){
        AuthSteps.assertAuthPage();
        AuthSteps.inputAuthLogin();
        AuthSteps.inputAuthPsw();
        AuthSteps.clickAuthButton();

        SysDashboardSteps.assertSysDashboardPage();
        SysDashboardSteps.clickProjectsButton();
        SysDashboardSteps.clickItemTest();

        TaskListSteps.assertSideBarPage();
        TaskListSteps.clickTaskListButton();
        TaskListSteps.assertTaskCount();
        System.out.println("Количество задач: " + TaskListElems.getTaskCount());
        TaskListSteps.searchTask(taskName);
        TaskListSteps.assertAndClickGoalTask(taskName);
        TaskListSteps.assertHeadTaskDetail();
        System.out.println("Статус задачи " +taskName +": " + TaskListElems.getGoalTaskStatus());
        System.out.println("Версия задачи " +taskName +": " + TaskListElems.getGoalTaskVersion());

        TasksSteps.assertSideBarPage();
        TasksSteps.clickTasksButton();
        TasksSteps.assertHeadOpenTasks();
        TasksSteps.clickTaskCreateButton();
        TasksSteps.clickTaskCreateOpenDialogButton();

        TestCreateSteps.assertHeadTestCreate();
        TestCreateSteps.inputTypeTask();
        TestCreateSteps.inputFieldTheme(themeTask);
        TestCreateSteps.clickAssignMe();

        TestCreateSteps.clickCreate();
    }
}
