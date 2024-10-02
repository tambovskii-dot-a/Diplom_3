import org.junit.Before;
import org.junit.Test;
import pages.BurgersMainPage;


import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class BunsVisibilityTests extends BaseTest {
    BurgersMainPage mainPage = page(BurgersMainPage.class);

    @Before
    public void makeTstData() {
        open(Constants.BASE_URL);
        mainPage.clickSouseTab();
    }

    @Test
    public void bunTitleVisibilityTest() {

        mainPage.clickBunsTab();
        assertTrue(mainPage.bunsTitleIsVisible());

    }

}
