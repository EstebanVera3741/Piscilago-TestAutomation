package piscilago.config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import piscilago.utils.PiscilagoManageDriver;

public class PiscilagoInit
{
    private PiscilagoManageDriver piscilagoManageDriver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeMethod(String browser)
    {
        this.piscilagoManageDriver = new PiscilagoManageDriver(browser);
        this.piscilagoManageDriver.getWebDriver().manage().window().maximize();
    }

    public WebDriver getPiscilagoManageDriver()
    {
        return piscilagoManageDriver.getWebDriver();
    }

//    @AfterMethod()
//    public void afterMethod()
//    {
//        this.piscilagoManageDriver.getWebDriver().close();
//    }
}