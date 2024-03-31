package Pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final String login = "technopol53";
    private final String password = "technopolisPassword";
    private final String name = "technopol53 technopol53";
    private final SelenideElement username = $(By.xpath("//div[@class='tico ellip']"));
    private final SelenideElement navigationToolBar = $(By.xpath("//div[@data-l='t,navigationToolbar']"));
    private final ElementsCollection navigationToolBarButtons = $$(By.xpath("//*[contains(@class,'toolbar_nav_a')]"));
    private final SelenideElement openMessengerButton = $(By.xpath("//*[@id='msg_toolbar_button']"));
    private final SelenideElement messengerTitle = $(By.xpath("//slot[@name='title']"));

    public MainPage openLogin() {
        LoginPage loginPage = new LoginPage();
        Selenide.open("/");
        loginPage.signIn(login, password);
        return this;
    }
    public void checkMainPage() {
        Assertions.assertEquals(name, username.getText());
        navigationToolBar.shouldBe();
        Assertions.assertEquals(8, navigationToolBarButtons.size());
    }
    public void clickMessenger() {
        openMessengerButton.click();
        messengerTitle.shouldBe();
        Assertions.assertEquals("Сообщения", messengerTitle.getText());
    }
}