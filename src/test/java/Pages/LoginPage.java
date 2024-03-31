package Pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;

public class LoginPage {
    private final SelenideElement loginInput = $(By.xpath("//*[@id=\"field_email\"]"));
    private final SelenideElement passwordInput = $(By.xpath("//*[@id=\"field_password\"]"));
    private final SelenideElement loginButton = $(By.xpath("//div[@class='button-pro __wide']"));
    private final SelenideElement loginErrorText = $(By.xpath("//div[@class='input-e login_error']"));

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }
    public void checkLoginPage() {
        loginInput.shouldBe();
        passwordInput.shouldBe();
        loginButton.shouldBe();
    }
    public void signIn(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password).pressEnter();
    }
    public void checkIncorrectLoginOrPassword() {
        loginErrorText.shouldBe();
        Assertions.assertEquals("Неправильно указан логин и/или пароль", loginErrorText.getText());
    }
    public void checkEmptyLogin() {
        loginErrorText.shouldBe();
        Assertions.assertEquals("Введите логин", loginErrorText.getText());
    }
    public void checkEmptyPassword() {
        loginErrorText.shouldBe();
        Assertions.assertEquals("Введите пароль", loginErrorText.getText());
    }
}