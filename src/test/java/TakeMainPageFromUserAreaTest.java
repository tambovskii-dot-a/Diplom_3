import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.BurgerHeader;
import pages.BurgersLoginPage;
import pages.BurgersMainPage;
import pojo.RootUser;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class TakeMainPageFromUserAreaTest extends BaseTest{
    BurgersMainPage mainPage = page(BurgersMainPage.class);
    BurgersLoginPage loginPage = page(BurgersLoginPage.class);
    BurgerHeader header = page(BurgerHeader.class);
    UserData data = new UserData(Constants.EMAIL,Constants.PASSWORD,Constants.NAME);
    RootUser user;
    BurgersRestClient client = new BurgersRestClient();

    @Before
    public void makeTestData() {
        client.createUser(data);
        open(Constants.BASE_URL);
        mainPage.clickSignInButton();
        loginPage.signIn(Constants.EMAIL,Constants.PASSWORD);
        header.clickUserAreaButton();
    }

    @After
    public void cleanUp() {
        user = client.loginUser(data).extract().as(RootUser.class);
        client.deleteUser(user);
        Selenide.closeWebDriver();
    }

    @Test
    public void takeMainPageFromLogo() {
        header.clickLogo();
        mainPage.constructorIsDisplayed();
    }

    @Test
    public void takeMainPageFromConstructor() {
        header.clickConstructorButton();
        mainPage.constructorIsDisplayed();
    }
}
