import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import pojo.RootUser;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.*;

public class LoginTests extends BaseTest{
    BurgersMainPage mainPage = page(BurgersMainPage.class);
    BurgersLoginPage loginPage = page(BurgersLoginPage.class);
    BurgerRegistrationPage registrationPage = page(BurgerRegistrationPage.class);
    BurgerPasswordRecoveryPage passwordRecoveryPage = page(BurgerPasswordRecoveryPage.class);
    BurgerHeader header = page(BurgerHeader.class);
    UserData data = new UserData(Constants.EMAIL,Constants.PASSWORD,Constants.NAME);
    RootUser user;
    BurgersRestClient client = new BurgersRestClient();

    @Before
    public void makeTestData() {
        open(Constants.BASE_URL);
        client.createUser(data);
    }

    @After
    public void cleanUp() {
        Selenide.closeWebDriver();
        user = client.loginUser(data).extract().as(RootUser.class);
        client.deleteUser(user);
    }

    @Test
    public void loginWithMainPage() {
        mainPage.clickSignInButton();
        loginPage.signIn(Constants.EMAIL,Constants.PASSWORD);
        assertEquals("Оформить заказ", mainPage.OrderButtonGetText());
    }

    @Test
    public void loginWithUserAreaPage() {
        header.clickUserAreaButton();
        loginPage.signIn(Constants.EMAIL,Constants.PASSWORD);
        assertEquals("Оформить заказ", mainPage.OrderButtonGetText());
    }
    @Test
    public void loginWithRegistrationPage(){
        mainPage.clickSignInButton();
        loginPage.clickRegButton();
        registrationPage.clickSignInButton();
        loginPage.signIn(Constants.EMAIL,Constants.PASSWORD);
        assertEquals("Оформить заказ", mainPage.OrderButtonGetText());
    }
    @Test
    public void LoginWithForgotPasswordPage(){
        mainPage.clickSignInButton();
        loginPage.clickForgotPswd();
        passwordRecoveryPage.clickSignInButton();
        loginPage.signIn(Constants.EMAIL,Constants.PASSWORD);
        assertEquals("Оформить заказ", mainPage.OrderButtonGetText());
    }

}
