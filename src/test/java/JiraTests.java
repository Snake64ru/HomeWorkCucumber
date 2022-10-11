import hooks.WebHooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static PageObject.PageElements.PageSteps.AutorizeSteps.autorize;
import static PageObject.PageElements.PageSteps.AutorizeSteps.openUrl;
import static PageObject.PageElements.PageSteps.MainPageSteps.openProject;
import static PageObject.PageElements.PageSteps.ProjectPageSteps.getTasksCount;
import static PageObject.PageElements.PageSteps.ProjectPageSteps.testSeleniumBug;
import static utils.Configuration.getConfigurationValue;

public class JiraTests extends WebHooks {
    @Test
    @Tag("JiraTests")
    @DisplayName("Вывод в консоль количества задач")
    public void autorization() {
        openUrl(getConfigurationValue("eduUrl"));
        autorize();
        openProject();
        getTasksCount();
    }
    @Test
    @Tag("JiraTests")
    @DisplayName("Проверка создания новых задач и перевода их статуса")
    public void test() {
        openUrl(getConfigurationValue("eduUrl"));
        autorize();
        openProject();
        getTasksCount();
        testSeleniumBug();
    }
}
