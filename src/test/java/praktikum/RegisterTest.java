package praktikum;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.Before;
import praktikum.generetorData.User;
import praktikum.generetorData.FakeUser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import praktikum.pages.LoginPage;
import praktikum.pages.RegistrationPage;
import praktikum.utils.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;
import static praktikum.utils.Endpoint.REGISTRATION_PAGE_URL;

@Epic("Проверяю возможность регистрации пользователя")
public class RegisterTest extends BaseTest {
    User user;
    LoginPage loginPage = page(LoginPage.class);

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
    @Story("Регистрация")
    @Test
    @DisplayName("Проверяю возможность регистрации нового пользователя с корректными данными")
    @Description("Тест корректной регистрации нового пользователя")
    @Severity(SeverityLevel.BLOCKER)
    public void checkingNewUserRegister() {
        user = FakeUser.creatingUserDataRandom();
        RegistrationPage registrationPage = openYandex(REGISTRATION_PAGE_URL, RegistrationPage.class);
        registrationPage.registration(user);

        assertTrue(loginPage.buttonLoginDisplayed());
        assertTrue(loginPage.inputEmailLoginDisplayed());
    }

    @Epic("UI Stellar Burgers")
    @Story("Регистрация")
    @Test
    @DisplayName("Проверяю возможность регистрации нового пользователя c некорректными данными: паролем")
    @Description("Тест не корректной регистрации нового пользователя")
    @Severity(SeverityLevel.NORMAL)
    public void checkingNewUserRegisterInvalidPassword() {
        user = FakeUser.creatingUserDataIncorrectPasswordRandom();
        RegistrationPage registrationPage = openYandex(REGISTRATION_PAGE_URL, RegistrationPage.class);
        registrationPage.registration(user);

        assertTrue(registrationPage.passwordInvalidErrorDisplayed());
    }
}
