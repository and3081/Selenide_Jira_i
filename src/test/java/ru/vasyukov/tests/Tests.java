package ru.vasyukov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vasyukov.custom.properties.TestData;
import ru.vasyukov.hooks.WebHooks;
import ru.vasyukov.pageSteps.AuthSteps;
import ru.vasyukov.pageSteps.TaskListSteps;

public class Tests extends WebHooks {

//    @DisplayName("Тест Авторизации")
//    @Test
//    public void TestLogin() {
//        AuthSteps.auth();
//    }
//
//    @DisplayName("Тест проекта")
//    @Test
//    public void TestProject() {
//        AuthSteps.auth();
//        SysDashboardSteps.enteringProject(TestData.application.projectFullName(),
//                TestData.application.projectName());
//    }

//    @DisplayName("Тест количества задач проекта")
//    @Test
//    public void TestCountInProject() {
//        AuthSteps.auth();
//        SysDashboardSteps.enteringProject(TestData.application.projectFullName(),
//                TestData.application.projectName());
//        clickSideBarTaskListButton();
//        TaskListSteps.assertTaskCount();
//    }

    @DisplayName("Тест задачи")
    @Test
    public void TestTaskInProject() {
        AuthSteps.auth();
        TaskListSteps.enteringTask(TestData.application.projectFullName(),
                TestData.application.taskName());
        TaskListSteps.assertHeadTaskDetail();
    }

//    @DisplayName("Тест создания задачи: ")
//    @ParameterizedTest(name = "{displayName} {arguments}")
//    @MethodSource("ru.vasyukov.tests.TestParams#providerCreate")
//    public void TestCreateTask(String themeTask, String typeTask, String version,
//                               String statDo, String statInWork, String statDone) {
//        AuthSteps.auth();
//        SysDashboardSteps.enteringProject(TestData.application.projectFullName(),
//                TestData.application.projectName());
//        TasksSteps.assertHeadOpenTasks();
//        TasksSteps.clickTaskCreateButton();
//        TasksSteps.clickTaskCreateOpenDialogButton();
//
//        TestCreateSteps.CreateTask(themeTask, typeTask, version);
//        TasksSteps.assertTaskCreated(themeTask);
//        TasksSteps.assertMyTaskStatus(statDo);
//
//        TasksSteps.clickStatusInWorkButton();
//        TasksSteps.assertMyTaskStatus(statInWork);
//
//        TasksSteps.clickStatusProcessButton();
//        TasksSteps.clickStatusDoneButton();
//        TasksSteps.assertMyTaskStatus(statDone);
//    }
}
