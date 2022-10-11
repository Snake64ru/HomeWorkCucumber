package PageObject.PageElements.PageSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static PageObject.PageElements.ProjectPage.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class ProjectPageSteps {
    @Step("Считаем количество задач")
    public static void getTasksCount() {
        //pageTasks.click();
        SelenideElement selenideElement = pagesCountElem.shouldBe(visible);
        String count = pagesCountElem.getOwnText();
        System.out.println("Here we have " + count.split(" ")[2] + " tasks.");
    }
    @Step("Проверка статуса задачи и версию")
    public static void testSeleniumBug() {
        allTasksAndFilters.shouldBe(visible, Duration.ofSeconds(20)).click();
        inputNameTask.shouldBe(visible).sendKeys("TestSelenium_bug");
        searchButton.click();
        assertStatus.shouldHave(Condition.text("Сделать"));
        assertVersion.shouldHave(Condition.text("Version 2.0"));
    }
    @Step("Создание бага")
    public static void testNewBug() {
        createLink.click();
        typeTask.click();
        typeTask.sendKeys(Keys.DELETE);
        typeTask.shouldBe(visible).setValue("О");
        typeTask.pressEnter();
        themeTask.click();
        themeTask.sendKeys("Не меняется цена после смены валюты");
        descriptionTextButton.click();
        textAreaDescription.sendKeys("Шаги \n" +
                "\n" +
                "1) открытие сайта\n" +
                "\n" +
                "Ожидаемый результат :\n" +
                "\n" +
                "Сайт открылся\n" +
                "\n" +
                "2) Смена валюты\n" +
                "\n" +
                "Ожидаемый результат \n" +
                "\n" +
                "Валюта изменилась, изменилась цена в соответствии с курсом заданному в настройках интернет-магазина \n" +
                "\n" +
                "Фактический результат:\n" +
                "\n" +
                "Иконки валют изменились\n" +
                "\n" +
                "Цена не изменилась");
        versionAreaDescription.click();
        propertyTask.click();
        propertyTask.sendKeys(Keys.DELETE);
        propertyTask.shouldBe(visible).sendKeys("H");
        propertyTask.pressEnter();
        labelTask.click();
        labelTask.sendKeys("sonnov_test");
        labelTask.pressEnter();
        textEnvironment.sendKeys("Windows 10  Google chrome Версия 101.0.4951.67 (Официальная сборка), (64 бит) Сайт открыт по ссылке : * http://shop.findbug.ru/*");
        sunkVersion.click();
        sleep(2000);
        task.sendKeys("TEST-21967");
        task.pressEnter();
        sleep(2000);
        sprint.sendKeys("1");
        sprint.pressEnter();
        sleep(1000);
        create.click();
    }
    @Step("Перевод статуса на Готово")
    public static void myTask(){
        myTask.click();
        statusInWork.click();
        sleep(1000);
        businessProcess.click();
        sleep(1000);
        statusWin.click();
        sleep(1000);
        getAssertStatusMyTask.shouldHave(Condition.text("Готово"));
        sleep(3000);

    }
}
