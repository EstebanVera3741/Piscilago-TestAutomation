package piscilago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import piscilago.config.PiscilagoBase;

import java.util.List;

public class PiscilagoHomePage extends PiscilagoBase
{
    @FindBy(css = "video.css-lsjg21")
    private WebElement searchMainVideo;
    @FindBy(css = "ul > li.css-l4dqbs")
    private List<WebElement> searchListNavBar;
    @FindBy(css = ".css-4bvaso")
    private WebElement searchTitlesOffer;
    @FindBy(css = ".css-1qo6udt")
    private List<WebElement> searchListCardsOffer;
    @FindBy(css = ".css-u8swjo")
    private WebElement searchTitleCelebration;
    @FindBy(css = ".css-dlecs7")
    private WebElement searchBottomCelebrationSpecial;
    @FindBy(css = ".css-ihx62p")
    private WebElement searchTitleWherePiscilago;
    @FindBy(css = ".css-mikjdl > div.css-1cv9oms > div h3")
    private List<WebElement> searchListCardWherePiscilago;

    public PiscilagoHomePage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public WebElement getSearchMainVideo()
    {
        return this.searchMainVideo;
    }

    public List<WebElement> getSearchListNavBar()
    {
        return searchListNavBar;
    }

    public WebElement getSearchTitlesOffer()
    {
        return searchTitlesOffer;
    }

    public List<WebElement> getSearchListCardsOffer()
    {
        return searchListCardsOffer;
    }

    public WebElement getSearchTitleCelebration()
    {
        return searchTitleCelebration;
    }

    public WebElement getSearchBottomCelebrationSpecial()
    {
        return searchBottomCelebrationSpecial;
    }

    public WebElement getSearchTitleWherePiscilago()
    {
        return searchTitleWherePiscilago;
    }

    public List<WebElement> getSearchListCardWherePiscilago()
    {
        return searchListCardWherePiscilago;
    }
}