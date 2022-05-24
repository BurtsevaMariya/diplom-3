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
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import praktikum.utils.BaseTest;


import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static praktikum.utils.Endpoint.LOGIN_PAGE_URL;
import static praktikum.utils.Endpoint.REGISTRATION_PAGE_URL;

@Epic("Проверяю возможность выхода пользователя")
public class ExitTest extends BaseTest {
    static User user;

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
    @DisplayName("Проверяю возможность выхода кнопкой выйти, в личном кабинете")
    @Description("Выход пользователя из аккаунта")
    @Severity(SeverityLevel.CRITICAL)
    public void checkingUserLogout() {
        openYandex(LOGIN_PAGE_URL, LoginPage.class);
        page(LoginPage.class)
                .login(user.getEmail(), user.getPassword());
        page(MainPage.class)
                .clickPersonalCabinetButton();
        page(ForgotPassPage.class)
                .clickButtonExit();
        sleep(500);
        LoginPage loginPage = page(LoginPage.class);

        assertTrue(loginPage.inputEmailLoginDisplayed());
    }
}
