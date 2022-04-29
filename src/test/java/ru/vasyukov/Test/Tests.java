package ru.vasyukov.Test;

import ru.vasyukov.Hooks.WebHooks;
import ru.vasyukov.PageSteps.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Tests extends WebHooks {
    @DisplayName("Тестирование Jira")
    @ParameterizedTest(name = "{displayName}")
    @MethodSource("ru.vasyukov.Test.TestParams#providerJira")
    public void TestJira(String taskName, String themeTask, String typeTask,
                         String statDo, String statInWork, String statDone){
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
        System.out.println("Количество задач: " + TaskListSteps.getTaskCount());
        TaskListSteps.searchTask(taskName);
        TaskListSteps.assertAndClickGoalTask(taskName);
        TaskListSteps.assertHeadTaskDetail();
        System.out.println("Статус задачи " +taskName +": " + TaskListSteps.getGoalTaskStatus());
        String version = TaskListSteps.getGoalTaskVersion();
        System.out.println("Версия задачи " +taskName +": " + version);

        TasksSteps.assertSideBarPage();
        TasksSteps.clickTasksButton();
        TasksSteps.assertHeadOpenTasks();
        TasksSteps.clickTaskCreateButton();
        TasksSteps.clickTaskCreateOpenDialogButton();

        TestCreateSteps.assertHeadTestCreate();
        TestCreateSteps.inputTypeTask(typeTask);
        TestCreateSteps.inputFieldTheme(themeTask);
        TestCreateSteps.selectFixVersion(version);
        TestCreateSteps.selectTouchVersion(version);
        TestCreateSteps.inputDescription();
        TestCreateSteps.inputEnvironment();
        TestCreateSteps.clickAssignMe();
//        TestCreateSteps.clickCreate();
//
//        TasksSteps.assertHeadAllTasks();
//        TasksSteps.clickSelectFiltersButton();
//        TasksSteps.clickItemMyOpenTasks();
//        TasksSteps.assertHeadMyTask(themeTask);
//
//        TasksSteps.assertMyTaskStatus(statDo);
//        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());
//
//        TasksSteps.clickStatusInWorkButton();
//        TasksSteps.checkEndRefresh();
//        TasksSteps.assertMyTaskStatus(statInWork);
//        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());
//
//        TasksSteps.clickStatusProcessButton();
//        TasksSteps.clickStatusDoneButton();
//        TasksSteps.checkEndRefresh();
//        TasksSteps.assertMyTaskStatus(statDone);
//        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());
    }
}
