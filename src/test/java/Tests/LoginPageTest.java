package Tests;
import Pages.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void checkIncorrectLoginTest() {
        loginPage.signIn("technopol", "technopolisPassword");
        Assertions.assertFalse(LoginPage.checkIncorrectLoginOrPassword(), "Авторизация не пройдена, неверный логин/пароль");
    }
    @Test
    public void checkIncorrectPasswordTest() {
        loginPage.signIn("technopol53", "technopol");
        Assertions.assertFalse(LoginPage.checkIncorrectLoginOrPassword(), "Авторизация не пройдена, неверный логин/пароль");
    }
    @Test
    public void checkEmptyLoginTTest() {
        loginPage.signIn("", "technopolisPassword");
        Assertions.assertFalse(LoginPage.checkEmptyLogin(), "Авторизация не пройдена, пустой логин");
    }
    @Test
    public void checkEmptyPasswordTest() {
        loginPage.signIn("technopol53", "");
        Assertions.assertFalse(LoginPage.checkEmptyPassword(), "Авторизация не пройдена, пустой пароль");
    }
}