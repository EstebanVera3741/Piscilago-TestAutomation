package piscilago.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PiscilagoManageDriver
{
    private WebDriver webDriver;

    public PiscilagoManageDriver(String browser)
    {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
        this.webDriver = new ChromeDriver();
    }

    public WebDriver getWebDriver()
    {
        return this.webDriver;
    }
}