package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BurgersLoginPage {
    //Email field
    @FindBy(how = How.XPATH,using = "//*[contains(text(),'Email')]/../input")
    private SelenideElement emailField;
    //Password field
    @FindBy(how = How.XPATH,using = "//*[@class='input pr-6 pl-6 input_type_password input_size_default']/input")
    private SelenideElement pswdField;
    //Sign in button
    @FindBy(how = How.XPATH,using = "//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement signInButton;
    //Registration button
    @FindBy(how = How.XPATH,using = "//*[contains(text(),'Зарегистрироваться')]")
    private SelenideElement regButton;
    //Forgot password button
    @FindBy(how = How.XPATH,using = "//p[contains(text(),'Забыли пароль?')]/*[contains(text(),'Восстановить пароль')]")
    private SelenideElement forgotPswd;
    // container title Login
    @FindBy(how = How.XPATH,using = "//*[@class='Auth_login__3hAey']/*[contains(text(),'Вход')]")
    private SelenideElement signInContainerTitle;
    @Step("Set Email field")
    public void setEmailField(String email){
        emailField.shouldBe(Condition.editable);
        emailField.setValue(email);
    }
    @Step("Set password field")
    public void setPswdField(String password){
        pswdField.shouldBe(Condition.editable);
        pswdField.setValue(password);
    }
    @Step("Sign in method: Set fields and click sign in")
    public void signIn(String email,String password){
        setEmailField(email);
        setPswdField(password);
        signInButton.click();
    }
    @Step("Click registration")
    public void clickRegButton(){
        regButton.click();
    }
    @Step("Click forgot password")
    public void clickForgotPswd(){
        forgotPswd.click();
    }
    @Step("Get text from titile ")
    public String titleSignInGetText(){
        return signInContainerTitle.getText();
    }
}
