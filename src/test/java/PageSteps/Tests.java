//package PageSteps;
//
//import io.cucumber.java.en.Then;
//import org.junit.jupiter.api.Test;
//
//import static PageSteps.AutorizeSteps.autorize;
//import static PageSteps.AutorizeSteps.openUrl;
//import static PageSteps.MainPageSteps.openProject;
//import static PageSteps.ProjectPageSteps.getTasksCount;
//import static PageSteps.ProjectPageSteps.testSeleniumBug;
//import static utils.Configuration.getConfigurationValue;
//
//public class Tests {
//@Test
//    @Then("Ввести логин и пароль")
//    public void autorization() {
//        openUrl(getConfigurationValue("eduUrl"));
//        autorize();
//    }
//    @Then("Открыть объект")
//    public void project() {
//        openProject();
//    }
//    @Then("Вывести в консоль количество задач - не там анотация")
//    public void tasks() {
//        getTasksCount();
//    }
//    @Then("Выполняем тесты")
//    public void test() {
//        testSeleniumBug();
//    }
//}
