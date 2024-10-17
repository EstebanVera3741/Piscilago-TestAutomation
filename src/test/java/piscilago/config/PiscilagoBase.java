package piscilago.config;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import piscilago.utils.response.IPiscilagoResponse;

import java.time.Duration;
import java.util.*;

public class PiscilagoBase
{
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    private final HashMap<String, String> listAllWindows;

    public PiscilagoBase(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        this.listAllWindows = new HashMap<String, String>();
    }

    public WebDriver getWebDriver()
    {
        return this.webDriver;
    }

    public WebDriverWait getWebDriverWait()
    {
        return this.webDriverWait;
    }

    public void serviceNavigateCorrectly(String link)
    {
        getWebDriver().get(link);
    }

    public void serviceAddWindow(String nameClass)
    {
        Set<String> windows = getWebDriver().getWindowHandles();
        List<String> listWindows = new ArrayList<>(windows);

        String lastElement = listWindows.getLast();

        if (!this.listAllWindows.containsKey(nameClass)) {
            this.listAllWindows.put(nameClass, lastElement);
        }
    }

    public void serviceSelectWindow(String className)
    {
        if (listAllWindows.containsKey(className)) {
            String valor = listAllWindows.get(className);
            getWebDriver().switchTo().window(valor);
        } else {
            throw new RuntimeException(IPiscilagoResponse.PISCILAGO_FAIL_WINDOW + className);
        }
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