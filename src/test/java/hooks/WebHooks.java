package hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

public class WebHooks {
    @Before
    public static void setUp() {
        Configuration.startMaximized = true;
    }

    }


