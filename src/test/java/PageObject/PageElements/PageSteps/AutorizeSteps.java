package PageObject.PageElements.PageSteps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

import static PageObject.PageElements.AutorizePage.*;
import static com.codeborne.selenide.Selenide.open;
import static utils.Configuration.getConfigurationValue;

public class AutorizeSteps {
    @Step("Проведем авторизацию {eduUrl}")
    @When("^Открываем страницу авторизации (.*)$")
    public static void openUrl(String eduUrl) {
        open(eduUrl);
    }
    @When("Пользователь авторизовывается")
    public static void autorize(){
    loginLane.shouldBe(Condition.visible).sendKeys(getConfigurationValue("login"));
    passwordLane.sendKeys(getConfigurationValue("password"));
    loginButton.click();
}


}
