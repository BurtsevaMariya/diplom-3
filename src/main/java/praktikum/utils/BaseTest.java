package praktikum.utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public void setupYandexBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/mariy/Desktop/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setBinary("C:/Users/mariy/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        ChromeDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }

    public <PageObjectClass> PageObjectClass openChrome(String relativeOrAbsoluteUrl, Class<PageObjectClass> pageObjectClassClass) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);

        return open(relativeOrAbsoluteUrl, pageObjectClassClass);
    }

    public static <PageObjectClass> PageObjectClass openYandex(String relativeOrAbsoluteUrl, Class<PageObjectClass> pageObjectClassClass) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/mariy/Desktop/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setBinary("C:/Users/mariy/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        ChromeDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);

        return open(relativeOrAbsoluteUrl, pageObjectClassClass);
    }
}