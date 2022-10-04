package PageSteps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;

import static PageObject.PageElements.AutorizePage.*;
import static com.codeborne.selenide.Selenide.open;
import static utils.Configuration.getConfigurationValue;

public class AutorizeSteps {
//    @Step("Проведем авторизацию {eduUrl}")
@When("Открываем страницу авторизации {string}")
    public static void openUrl(String eduUrl) {
        open(eduUrl);
    }

    @When( "Пользователь авторизовывается")
public static void autorize(){
    loginLane.shouldBe(Condition.visible).sendKeys(getConfigurationValue("login"));
    passwordLane.sendKeys(getConfigurationValue("password"));
    loginButton.click();
    welcome.shouldHave(Condition.text("Добро пожаловать в Jira"));
}


}
