package Pages;

import static com.codeborne.selenide.Condition.visible;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Selenide.*;

public class MainPage implements BasePage{
    private static final By username = By.xpath("//div[@class='tico ellip']");
    private static final By navigationToolBar = By.xpath("//div[@data-l='t,navigationToolbar']");
    private static final By openMessengerButton = By.xpath("//*[@id='msg_toolbar_button']");
    private static final By userFriends = By.xpath("//*[@data-l=\"t,userFriend\"]//div");

    public MainPage() {
        check();
    }
    @Override
    public void check() {
        String name = "technopol53 technopol53";
        Assertions.assertEquals(name, $(username).getText());
        $(navigationToolBar).shouldBe(visible.because("Навигационная панель должна быть на страницем пользователя"));
    }
    public void clickMessenger() {
        $(openMessengerButton).shouldBe(visible.because("Раздел сообщений должен быть на странице пользователя")).click();
    }
    public void navigateIntoFriends(){
        $(userFriends).shouldBe(visible.because("Раздел друзей должен быть на странице пользователя")).click();
    }
}