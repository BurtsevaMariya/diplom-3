package praktikum;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import praktikum.generetorData.User;
import praktikum.generetorData.FakeUser;
import praktikum.pages.MainPage;
import praktikum.pages.LoginPage;
import praktikum.pages.RegistrationPage;
import praktikum.pages.ForgotPassPage;

import io.qameta.allure.junit4.DisplayName;

import org.junit.*;
import praktikum.utils.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static praktikum.utils.Endpoint.MAIN_PAGE_URL;
import static praktikum.utils.Endpoint.REGISTRATION_PAGE_URL;

@Epic("Проверяю возможность переходов из личного кабинета")
public class ConstructorMoveCabinetTest extends BaseTest {
    static User user;
    MainPage mainPage = page(MainPage.class);

    @BeforeClass
    @Step("before class")
    public static void setUp() {
        clearBrowserCookies();
        Configuration.browserSize = "1920x1080";
        user = FakeUser.creatingUserDataRandom();
        RegistrationPage registrationPage = openYandex(REGISTRATION_PAGE_URL, RegistrationPage.class);
        registrationPage.registration(user);
        WebDriverRunner.closeWebDriver();
    }

    @After
    @Step("after")
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        WebDriverRunner.closeWebDriver();
    }

    @Epic("UI Stellar Burgers")
    @Story("Личный кабинет")
    @Test
    @DisplayName("Проверяю возможность перехода из личного кабинета в конструктор, кликом на лого stellar burgers")
    @Description("Тест перехода в конструктор пользователя по клику на лого")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingConstructorMoveLogoClick() {
        openYandex(MAIN_PAGE_URL, MainPage.class);
        page(MainPage.class)
                .clickButtonPageLogin();
        page(LoginPage.class)
                .login(user.getEmail(), user.getPassword());
        page(MainPage.class)
                .clickPersonalCabinetButton();
        page(ForgotPassPage.class)
                .clickLogo();

        assertTrue(mainPage.buttonCreateOrderEnabled());
    }

    @Epic("UI Stellar Burgers")
    @Story("Личный кабинет")
    @Test
    @DisplayName("Проверяю возможность перехода из личного кабинета в конструктор, кликом по кнопке конструктор")
    @Description("Тест перехода в конструктор пользователя по клику на кнопку конструктор")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckingConstructorMoveButtonClick() {
        openYandex(MAIN_PAGE_URL, MainPage.class);
        page(MainPage.class)
                .clickButtonPageLogin();
        page(LoginPage.class)
                .login(user.getEmail(), user.getPassword());
        page(MainPage.class)
                .clickPersonalCabinetButton();
        page(ForgotPassPage.class)
                .clickButtonConstructor();

        assertTrue(mainPage.buttonCreateOrderEnabled());
    }

    @Epic("UI Stellar Burgers")
    @Story("Личный кабинет")
    @Test
    @DisplayName("Проверяю возможность перехода по клику на личный кабинет в конструкторе")
    @Description("Тест перехода в личный кабинет пользователя")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingCabinetMove() {
        openYandex(MAIN_PAGE_URL, MainPage.class);
        page(MainPage.class)
                .clickButtonPageLogin();
        page(LoginPage.class)
                .login(user.getEmail(), user.getPassword());
        page(MainPage.class)
                .clickPersonalCabinetButton();
        ForgotPassPage forgotPassPage = page(ForgotPassPage.class);

        assertTrue(forgotPassPage.informTextAboutChangeDataDisplayed());
    }
}
