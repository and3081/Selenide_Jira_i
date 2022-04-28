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
    @ParameterizedTest
    @MethodSource("TestParams#providerJira")
    public void TestJira(String taskName){
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
    }
}
