package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BurgerRegistrationPage {
    //Name field
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Имя')]/../input")
    private SelenideElement nameField;
    //Email field
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Email')]/../input")
    private SelenideElement emailField;
    //password field
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Пароль')]/../input")
    private SelenideElement pswdField;
    //Registration button
    @FindBy(how = How.XPATH, using = "//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement regButton;
    //Incorrect password notification
    @FindBy(how = How.XPATH, using = "//*[@class='input__error text_type_main-default']")
    private SelenideElement incorrectPswdNotif;
    //Sign in Button
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Уже зарегистрированы?')]/a[contains(text(),'Войти')]")
    private SelenideElement signInButton;

    @Step("Set value name field")
    public void setNameField(String name) {
        nameField.setValue(name);
    }

    @Step("Set value email field")
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    @Step("Set value password field")
    public void setPswdField(String password) {
        pswdField.setValue(password);
    }

    @Step("registration method: set fields and click registration button")
    public void registration(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPswdField(password);
        regButton.click();
    }

    @Step("Get text from error(short password)")
    public String getIncorrectPswdNotifText() {
        incorrectPswdNotif.shouldBe(Condition.visible);
        return incorrectPswdNotif.getText();
    }

    @Step("Click sign in")
    public void clickSignInButton() {
        signInButton.click();
    }
}
