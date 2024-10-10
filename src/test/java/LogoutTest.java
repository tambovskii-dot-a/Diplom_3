import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import pojo.RootUser;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;


public class LogoutTest extends BaseTest{
    BurgersMainPage mainPage = page(BurgersMainPage.class);
    BurgersLoginPage loginPage = page(BurgersLoginPage.class);
    BurgerUserAreaPage userAreaPage = page(BurgerUserAreaPage.class);
    BurgerHeader header = page(BurgerHeader.class);
    UserData data = new UserData(Constants.EMAIL,Constants.PASSWORD,Constants.NAME);
    RootUser user;
    BurgersRestClient client = new BurgersRestClient();

    @Before
    public void makeTestData() {
        open(Constants.BASE_URL);
        client.createUser(data);
        mainPage.clickSignInButton();
        loginPage.signIn(Constants.EMAIL,Constants.PASSWORD);
        header.clickUserAreaButton();
        userAreaPage.clickSignOutButton();
    }
    @After
    public void cleanUp() {
        Selenide.closeWebDriver();
        user = client.loginUser(data).extract().as(RootUser.class);
        client.deleteUser(user);
    }

    @Test
    public void logoutTest(){
        assertEquals("Вход",loginPage.titleSignInGetText());
    }
}
