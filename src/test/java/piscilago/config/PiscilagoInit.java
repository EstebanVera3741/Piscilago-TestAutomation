package piscilago.config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import piscilago.runnes.PiscilagoHomeRunner;
import piscilago.utils.PiscilagoManageDriver;

public class PiscilagoInit
{
    private PiscilagoManageDriver piscilagoManageDriver;
    private PiscilagoHomeRunner piscilagoHomeRunner;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeMethod(String browser)
    {
        this.piscilagoManageDriver = new PiscilagoManageDriver(browser);
        this.piscilagoManageDriver.getWebDriver().manage().window().maximize();
        WebDriver webDriver = this.piscilagoManageDriver.getWebDriver();

        this.piscilagoHomeRunner = new PiscilagoHomeRunner(webDriver);
    }

    public PiscilagoManageDriver getPiscilagoManageDriver()
    {
        return piscilagoManageDriver;
    }

    public PiscilagoHomeRunner getPiscilagoHomeRunner()
    {
        return piscilagoHomeRunner;
    }

    @AfterMethod()
    public void afterMethod()
    {
        this.piscilagoManageDriver.getWebDriver().close();
    }
}