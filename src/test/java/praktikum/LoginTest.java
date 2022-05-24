package praktikum;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import praktikum.generetorData.User;
import praktikum.generetorData.FakeUser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import praktikum.pages.MainPage;
import praktikum.pages.LoginPage;
import praktikum.pages.RegistrationPage;
import praktikum.pages.RestorePassPage;
import praktikum.utils.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static praktikum.utils.Endpoint.*;

@Epic("Проверяю возможность входа пользователя")
public class LoginTest extends BaseTest {
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
    @Story("Авторизация")
    @Test
    @DisplayName("Проверяю возможность входа по кнопке войти, в аккаунт, на главной")
    @Description("Тест корректной авторизации нового пользователя по кнопке войти в аккаунт")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingUserLoginClickAccountButton() {
        openYandex(MAIN_PAGE_URL, MainPage.class);
        page(MainPage.class)
                .clickButtonPageLogin();
        page(LoginPage.class)
                .login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.buttonCreateOrderEnabled());
    }

    @Epic("UI Stellar Burgers")
    @Story("Авторизация")
    @Test
    @DisplayName("Проверяю возможность входа через кнопку личный кабинет")
    @Description("Тест корректной авторизации нового пользователя по кнопке личный кабинет")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingUserLoginClickPersonalCabinetButton() {
        openYandex(MAIN_PAGE_URL, MainPage.class);
        page(MainPage.class)
                .clickPersonalCabinetButton();
        page(LoginPage.class)
                .login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.buttonCreateOrderEnabled());
    }

    @Epic("UI Stellar Burgers")
    @Story("Авторизация")
    @Test
    @DisplayName("Проверяю возможность входа через форму регистрации")
    @Description("Тест корректной авторизации нового пользователя по ссылке из формы регистрации")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingUserLoginClickButtonRegisterPage() {
        openYandex(REGISTRATION_PAGE_URL, RegistrationPage.class);
        page(RegistrationPage.class)
                .clickButtonPageLogin();
        page(LoginPage.class)
                .login(user.getEmail(), user.getPassword());

        assertTrue(mainPage.buttonCreateOrderEnabled());
    }

    @Epic("UI Stellar Burgers")
    @Story("Авторизация")
    @Test
    @DisplayName("Проверяю возможность входа через кнопку в форме восстановления пароля")
    @Description("Тест корректной авторизации нового пользователя по ссылке из формы восстановления пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingUserLoginClickButtonPasswordPage() {
        openYandex(RESTORE_PASS_PAGE_URL, RestorePassPage.class);
        page(RestorePassPage.class)
                .clickButtonLogin();
        page(LoginPage.class)
                .login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.buttonCreateOrderEnabled());
    }
}
