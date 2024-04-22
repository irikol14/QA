package Tests;

import Pages.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @DisplayName("Тест входа с некорректным логином")
    @Test
    public void checkIncorrectLoginTest() {
        loginPage.signIn("technopol", "technopolisPassword");
        Assertions.assertFalse(LoginPage.checkIncorrectLoginOrPassword(), "Авторизация не пройдена, неверный логин/пароль");
    }
    @DisplayName("Тест входа с некорректным паролем")
    @Test
    public void checkIncorrectPasswordTest() {
        loginPage.signIn("technopol53", "technopol");
        Assertions.assertFalse(LoginPage.checkIncorrectLoginOrPassword(), "Авторизация не пройдена, неверный логин/пароль");
    }
    @DisplayName("Тест входа с пустым логином и корректным/некорректным паролем")
    @ParameterizedTest(name = "Тест: пустой логин")
    @ValueSource(strings = {"password", "technopolisPassword"})
    public void checkEmptyLoginTTest(String password) {
        loginPage.signIn("", password);
        Assertions.assertFalse(LoginPage.checkEmptyLogin(), "Авторизация не пройдена, пустой логин");
    }
    @DisplayName("Тест входа с пустым паролем и корректным/некорректным логином")
    @ParameterizedTest(name = "Тест: пустой пароль")
    @ValueSource(strings = {"technopol53", "technopol53login"})
    public void checkEmptyPasswordTest(String login) {
        loginPage.signIn(login, "");
        Assertions.assertFalse(LoginPage.checkEmptyPassword(), "Авторизация не пройдена, пустой пароль");
    }
}