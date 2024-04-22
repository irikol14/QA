package Tests;

import Pages.AuthPage;
import Pages.MessengerPage;
import Pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MessengerPageTest extends BaseTest {
    @DisplayName("Тест раздела сообщений")
    @Test
    public void checkMessenger() {
        AuthPage authPage = new AuthPage();
        authPage.enterLoginAndPassword(login, password).clickAuthButton();
        MainPage mainPage = new MainPage();
        mainPage.clickMessenger();
        MessengerPage messengerPage = new MessengerPage();
        Assertions.assertEquals("Сообщения", messengerPage.checkOpenMessenger());
    }
}