package piscilago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import piscilago.config.PiscilagoBase;
import piscilago.utils.response.IPiscilagoResponse;

import java.util.List;

public class PiscilagoPlanRatesPage extends PiscilagoBase
{
    @FindBy(css = ".css-pjax75")
    private WebElement elementTitlePage;
    @FindBy(css = ".css-1qo6udt")
    private List<WebElement> elementPlans;

    public PiscilagoPlanRatesPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public void servicePagePlanRatesVisibility(String titlePlanRates)
    {
        waitElementVisibility(this.elementTitlePage);
        if (!this.elementTitlePage.getText().trim().equals(titlePlanRates.trim())) {
            throw new AssertionError(IPiscilagoResponse.PISCILAGO_FAIL_MATCH);
        }
    }

    public void serviceSelectPlan(Integer plan)
    {
        waitListElementVisibility(this.elementPlans);
        this.elementPlans.get(plan).click();
    }
}