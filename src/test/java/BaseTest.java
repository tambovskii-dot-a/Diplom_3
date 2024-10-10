import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;

public class BaseTest extends DriverFactory {
    @BeforeClass
    public static void setUp() {
        DriverFactory.initDriver();
        Configuration.timeout = 10000;

    }

}
