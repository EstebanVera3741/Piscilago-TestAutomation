package piscilago.runnes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import piscilago.config.PiscilagoBase;
import piscilago.pages.PiscilagoHomePage;
import piscilago.response.IPiscilagoResponse;

import java.util.*;

public class PiscilagoHomeRunner extends PiscilagoBase
{
    private final WebDriver webDriver;
    private final PiscilagoHomePage piscilagoHomePage;

    public PiscilagoHomeRunner(WebDriver webDriver)
    {
        super(webDriver);
        this.webDriver = webDriver;
        this.piscilagoHomePage = new PiscilagoHomePage(webDriver);
    }

    public void navigateCorrectly(String link)
    {
        getWebDriver().get(link);
    }

    public boolean searchPagePiscilago(String linkMain)
    {
        navigateCorrectly(linkMain);
        WebElement webElement = this.piscilagoHomePage.getSearchMainVideo();
        waitElementVisibility(webElement);

        return webElement.isDisplayed();
    }

    public boolean navBarPiscilago(String linkMain, String textNavBar)
    {
        navigateCorrectly(linkMain);

        List<String> linkList = Arrays.asList(textNavBar.split(","));

        Set<String> setStrings = new HashSet<>(linkList);
        for (String link : linkList)
        {
            setStrings.add(link.toUpperCase().trim());
        }

        List<WebElement> listWebElement = this.piscilagoHomePage.getSearchListNavBar();
        for (WebElement webElement : listWebElement)
        {
            waitElementVisibility(webElement);
            if (!setStrings.contains(webElement.getText().toUpperCase().trim()))
            {
                return false;
            }
        }
        return true;
    }

    public boolean viewOfferPiscilago(String linkMain, String textMessage)
    {
        navigateCorrectly(linkMain);

        WebElement titleElement = this.piscilagoHomePage.getSearchTitlesOffer();
        waitElementVisibility(titleElement);
        String title = titleElement.getText().replaceAll("\\r\\n|\\r|\\n|\\s+", " ").trim();

        boolean isTitleCorrect = title.equals(textMessage.trim());

        List<WebElement> listWebElement = this.piscilagoHomePage.getSearchListCardsOffer();
        waitListElementVisibility(listWebElement);

        int expectedSize = 3;
        boolean isOfferListSizeCorrect = listWebElement.size() == expectedSize;

        return isTitleCorrect && isOfferListSizeCorrect;
    }

    public boolean celebrationSection(String linkMain, String textTitleCelebration)
    {
        navigateCorrectly(linkMain);

        WebElement webElement = this.piscilagoHomePage.getSearchTitleCelebration();
        waitElementVisibility(webElement);

        return webElement.getText().trim().equals(textTitleCelebration.trim());
    }

    public boolean celebrationPage(String linkMain, String textTitleCelebrationPage)
    {
        navigateCorrectly(linkMain);

        WebElement webElement = this.piscilagoHomePage.getSearchBottomCelebrationSpecial();
        waitElementVisibility(webElement);
        webElement.click();

        return new PiscilagoCelebrationRunner(webDriver).titleIsCorrect(textTitleCelebrationPage);
    }

    public boolean wherePiscilagoSection(String linkMain, String textTitle, String listTextTitle)
    {
        navigateCorrectly(linkMain);

        WebElement webElement = this.piscilagoHomePage.getSearchTitleWherePiscilago();
        waitElementVisibility(webElement);

        String title = webElement.getText().trim().replaceAll("\\r\\n|\\r|\\n|\\s+", " ");

        List<WebElement> listWebElement = this.piscilagoHomePage.getSearchListCardWherePiscilago();
        waitListElementVisibility(listWebElement);

        if (listWebElement.size() != 4 || !title.trim().equals(textTitle.trim()))
        {
            return false;
        }

        List<String> linkList = Arrays.asList(listTextTitle.split(","));

        Set<String> setStrings = new HashSet<>(linkList);
        for (String link : linkList)
        {
            setStrings.add(link.toUpperCase().trim());
        }

        for (WebElement element: listWebElement)
        {
            if (!setStrings.contains(element.getText().toUpperCase().trim()))
            {
                return false;
            }
        }
        return true;
    }
}