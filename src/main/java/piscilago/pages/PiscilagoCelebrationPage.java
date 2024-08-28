package piscilago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import piscilago.config.PiscilagoBase;

public class PiscilagoCelebrationPage extends PiscilagoBase
{
    @FindBy(css = ".h2-styles")
    private WebElement searchTitlePage;

    public PiscilagoCelebrationPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public WebElement getSearchTitlePage()
    {
        return searchTitlePage;
    }
}