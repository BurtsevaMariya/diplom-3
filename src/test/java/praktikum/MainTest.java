package praktikum;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import praktikum.pages.MainPage;
import praktikum.utils.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;
import static praktikum.utils.Endpoint.MAIN_PAGE_URL;

@Epic("Проверяю возможность сборки бургера")
public class MainTest extends BaseTest {
    MainPage mainPage = page(MainPage.class);

    @Before
    @Step("before")
    public void setUp() {
        clearBrowserCookies();
        Configuration.browserSize = "1920x1080";
    }

    @After
    @Step("after")
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        WebDriverRunner.closeWebDriver();
    }

    @Epic("UI Stellar Burgers")
    @Story("Конструктор")
    @Test
    @DisplayName("Проверяю возможность, что по дефолту открыта вкладка булки")
    @Description("Тест открытия вкладки булки, по дефолту")
    @Severity(SeverityLevel.NORMAL)
    public void checkingBunsTabTest() {
        MainPage mainPage = openYandex(MAIN_PAGE_URL, MainPage.class);
        boolean isBun = mainPage.topBunDisplayed();

        assertTrue("По дефолту открыта вкладка булки", isBun);
    }

    @Epic("UI Stellar Burgers")
    @Story("Конструктор")
    @Test
    @DisplayName("Проверяю возможность, успешного перехода на вкладку соусы")
    @Description("Тест переключения на вкладку соусы")
    @Severity(SeverityLevel.NORMAL)
    public void checkingGoSauceTabTest() {
        openYandex(MAIN_PAGE_URL, MainPage.class);
        page(MainPage.class)
                .clickSauce();
        boolean isSauce = mainPage.topSauceDisplayed();

        assertTrue("Открыта вкладка соусы", isSauce);
    }

    @Epic("UI Stellar Burgers")
    @Story("Конструктор")
    @Test
    @DisplayName("Проверяю возможность, успешного перехода на вкладку начинки")
    @Description("Тест переключения на вкладку начинки")
    @Severity(SeverityLevel.NORMAL)
    public void checkingGoToppingTabTest() {
        openYandex(MAIN_PAGE_URL, MainPage.class);
        page(MainPage.class)
                .clickToppings();
        boolean isTopping = mainPage.checkTopTopping();

        assertTrue("Открыта вкладка начинки", isTopping);
    }

    @Epic("UI Stellar Burgers")
    @Story("Конструктор")
    @Test
    @DisplayName("Проверяю возможность, успешного перехода на вкладку Булки из других вкладок")
    @Description("Тест переключения на вкладку булки")
    @Severity(SeverityLevel.NORMAL)
    public void checkingGoBunTabTest() {
        openYandex(MAIN_PAGE_URL, MainPage.class);
        page(MainPage.class)
                .clickToppings();
        sleep(400);
        page(MainPage.class)
                .clickBuns();
        boolean isBun = mainPage.topBunDisplayed();

        assertTrue("Открыта вкладка булки", isBun);
    }
}