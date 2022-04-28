import Hooks.WebHooks;
import PageObject.TaskListElems;
import PageSteps.AuthSteps;
import PageSteps.SysDashboardSteps;
import PageSteps.TaskListSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Tests extends WebHooks {
    @DisplayName("Тестирование Jira")
    @ParameterizedTest(name = "{displayName}")
    @MethodSource("TestParams#providerJira")
    public void TestJira(String taskName, String textShouldDone){
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
        TaskListSteps.clickTaskCreateButton();
        TaskListSteps.clickTaskCreateOpenDialogButton();
        //TaskListSteps.inputTextShouldDone(textShouldDone);
    }
}
