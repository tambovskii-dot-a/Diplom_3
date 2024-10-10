import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.BurgersLoginPage;
import pages.BurgersMainPage;
import pages.BurgerRegistrationPage;
import pojo.RootUser;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.Matchers.is;


public class RegistrationSuccessTest extends BaseTest{
    BurgersMainPage mainPage = page(BurgersMainPage.class);
    BurgersLoginPage loginPage = page(BurgersLoginPage.class);
    BurgerRegistrationPage registrationPage = page(BurgerRegistrationPage.class);
    UserData data = new UserData(Constants.EMAIL,Constants.PASSWORD);
    RootUser user;
    BurgersRestClient client = new BurgersRestClient();

    @Before
    public void makeTstData() {
        open(Constants.BASE_URL);
    }
@After
public void cleanUp(){
    Selenide.closeWebDriver();
    client.deleteUser(user);

}
    @Test
    public void registrationSuccessTest(){
        mainPage.clickSignInButton();
        loginPage.clickRegButton();
        registrationPage.registration(Constants.NAME,Constants.EMAIL,Constants.PASSWORD);
        user = client.loginUser(data).body("success",is(true)).statusCode(200).extract().as(RootUser.class);
    }

}


