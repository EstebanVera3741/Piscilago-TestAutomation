package piscilago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import piscilago.config.PiscilagoBase;
import piscilago.utils.response.IPiscilagoResponse;

public class PiscilagoPortalPage extends PiscilagoBase
{
    @FindBy(css = ".css-pcbsfj")
    private WebElement elementTitlePage;
    @FindBy(css = ".css-mevgbx")
    private WebElement elementInputId;
    @FindBy(css = ".css-1m9pwf3")
    private WebElement elementCheck;
    @FindBy(css = ".page_initialStyles__hYFv4")
    private WebElement elementBottomContinue;

    public PiscilagoPortalPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public void servicePagePortalVisibility(String titlePortal)
    {
        waitElementVisibility(this.elementTitlePage);
        if (!this.elementTitlePage.getText().trim().equals(titlePortal.trim())) {
            throw new AssertionError(IPiscilagoResponse.PISCILAGO_FAIL_MATCH);
        }
    }

    public void serviceCompleteInfoBuyPlan(String Id)
    {
        waitElementVisibility(this.elementInputId);
        this.elementInputId.click();
        this.elementInputId.sendKeys(Id);
        this.elementCheck.click();
        waitElementVisibility(this.elementBottomContinue);
        this.elementBottomContinue.click();
    }
}