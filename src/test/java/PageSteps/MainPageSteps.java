package PageSteps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;

import static PageObject.PageElements.MainPage.projectTestLink;
import static PageObject.PageElements.MainPage.projectsMenuButton;

public class MainPageSteps {
//    @Step("Заходим в проект")
    @Then("Открыть объект")
    public static void openProject(){
        projectsMenuButton.shouldBe(Condition.visible).click();
        projectTestLink.shouldBe(Condition.visible).click();
    }


}
