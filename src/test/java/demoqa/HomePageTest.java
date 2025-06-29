package demoqa;

import io.qameta.allure.*;
import listeners.Listner;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.demoqa.LoginPage;
import roles.DemoQaUser;

import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static utils.AllureAttachmentTools.attachScreenshotPNG;

@Test(enabled = true, priority = 2)
@Listeners({Listner.class})
public class HomePageTest {


    @Test(enabled = true, description = "Логин", priority = 2003)
    @Description("Тест логинится")
    @Step("Логин")
    @Severity(NORMAL)
    @Feature("Smoke тесты")
    @Story("Простые тесты")
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.open().sendLogin(DemoQaUser.testUser.login()).sendPassword(DemoQaUser.testUser.password()).submitLogin();
        assertTrue(loginPage.equalsUserName(DemoQaUser.testUser.login()));
        attachScreenshotPNG();
    }


}
