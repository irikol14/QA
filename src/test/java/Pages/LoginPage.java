package Pages;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;

public class LoginPage implements BasePage{
    private static final By loginInput = By.xpath("//*[@id=\"field_email\"]");
    private static final By passwordInput = By.xpath("//*[@id=\"field_password\"]");
    private static final By loginButton = By.xpath("//*[@data-l='t,sign_in']");
    private static final By loginErrorText = By.xpath("//div[@class='input-e login_error']");

    public LoginPage() {
        open().check();
    }
    @Override
    public void check() {
        $(loginInput).shouldBe(visible.because("Поле ввода логина должно быть на странице входа"));
        $(passwordInput).shouldBe(visible.because("Поле ввода пароля должно быть на странице входа"));
        $(loginButton).shouldBe(visible.because("Кнопка входа должна быть на странице входа"));
    }
    public LoginPage open() {
        Selenide.open("/");
        return this;
    }
    public void signIn(String login, String password) {
        $(loginInput).setValue(login);
        $(passwordInput).setValue(password).pressEnter();
    }
    public static boolean checkIncorrectLoginOrPassword() {
        $(loginErrorText).shouldBe(visible.because("Должен быть отображен текст 'Неправильно указан логин и/или пароль'")).shouldHave(text("Неправильно указан логин и/или пароль"));
        return false;
    }
    public static boolean checkEmptyLogin() {
        $(loginErrorText).shouldBe(visible.because("Должен быть отображен текст 'Введите логин'")).shouldHave(text("Введите логин"));
        return false;
    }
    public static boolean checkEmptyPassword() {
        $(loginErrorText).shouldBe(visible.because("Должен быть отображен текст 'Введите пароль'")).shouldHave(text("Введите пароль"));
        return false;
    }
}