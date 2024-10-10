package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BurgerUserAreaPage {
    //page description text
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'В этом разделе вы можете изменить свои персональные данные')]")
    private SelenideElement pageDescriptionText;
    // Sign out button
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Выход')]")
    private SelenideElement signOutButton;

    @Step("Get discription user area page")
    public String getPageDescriptionText() {
        return pageDescriptionText.getText();
    }

    @Step("Click sign out")
    public void clickSignOutButton() {
        signOutButton.shouldBe(Condition.visible);
        signOutButton.click();
    }
}
