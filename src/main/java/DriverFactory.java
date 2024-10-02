import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static void initDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();

        switch (browser) {
            case "chrome":
                setChromeDriver();
                break;
            case "yandex":
                setYandexDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private static void setChromeDriver() {
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");


        Configuration.browserCapabilities = options;
    }

    private static void setYandexDriver() {
        // Вторым аргументом указать путь к драйверу
        System.setProperty("webdriver.chrome.driver", "/Users/tambovskii/Documents/yandexdriver");
        ChromeOptions options = new ChromeOptions();
        //Указать путь к браузеру
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
    }
}
