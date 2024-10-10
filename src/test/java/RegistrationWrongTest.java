import org.junit.Before;
import org.junit.Test;
import pages.BurgerRegistrationPage;
import pages.BurgersLoginPage;
import pages.BurgersMainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;

public class RegistrationWrongTest extends BaseTest{
    BurgersMainPage mainPage = page(BurgersMainPage.class);
    BurgersLoginPage loginPage = page(BurgersLoginPage.class);
    BurgerRegistrationPage registrationPage = page(BurgerRegistrationPage.class);
    @Before
    public void makeTstData() {
        open(Constants.BASE_URL);
    }
    @Test
    public void registrationWithShortPassword(){
        mainPage.clickSignInButton();
        loginPage.clickRegButton();
        registrationPage.registration(Constants.NAME,Constants.EMAIL,Constants.SHORT_PASSWORD);
        registrationPage.getIncorrectPswdNotifText();
        assertEquals("Некорректный пароль",registrationPage.getIncorrectPswdNotifText());
    }
}
