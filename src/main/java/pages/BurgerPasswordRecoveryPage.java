package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BurgerPasswordRecoveryPage {
    //sign in Button
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Вспомнили пароль?')]/*[contains(text(),'Войти')]")
    private SelenideElement signInButton;

    @Step("Click click in ")
    public void clickSignInButton() {
        signInButton.click();
    }
}
