package piscilago.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import piscilago.config.PiscilagoBase;
import piscilago.utils.response.IPiscilagoResponse;

import java.util.List;

public class PiscilagoShoppingPage extends PiscilagoBase
{
    @FindBy(css = ".css-ycms74")
    private WebElement elementTitle;
    @FindBy(css = "[placeholder='Ingresa tu nombre']")
    private WebElement elementInputName;
    @FindBy(css = "[placeholder='Ingresa tus apellidos']")
    private WebElement elementInputLastName;
    @FindBy(css = "[placeholder='Ingresa tu correo electrónico']")
    private WebElement elementInputEmail;
    @FindBy(css = "[placeholder='Ingresa tu número de celular']")
    private WebElement elementInputNumber;
    @FindBy(css = ".css-1cqrani")
    private List<WebElement> elementListDate;
    @FindBy(css = ".css-1m0qfgm")
    private List<WebElement> elementListButton;
    @FindBy(css = ".css-1m5f78l")
    private List<WebElement> elementListPlan;
    @FindBy(css = ".css-jjo9gt")
    private List<WebElement> elementListButtonContinue;
    @FindBy(css = ".css-ycms74")
    private WebElement elementTitleShoppingTwo;
    @FindBy(css = ".css-1m8drw5")
    private WebElement elementPopUp;
    @FindBy(css = "[href='#']")
    private WebElement elementSkipPopUp;
    @FindBy(css = ".css-1e8wppk")
    private WebElement elementTitleShoppingThree;
    @FindBy(css = ".css-ycms74")
    private WebElement elementTitleShoppingFour;

    public PiscilagoShoppingPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public void servicePageShoppingVisibility(String titleShopping)
    {
        waitElementVisibility(this.elementTitle);
        if (!this.elementTitle.getText().trim().equals(titleShopping.trim())) {
            throw new AssertionError(IPiscilagoResponse.PISCILAGO_FAIL_MATCH);
        }
    }

    public void serviceCompleteBuyInfo(
            String name,
            String lastName,
            String email,
            String number)
    {
        waitElementVisibility(this.elementInputName);
        this.elementInputName.sendKeys(name);
        waitElementVisibility(this.elementInputLastName);
        this.elementInputLastName.sendKeys(lastName);
        waitElementVisibility(this.elementInputEmail);
        this.elementInputEmail.sendKeys(email);
        waitElementVisibility(this.elementInputNumber);
        this.elementInputNumber.sendKeys(number);
        this.elementListButton.getFirst().click();
    }

    public void serviceSelectPlan(Integer plan, Integer button)
    {
        waitListElementVisibility(this.elementListPlan);
        this.elementListPlan.get(plan).click();
        this.elementListButton.get(button).click();
    }

    public void serviceSelectDate()
    {
        waitListElementVisibility(this.elementListButton);
        this.elementListButton.getLast().click();
        this.elementListButtonContinue.getLast().click();
    }

    public void PageShoppingTitleTwoVisibility(String titleShoppingTwo)
    {
        try
        {
            Thread.sleep(10000);
            getWebDriver().navigate().refresh();

            waitElementVisibility(this.elementTitleShoppingTwo);
            if (!this.elementTitleShoppingTwo.getText().trim().equals(titleShoppingTwo.trim())) {
                throw new AssertionError(IPiscilagoResponse.PISCILAGO_FAIL_MATCH);
            }
        } catch (InterruptedException e) {
            System.out.println(IPiscilagoResponse.PISCILAGO_FAIL_TIMEOUT);
        }
    }

    public void serviceContinueBuyPlan()
    {
        try
        {
            Thread.sleep(2000);
            getWebDriver().navigate().refresh();

            this.elementListButtonContinue.getLast().click();
            waitElementVisibility(this.elementPopUp);
            this.elementSkipPopUp.click();
        } catch (InterruptedException e) {
            System.out.println(IPiscilagoResponse.PISCILAGO_FAIL_TIMEOUT);
        }
    }

    public void servicePageShoppingTitleThreeVisibility(String titleShoppingThree)
    {
        try
        {
            Thread.sleep(2000);
            getWebDriver().navigate().refresh();

            waitElementVisibility(this.elementTitleShoppingThree);
            if (!this.elementTitleShoppingThree.getText().trim().equals(titleShoppingThree.trim())) {
                throw new AssertionError(IPiscilagoResponse.PISCILAGO_FAIL_MATCH);
            }
            this.elementListButtonContinue.getLast().click();
        } catch (InterruptedException e) {
            System.out.println(IPiscilagoResponse.PISCILAGO_FAIL_TIMEOUT);
        }
    }

    public void servicePageShoppingTitleFourVisibility(String titleShoppingFour)
    {
        try
        {
            Thread.sleep(2000);
            getWebDriver().navigate().refresh();

            waitElementVisibility(this.elementTitleShoppingFour);
            if (!this.elementTitleShoppingFour.getText().trim().equals(titleShoppingFour.trim())) {
                throw new AssertionError(IPiscilagoResponse.PISCILAGO_FAIL_MATCH);
            }
            this.elementListButton.getLast().click();
        } catch (InterruptedException e) {
            System.out.println(IPiscilagoResponse.PISCILAGO_FAIL_TIMEOUT);
        }
    }
}