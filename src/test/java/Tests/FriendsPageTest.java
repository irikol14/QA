package Tests;

import Pages.AuthPage;
import Pages.FriendsPage;
import Pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FriendsPageTest extends BaseTest {
    @DisplayName("Тест раздела друзей: нет друзей")
    @Test
    public void checkFriends() {
        AuthPage authPage = new AuthPage();
        authPage.enterLoginAndPassword(login, password).clickAuthButton();
        MainPage mainPage = new MainPage();
        mainPage.navigateIntoFriends();
        FriendsPage friendsPage = new FriendsPage();
        Assertions.assertEquals("Пока нет друзей", friendsPage.listOfFriends());
    }
}