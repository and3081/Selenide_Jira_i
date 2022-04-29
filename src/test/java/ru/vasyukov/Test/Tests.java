package ru.vasyukov.Test;

import ru.vasyukov.Hooks.WebHooks;
import ru.vasyukov.PageObject.TaskListElems;
import ru.vasyukov.PageObject.TasksElems;
import ru.vasyukov.PageSteps.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Tests extends WebHooks {
    @DisplayName("Тестирование Jira")
    @ParameterizedTest(name = "{displayName}")
    @MethodSource("ru.vasyukov.Test.TestParams#providerJira")
    public void TestJira(String taskName, String themeTask, String statDo, String statInWork, String statDone){
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
        String version = TaskListElems.getGoalTaskVersion();
        System.out.println("Версия задачи " +taskName +": " + version);

        TasksSteps.assertSideBarPage();
        TasksSteps.clickTasksButton();
        TasksSteps.assertHeadOpenTasks();
        TasksSteps.clickTaskCreateButton();
        TasksSteps.clickTaskCreateOpenDialogButton();

        TestCreateSteps.assertHeadTestCreate();
        TestCreateSteps.inputTypeTask();
        TestCreateSteps.inputDescription();
        TestCreateSteps.inputEnvironment();
        TestCreateSteps.inputFieldTheme(themeTask);
        TestCreateSteps.selectVersion(version);
        TestCreateSteps.clickAssignMe();
        TestCreateSteps.clickCreate();

        TasksSteps.assertHeadAllTasks();
        TasksSteps.clickSelectFiltersButton();
        TasksSteps.clickItemMyOpenTasks();
        TasksSteps.assertHeadMyTask(themeTask);

        TasksSteps.assertMyTaskStatus(statDo);
        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());

        TasksSteps.clickStatusInWorkButton();
        TasksSteps.checkEndRefresh();
        TasksSteps.assertMyTaskStatus(statInWork);
        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());

        TasksSteps.clickStatusProcessButton();
        TasksSteps.clickStatusDoneButton();
        TasksSteps.checkEndRefresh();
        TasksSteps.assertMyTaskStatus(statDone);
        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());
    }
}
