import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import pojo.RootUser;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;

public class TakeUserAreaAfterLoginTest extends BaseTest{
    BurgersMainPage mainPage = page(BurgersMainPage.class);
    BurgersLoginPage loginPage = page(BurgersLoginPage.class);
    BurgerUserAreaPage userAreaPage = page(BurgerUserAreaPage.class);
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
    }

    @After
    public void cleanUp() {
        user = client.loginUser(data).extract().as(RootUser.class);
        client.deleteUser(user);
    }
    @Test
    public void takeUserAreaAfterLogin(){
        header.clickUserAreaButton();
        String EXPECTED_RESULT = "В этом разделе вы можете изменить свои персональные данные";
        assertEquals(EXPECTED_RESULT,userAreaPage.getPageDescriptionText());
    }
}
