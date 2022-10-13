import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "PageElements", "PageSteps", "hooks"},
        tags = "@homeWorkCucumber"
)
public class CucumberTest {
    @BeforeClass

    public static void before() {
        RestAssured.filters(new AllureRestAssured());
    }
}