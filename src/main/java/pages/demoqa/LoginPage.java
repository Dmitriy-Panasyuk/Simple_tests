package pages.demoqa;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;

import static common.CommonActions.getDriver;

public class LoginPage implements Page {
    public static String url = URLs.LOGIN;

    public LoginPage() {
    }

    By loginLoc = By.id("userName");
    By passwordLoc = By.id("password");
    By loginButtonLoc = By.id("login");
    By userName = By.id("userName-value");

    @Override
    public LoginPage open() {
        return Allure.step("Открыть страницу", step -> {
            step.parameter("URL", url);
            getDriver().get(url);
            return this;
        });
    }

    public LoginPage sendLogin(String username) {
        return Allure.step("Ввод логина", step -> {
            step.parameter("Логин", username);
            getDriver().findElement(loginLoc).sendKeys(username);
            return this;
        });
    }

    public LoginPage sendPassword(String password) {
        return Allure.step("Ввод пароля", step -> {
            step.parameter("Пароль", password);
            getDriver().findElement(passwordLoc).sendKeys(password);
            return this;
        });
    }

    public HomePage submitLogin() {
        return Allure.step("Подтвердить логин", step -> {
            getDriver().findElement(loginButtonLoc).click();
            return new HomePage();
        });
    }
    public boolean equalsUserName(String username) {
        return Allure.step("Проверить совпадение пользователя", step -> {
            step.parameter("Ожидаемый логин", username);
            String actualLogin = getDriver().findElement(userName).getText();
            step.parameter("Фактический логин", actualLogin);
            return actualLogin.equals(username) ;
        });
    }
}
