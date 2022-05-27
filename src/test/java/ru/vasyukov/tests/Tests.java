package ru.vasyukov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vasyukov.hooks.WebHooks;
import ru.vasyukov.pageSteps.AuthSteps;

public class Tests extends WebHooks {

    @DisplayName("Тест Авторизации")
    @Test
    public void TestLogin() {
        AuthSteps.auth();
    }

//    @DisplayName("Тест проекта: ")
//    @ParameterizedTest(name = "{displayName} {arguments}")
//    @MethodSource("ru.vasyukov.tests.TestParams#providerProject")
//    public void TestProject(String projectFullName, String projectName) {
//        AuthSteps.auth();
//        SysDashboardSteps.enteringProject(projectFullName, projectName);
//    }
//
//    @DisplayName("Тест количества задач проекта: ")
//    @ParameterizedTest(name = "{displayName} {arguments}")
//    @MethodSource("ru.vasyukov.tests.TestParams#providerProject")
//    public void TestCountInProject(String projectFullName, String projectName) {
//        AuthSteps.auth();
//        SysDashboardSteps.enteringProject(projectFullName, projectName);
//        clickSideBarTaskListButton();
//        TaskListSteps.assertTaskCount();
//        System.out.println("Количество задач: " + TaskListSteps.getTaskCount());
//    }

//    @DisplayName("Тест задачи: ")
//    @ParameterizedTest(name = "{displayName} {arguments}")
//    @MethodSource("ru.vasyukov.tests.TestParams#providerTask")
//    public void TestTaskInProject(String projectFullName, String taskName) {
//        AuthSteps.auth();
//        SysDashboardSteps.clickProjectsButton();
//        SysDashboardSteps.clickItemTest(projectFullName);
//        clickSideBarTaskListButton();
//        TaskListSteps.searchTask(taskName);
//        TaskListSteps.assertAndClickGoalTask(taskName);
//        TaskListSteps.assertHeadTaskDetail();
//        System.out.println("Статус задачи " +taskName +": " + TaskListSteps.getGoalTaskStatus());
//        System.out.println("Версия задачи " +taskName +": " + TaskListSteps.getGoalTaskVersion());
//    }
//
//    @DisplayName("Тест создания задачи: ")
//    @ParameterizedTest(name = "{displayName} {arguments}")
//    @MethodSource("ru.vasyukov.tests.TestParams#providerCreate")
//    public void TestCreateTask(String projectFullName, String projectName,
//                               String themeTask, String typeTask, String version,
//                               String statDo, String statInWork, String statDone) {
//        AuthSteps.auth();
//        SysDashboardSteps.enteringProject(projectFullName, projectName);
//        TasksSteps.assertHeadOpenTasks();
//        TasksSteps.clickTaskCreateButton();
//        TasksSteps.clickTaskCreateOpenDialogButton();
//
//        TestCreateSteps.CreateTask(themeTask, typeTask, version);
//        TasksSteps.assertTaskCreated(themeTask);
//        TasksSteps.assertMyTaskStatus(statDo);
//        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());
//
//        TasksSteps.clickStatusInWorkButton();
//        TasksSteps.assertMyTaskStatus(statInWork);
//        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());
//
//        TasksSteps.clickStatusProcessButton();
//        TasksSteps.clickStatusDoneButton();
//        TasksSteps.assertMyTaskStatus(statDone);
//        System.out.println("Статус моей задачи: " + TasksElems.getStatusMyTask());
//    }
}
