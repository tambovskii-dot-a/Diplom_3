package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BurgersMainPage {
    //Sign in button
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Войти в аккаунт')]")
    private SelenideElement signInButton;
    //place an order button
    @FindBy(how = How.XPATH, using = "//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement orderButton;
    //Burger constructor container
    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__1N8v2")
    private SelenideElement burgerConstructor;
    // Buns Tab
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Булки')]/.")
    private SelenideElement bunsTab;
    // Souse Tab
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Соусы')]/.")
    private SelenideElement souseTab;
    // Filling Tab
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Начинки')]/.")
    private SelenideElement fillingTab;
    //Buns title
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Булки')]")
    private SelenideElement bunsTitle;
    //Souse title
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Соусы')]")
    private SelenideElement souseTTitle;
    //Filling title
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Начинки')]")
    private SelenideElement fillingTitle;
    // main modal div
    @FindBy(how = How.CLASS_NAME, using = "Modal_modal_overlay__x2ZCr")
    private SelenideElement mainModal;

    @Step("Click sign in")
    public void clickSignInButton() {
        mainModal.shouldBe(Condition.not(Condition.visible));
        signInButton.click();
    }

    @Step("Get text from order button")
    public String OrderButtonGetText() {
        return orderButton.getText();
    }

    @Step("check burgeg constructor into page")
    public boolean constructorIsDisplayed() {
        return burgerConstructor.isDisplayed();
    }

    @Step("click buns tab")
    public void clickBunsTab() {
        bunsTab.shouldBe(Condition.exist);
        bunsTab.click();
    }

    @Step("click souse tab")
    public void clickSouseTab() {
        souseTab.shouldBe(Condition.exist);
        souseTab.click();
    }

    @Step("click filling tab")
    public void clickFillingTab() {
        fillingTab.shouldBe(Condition.exist);
        fillingTab.click();
    }

    @Step("Check visible title ingredients")
    public boolean isElementInViewport(SelenideElement element) {
        return executeJavaScript("var elem = arguments[0]," +
                "  bounding = elem.getBoundingClientRect();" +
                "return (" + "  bounding.top >= 0 &&" +
                "  bounding.left >= 0 &&" +
                "  bounding.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&" +
                "  bounding.right <= (window.innerWidth || document.documentElement.clientWidth)" +
                ");", element);
    }

    @Step("check visible bun")
    public boolean bunsTitleIsVisible() {
        return isElementInViewport(bunsTitle);
    }

    @Step("check visible souse")

    public boolean souseTitleIsVisible() {
        return isElementInViewport(souseTTitle);
    }

    @Step("check visible filling")

    public boolean fillingTitleIsVisible() {
        return isElementInViewport(fillingTitle);
    }
}