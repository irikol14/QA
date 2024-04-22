package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static com.codeborne.selenide.Browsers.CHROME;

public abstract class BaseTest {
    static final String login = "technopol53";
    static final String password = "technopolisPassword";
    @BeforeAll
    public static void setUp() {
        Configuration.browser = CHROME;
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    public void open() {
        Selenide.open("/");
    }
    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}