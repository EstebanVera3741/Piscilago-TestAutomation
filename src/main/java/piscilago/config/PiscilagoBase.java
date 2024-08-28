package piscilago.config;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import piscilago.response.IPiscilagoResponse;

import java.time.Duration;
import java.util.List;

public class PiscilagoBase
{
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public PiscilagoBase(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
    }

    public WebDriver getWebDriver()
    {
        return this.webDriver;
    }

    public WebDriverWait getWebDriverWait()
    {
        return this.webDriverWait;
    }

    public void waitElementVisibility(WebElement webElement)
    {
        try
        {
            getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        }
        catch (TimeoutException e)
        {
            System.out.println(IPiscilagoResponse.PISCILAGO_FAIL_TIMEOUT + e.getMessage());
        }
    }

    public void waitListElementVisibility(List<WebElement> listWebElement)
    {
        try
        {
            getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(listWebElement));
        }
        catch (TimeoutException e)
        {
            System.out.println(IPiscilagoResponse.PISCILAGO_FAIL_TIMEOUT + e.getMessage());
        }
    }
}