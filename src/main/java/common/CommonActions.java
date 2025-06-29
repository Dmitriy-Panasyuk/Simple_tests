package common;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.demoqa.URLs;

import static common.Config.*;

public class CommonActions {
    private static WebDriver driver;


    private static WebDriver createDriver() {
        System.out.println("==== Create WebDriver");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--incognito");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("-ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_WAIT);
        System.out.println("==== Current HOME = " + URLs.HOME);
        System.out.println("==== Implicit Wait Timeout: " + driver.manage().timeouts().getImplicitWaitTimeout().getSeconds() + " sec");
        System.out.println("==== Page Load Timeout: " + driver.manage().timeouts().getPageLoadTimeout().getSeconds() + " sec");
        System.out.println("==== Element Visible Timeout: " + ELEMENT_VISIBLE_WAIT.getSeconds() + " sec");
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println("Driver not found. Create new driver.");
            return createDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception ex) {
            System.out.println("Error closing driver window ");
            System.out.println(ex.getMessage());
        }
    }
}
