package piscilago.runnes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import piscilago.config.PiscilagoBase;
import piscilago.pages.PiscilagoCelebrationPage;

public class PiscilagoCelebrationRunner extends PiscilagoBase
{
    private final PiscilagoCelebrationPage piscilagoCelebrationPage;

    public PiscilagoCelebrationRunner(WebDriver webDriver)
    {
        super(webDriver);
        this.piscilagoCelebrationPage = new PiscilagoCelebrationPage(webDriver);
    }

    public boolean titleIsCorrect(String textTitleCelebrationPage)
    {
        WebElement webElement = this.piscilagoCelebrationPage.getSearchTitlePage();
        waitElementVisibility(webElement);

        return webElement.getText().trim().equals(textTitleCelebrationPage.trim());
    }
}