package hooks;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;

public class AllureSelenideSubscription {
    @Before
    public static void allureSubThreadParallel(){
        String listenerName = "AllureSelenide";

        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    new AllureSelenide()
                            .screenshots(true)
                            .savePageSource(false));
    }
}
