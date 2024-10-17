package piscilago.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import piscilago.config.PiscilagoInit;
import piscilago.pages.*;
import piscilago.utils.parameter.IPiscilagoBuyPlanParameter;
import piscilago.utils.parameter.IPiscilagoInfoPageParameter;
import piscilago.utils.response.IPiscilagoResponse;

import static org.testng.Assert.assertTrue;

public class PiscilagoBuyPlanTest extends PiscilagoInit
{
    @Test
    @Parameters({"linkMain"})
    public void testBuyPlan(String linkMain)
    {
        WebDriver webDriver = getPiscilagoManageDriver();

        PiscilagoHomePage piscilagoHomePage =
                new PiscilagoHomePage(webDriver);

        piscilagoHomePage.serviceNavigateCorrectly(linkMain);
        String className = piscilagoHomePage.getClass().getSimpleName();
        piscilagoHomePage.serviceAddWindow(className);
        piscilagoHomePage.serviceClickNavBar(0);
        piscilagoHomePage.serviceClickSubNavBar(0);

        PiscilagoPlanRatesPage piscilagoPlanRatesPage =
                new PiscilagoPlanRatesPage(webDriver);

        piscilagoPlanRatesPage.servicePagePlanRatesVisibility(
                IPiscilagoInfoPageParameter.TITLE_PLAN_RATES);
        piscilagoPlanRatesPage.serviceSelectPlan(1);

        PiscilagoPortalPage piscilagoPortalPage =
                new PiscilagoPortalPage(webDriver);

        className = piscilagoPortalPage.getClass().getSimpleName();
        piscilagoPortalPage.serviceAddWindow(className);
        piscilagoPortalPage.serviceSelectWindow(className);
        piscilagoPortalPage.servicePagePortalVisibility(
                IPiscilagoInfoPageParameter.TITLE_PORTAL);
        piscilagoPortalPage.serviceCompleteInfoBuyPlan(
                IPiscilagoBuyPlanParameter.ID);

        PiscilagoShoppingPage piscilagoShoppingPage =
                new PiscilagoShoppingPage(webDriver);

        piscilagoShoppingPage.servicePageShoppingVisibility(
                IPiscilagoInfoPageParameter.TITLE_SHOPPING);
        piscilagoShoppingPage.serviceCompleteBuyInfo(
                IPiscilagoBuyPlanParameter.NAME,
                IPiscilagoBuyPlanParameter.LAST_NAME,
                IPiscilagoBuyPlanParameter.EMAIL,
                IPiscilagoBuyPlanParameter.NUMBER);
        piscilagoShoppingPage.serviceSelectPlan(1, 1);
        piscilagoShoppingPage.serviceSelectDate();
        piscilagoShoppingPage.PageShoppingTitleTwoVisibility(
                IPiscilagoInfoPageParameter.TITLE_SHOPPING_2);
        piscilagoShoppingPage.serviceContinueBuyPlan();
        piscilagoShoppingPage.servicePageShoppingTitleThreeVisibility(
                IPiscilagoInfoPageParameter.TITLE_SHOPPING_3);
        piscilagoShoppingPage.servicePageShoppingTitleFourVisibility(
                IPiscilagoInfoPageParameter.TITLE_SHOPPING_4);

        PiscilagoBuyPage piscilagoBuyPage =
                new PiscilagoBuyPage(webDriver);

        boolean result = piscilagoBuyPage.serviceIsCorrectProcessBuy(
                IPiscilagoInfoPageParameter.TITLE_BUY);

        assertTrue(result,
                IPiscilagoResponse.PISCILAGO_FAIL_TIMEOUT +
                        IPiscilagoResponse.PISCILAGO_FAIL_BUY_TEST);
    }

}