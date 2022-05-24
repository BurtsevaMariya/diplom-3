package praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import praktikum.utils.Endpoint;

public class LoginPage {
    public static final String URL = Endpoint.LOGIN_PAGE_URL;

    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    public SelenideElement buttonLogin;

    @FindBy(how = How.NAME, using = "name")
    public SelenideElement inputEmailLogin;

    @FindBy(how = How.NAME, using = "Пароль")
    public SelenideElement inputPassword;

    @Step("Отображение login")
    public boolean buttonLoginDisplayed() {
        buttonLogin.shouldBe(Condition.visible);
        return buttonLogin.isDisplayed();
    }

    @Step("Кликнуть login")
    public void clickButtonLogin() {
        buttonLogin.click();
    }

    @Step("Заполнить email для авторизации")
    public void setInputEmailLogin(String userEmail) {
        inputEmailLogin.sendKeys(userEmail);
    }

    @Step("Отображение email")
    public boolean inputEmailLoginDisplayed() {
        inputEmailLogin.shouldBe(Condition.visible);
        return inputEmailLogin.isDisplayed();
    }

    @Step("Заполнить пароль для авторизации")
    public void setInputPassword(String userPassword) {
        inputPassword.sendKeys(userPassword);
    }

    @Step("Заполнить поля почту, пароль и кликнуть кнопку войти")
    public void login(String userEmail, String userPassword) {
        setInputEmailLogin(userEmail);
        setInputPassword(userPassword);
        clickButtonLogin();
    }
}