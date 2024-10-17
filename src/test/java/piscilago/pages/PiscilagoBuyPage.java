package piscilago.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import piscilago.config.PiscilagoBase;
import piscilago.utils.response.IPiscilagoResponse;

public class PiscilagoBuyPage extends PiscilagoBase
{
    @FindBy(css = "p.detalle-compra-titulo")
    private WebElement elementOrderBuy;

    public PiscilagoBuyPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public boolean serviceIsCorrectProcessBuy(String titleOrderBuy)
    {
        try
        {
            Thread.sleep(5000);

            waitElementVisibility(this.elementOrderBuy);
            return this.elementOrderBuy.getText().trim().equals(titleOrderBuy.trim());
        } catch (InterruptedException e) {
            System.out.println(IPiscilagoResponse.PISCILAGO_FAIL_TIMEOUT);
        }
        return false;
    }
}