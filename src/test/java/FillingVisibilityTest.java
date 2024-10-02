import org.junit.Before;
import org.junit.Test;
import pages.BurgersMainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class FillingVisibilityTest extends BaseTest{
    BurgersMainPage mainPage = page(BurgersMainPage.class);

    @Before
    public void makeTstData() {
        open(Constants.BASE_URL);
        mainPage.clickSouseTab();
        mainPage.clickFillingTab();
    }

    @Test
    public void fillingTitleVisibilityTest() {
        assertTrue(mainPage.fillingTitleIsVisible());

    }
}
