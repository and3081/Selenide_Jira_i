package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SysDashboardElems extends BaseElems {
    public static final SelenideElement headSysDashboard = $x("//h3[text()='Вход в систему']");
    public static final SelenideElement buttonProjects = $x("//nav//a[text()='Проекты']");
    public static final SelenideElement itemTestProject = $x("//div[@id='project_current']//a[text()='Test (TEST)']");
}
