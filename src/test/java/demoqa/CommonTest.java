package demoqa;

import common.CommonActions;
import io.qameta.allure.Step;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

import static utils.AllureTools.*;

@Test(priority = 0)
public class CommonTest {
    @BeforeSuite
    @Step("До всего")
    public void beforeSuite() {
        deleteResultDir();
        createResultDir();
        deleteTemptDir();
        createTemptDir();
    }

    @AfterSuite
    @Step("После всего")
    public void afterSuite() throws IOException {
        CommonActions.closeDriver();
        createHTML();
    }
}
