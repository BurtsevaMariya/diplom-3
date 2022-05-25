package praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import praktikum.utils.Endpoint;

public class RestorePassPage {
    public static final String URL = Endpoint.RESTORE_PASS_PAGE_URL;

    @FindBy(how = How.LINK_TEXT, using = "Войти")
    public SelenideElement buttonLogin;

    @Step("Нажатие на кнопку войти, страница восстановления пароля")
    public void clickButtonLogin() {
        buttonLogin.click();
    }
}