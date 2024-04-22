package Pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage implements BasePage{
    private static final By loginInput = By.xpath("//*[@id=\"field_email\"]");
    private static final By passwordInput = By.xpath("//*[@id=\"field_password\"]");
    private static final By loginButton = By.xpath("//*[@data-l='t,sign_in']");

    public AuthPage(){
        check();
    }
    @Override
    public void check() {
        $(loginInput).shouldBe(visible.because("Поле ввода логина должно быть на странице авторизации"));
        $(passwordInput).shouldBe(visible.because("Поле ввода пароля должно быть на странице авторизации"));
        $(loginButton).shouldBe(visible.because("Кнопка входа должна быть на странице авторизации"));
    }
    public AuthPage enterLoginAndPassword(String login, String password){
        $(loginInput).setValue(login);
        $(passwordInput).setValue(password);
        return this;
    }
    public void clickAuthButton(){
        $(loginButton).click();
        new MainPage();
    }
}