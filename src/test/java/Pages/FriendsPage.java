package Pages;

import static com.codeborne.selenide.Condition.visible;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class FriendsPage implements BasePage {
    private static final By listOfFriends = By.xpath("//*[@id=\"hook_Block_MyFriendsSquareCardsPagingB\"]//*[@class=\"stub-empty_t\"]");
    private static final By searchFriends = By.xpath("//div[@class='friends-menu-search __expanding __wider']");

    public FriendsPage(){
        check();
    }
    public void check(){
        $(searchFriends).shouldBe(visible.because("Поиск друзей должен быть на странице"));
    }
    public String listOfFriends(){
        return $(listOfFriends).shouldBe(visible).getText();
    }
}