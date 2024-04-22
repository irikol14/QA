package Pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessengerPage implements BasePage {
    private static final By buttonAddChat = By.xpath("//msg-icon[@icon='plus']");
    private static final By messengerTitle = By.xpath("//slot[@name='title']");

    public MessengerPage(){
        check();
    }
    public void check(){
        $(buttonAddChat).shouldBe(visible.because("Кнопка добавления чата должна быть на странице"));
    }
    public String checkOpenMessenger() {
        return $(messengerTitle).shouldBe(visible).getText();
    }
}