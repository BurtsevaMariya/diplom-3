package praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import praktikum.generetorData.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import praktikum.utils.Endpoint;

public class RegistrationPage {
    public static final String URL = Endpoint.REGISTRATION_PAGE_URL;

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    public SelenideElement buttonPageLogin;

    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    public SelenideElement inputFillingName;

    @FindBy(how = How.XPATH, using = "(//input[@name='name'])[2]")
    public SelenideElement inputEmail;

    @FindBy(how = How.NAME, using = "Пароль")
    public SelenideElement inputPassword;

    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    public SelenideElement buttonRegister;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    public SelenideElement passwordInvalidError;

    @Step("Клик на кнопку Личный кабинет")
    public void clickButtonPageLogin() {
        buttonPageLogin.click();
    }

    @Step("Ввод в поле Имя")
    public void enteringFileName(String userName) {
        inputFillingName.sendKeys(userName);
    }

    @Step("Ввод в поле Почта")
    public void enteringFileEmail(String userEmail) {
        inputEmail.sendKeys(userEmail);
    }

    @Step("Ввод в поле Пароль")
    public void enteringFilePassword(String userPassword) {
        inputPassword.sendKeys(userPassword);
    }

    @Step("Клик на кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        buttonRegister.click();
    }

    @Step("Отображение ошибки о невалидном пароле")
    public boolean passwordInvalidErrorDisplayed() {
        return passwordInvalidError.isDisplayed();
    }

    @Step("Заполнить поля Имени, Почты, Пароля и кликнуть на кнопку Регистрация")
    public void registration(User user) {
        enteringFileName(user.getName());
        enteringFileEmail(user.getEmail());
        enteringFilePassword(user.getPassword());
        clickRegisterButton();
    }
}
