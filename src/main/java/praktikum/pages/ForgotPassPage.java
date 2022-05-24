package praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import praktikum.utils.Endpoint;

public class ForgotPassPage {
    public static final String URL = Endpoint.FORGOT_PASS_PAGE_URL;

    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    public SelenideElement buttonConstructor;

    @FindBy(how = How.CSS, using = "div#root>div>header>nav")
    public SelenideElement logo;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'Account_button__14Yp3 text')]")
    public SelenideElement buttonExit;

    @FindBy(how = How.XPATH, using = "//p[text()='В этом разделе вы можете изменить свои персональные данные']")
    public SelenideElement informTextAboutChangeData;

    @Step("Нажатие на конструктор, в личном кабинете")
    public void clickButtonConstructor() {
        buttonConstructor.click();
    }

    @Step("Нажатие на ЛОГО, в Личном Кабинете")
    public void clickLogo() {
        logo.click();
    }

    @Step("Нажатие на кнопку конструктор, в личном кабинете")
    public void clickButtonExit() {
        buttonExit.click();
    }

    @Step("Отображение информационного текста личного кабинета")
    public boolean informTextAboutChangeDataDisplayed() {
        informTextAboutChangeData.shouldBe(Condition.visible);
        return informTextAboutChangeData.isDisplayed();
    }
}