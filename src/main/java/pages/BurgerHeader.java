package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BurgerHeader {
    //User area button
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement userAreaButton;
    //Logo
    @FindBy(how = How.XPATH, using = "//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;
    //Constructor
    @FindBy(how = How.XPATH, using = "//*[@class='AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo']")
    private SelenideElement constructorButton;

    @Step("Click user area ")
    public void clickUserAreaButton() {
        userAreaButton.click();
    }

    @Step("Click logo")
    public void clickLogo() {
        logo.click();
    }

    @Step("Click constructor")
    public void clickConstructorButton() {
        constructorButton.click();
    }
}
