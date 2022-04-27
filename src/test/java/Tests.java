import Hooks.WebHooks;
import PageObject.TaskListElems;
import PageSteps.AuthSteps;
import PageSteps.SysDashboardSteps;
import PageSteps.TaskListSteps;
import org.junit.jupiter.api.Test;

public class Tests extends WebHooks {
    @Test
    public void TestJira(){
        AuthSteps.assertAuthPage();
        AuthSteps.inputAuthLogin();
        AuthSteps.inputAuthPsw();
        AuthSteps.clickAuthButton();

        SysDashboardSteps.assertSysDashboardPage();
        SysDashboardSteps.clickAuthButton();
        SysDashboardSteps.clickItemTest();

        TaskListSteps.assertSideBarPage();
        TaskListSteps.clickTaskListButton();
    }
}
