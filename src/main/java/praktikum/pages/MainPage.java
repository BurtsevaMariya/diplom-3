package praktikum.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import praktikum.utils.Endpoint;

public class MainPage {
    public static final String URL = Endpoint.MAIN_PAGE_URL;

    //Подзаголовок Н2 Булки
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/main/section[1]/div[2]/h2[contains(text(),'Булки')]")
    private SelenideElement fluorBun;

    //Подзаголовок Н2 Соусы
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/main/section[1]/div[2]/h2[contains(text(),'Соусы')]")
    private SelenideElement sauce;

    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    public SelenideElement buttonBunsClick;

    @FindBy(how = How.CSS, using = ".tab_tab_type_current__2BEPc")
    public SelenideElement buttonClicked;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Соусы')]")
    private SelenideElement tabSauce;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Булки')]")
    private SelenideElement tabBuns;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/main/section[1]/div[2]/h2[contains(text(),'Начинки')]")
    private SelenideElement toppings;

    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    public SelenideElement buttonPageLogin;

    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    public SelenideElement buttonCreateOrder;

    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    public SelenideElement buttonPersonalOffice;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Начинки')]")
    private SelenideElement tabToppings;

    @Step("Отображение кнопки оформить заказ")
    public boolean buttonCreateOrderEnabled() {
        return buttonCreateOrder.isEnabled();
    }

    @Step("Отображение первой булки в списке")
    public boolean topBunDisplayed() {
        fluorBun.shouldBe(Condition.exist);
        return this.fluorBun.isDisplayed();
    }

    @Step("Нажатие на соусы, в конструкторе")
    public void clickSauce() {
        tabSauce.shouldBe(Condition.exist).click();
    }

    @Step("Отображение первого соуса в списке")
    public boolean topSauceDisplayed() {
        return this.sauce.isDisplayed();
    }

    @Step("Отображение первой начинки в списке")
    public boolean checkTopTopping() {
        return this.toppings.isDisplayed();
    }

    @Step("Нажатие по кнопке войти в аккаунт")
    public void clickButtonPageLogin() {
        buttonPageLogin.click();
    }

    @Step("Нажатие на начинки, в конструкторе")
    public void clickToppings() {
        tabToppings.shouldBe(Condition.exist).click();
    }

    @Step("Нажатие на кнопку Булки в конструкторе")
    public void clickBuns() {
        tabBuns.shouldBe(Condition.exist).click();
    }

    @Step("Нажатие кнопки Личный кабинет")
    public void clickPersonalCabinetButton() {
        buttonPersonalOffice.click();
    }
}
