package Tests;
import Pages.MainPage;
import org.junit.jupiter.api.Test;

public class MainPageTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    public void checkSignInTest() {
        mainPage.openLogin().checkMainPage();
    }
    @Test
    public void clickOpenMessenger(){
        mainPage.openLogin().clickMessenger();
    }
}