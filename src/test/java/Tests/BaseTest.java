package Tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

public abstract class BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.browserSize = "1920x1080";
    }
    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}