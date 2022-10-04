package PageObject.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public static SelenideElement projectsMenuButton = $x("//a[@id='browse_link']");
    public static SelenideElement projectTestLink = $x("//a[contains(text(), 'Test (TEST)')]");


}
//h3[contains(text(),'Добро пожаловать в Jira')]