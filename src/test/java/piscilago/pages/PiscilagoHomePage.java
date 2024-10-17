package piscilago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import piscilago.config.PiscilagoBase;

import java.util.List;
import java.util.Set;

public class PiscilagoHomePage extends PiscilagoBase
{
    @FindBy(css = "ul > li.css-l4dqbs")
    private List<WebElement> elementListNavBar;
    @FindBy(css = ".css-u0shxb > .css-kmyh9k > .css-79elbk > ul > li.css-a4tr26")
    private List<WebElement> elementListSubNavBar;
    @FindBy(css = ".css-u0shxb")
    private WebElement elementSubNavBar;

    public PiscilagoHomePage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public void serviceClickNavBar(Integer navBar)
    {
        waitListElementVisibility(this.elementListNavBar);
        this.elementListNavBar.get(navBar).click();
    }

    public void serviceClickSubNavBar(Integer subNavBar)
    {
        waitElementVisibility(this.elementSubNavBar);
        this.elementListSubNavBar.get(subNavBar).click();
    }
}