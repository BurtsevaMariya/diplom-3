package praktikum.generetorData;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class FakeUser {
    static Faker faker = new Faker();

    @Step("Создание данных пользователя")
    public static User creatingUserDataRandom() {
        final String userEmail = faker.internet().emailAddress();
        final String userPassword = faker.internet().password(6, 8, true);
        final String userName = faker.name().username();
        Allure.addAttachment("Email: ", userEmail);
        Allure.addAttachment("Пароль: ", userPassword);
        Allure.addAttachment("Имя: ", userName);
        return new User(userEmail, userPassword, userName);
    }

    @Step("Создание данных пользователя c невалидным паролем")
    public static User creatingUserDataIncorrectPasswordRandom() {
        final String userEmail = faker.internet().emailAddress();
        final String userPassword = faker.internet().password(3, 5, true);
        final String userName = faker.name().username();
        Allure.addAttachment("Email: ", userEmail);
        Allure.addAttachment("Пароль: ", userPassword);
        Allure.addAttachment("Имя: ", userName);
        return new User(userEmail, userPassword, userName);
    }
}
