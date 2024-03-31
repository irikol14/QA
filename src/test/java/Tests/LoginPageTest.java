package Tests;
import Pages.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void checkLoginPageTest() {
        loginPage.open().checkLoginPage();
    }
    @Test
    public void checkIncorrectLoginTest() {
        loginPage.open().signIn("technopol", "technopolisPassword");
        loginPage.checkIncorrectLoginOrPassword();
    }
    @Test
    public void checkIncorrectPasswordTest() {
        loginPage.open().signIn("technopol53", "technopol");
        loginPage.checkIncorrectLoginOrPassword();
    }
    @Test
    public void checkEmptyLoginTTest() {
        loginPage.open().signIn("", "technopolisPassword");
        loginPage.checkEmptyLogin();
    }
    @Test
    public void checkEmptyPasswordTest() {
        loginPage.open().signIn("technopol53", "");
        loginPage.checkEmptyPassword();
    }
}