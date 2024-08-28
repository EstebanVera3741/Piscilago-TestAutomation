package piscilago.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import piscilago.config.PiscilagoInit;
import piscilago.runnes.PiscilagoHomeRunner;

import static org.testng.Assert.*;

public class PiscilagoHomePageTest extends PiscilagoInit
{
    @Test
    @Parameters({"linkMain"})
    public void testSearchPagePiscilago(String linkMain)
    {
        PiscilagoHomeRunner piscilagoHomeRunner = getPiscilagoHomeRunner();

        boolean result = piscilagoHomeRunner.searchPagePiscilago(linkMain);

        assertTrue(result, "The main page is not visible");
    }

    @Test
    @Parameters({"linkMain", "textNavBar"})
    public void testNavBarPiscilago(String linkMain, String textNavBar)
    {
        PiscilagoHomeRunner piscilagoHomeRunner = getPiscilagoHomeRunner();

        boolean result = piscilagoHomeRunner.navBarPiscilago(linkMain, textNavBar);

        assertTrue(result, "The navbar is not visible");
    }

    @Test
    @Parameters({"linkMain", "textMessage"})
    public void testViewOfferPiscilago(String linkMain, String textMessage)
    {
        PiscilagoHomeRunner piscilagoHomeRunner = getPiscilagoHomeRunner();

        boolean result = piscilagoHomeRunner.viewOfferPiscilago(linkMain, textMessage);

        assertTrue(result, "The card offer is not visible");
    }

    @Test
    @Parameters({"linkMain", "textTitleCelebration", "textTitleCelebrationPage"})
    public void testCelebrationSection(String linkMain,
                                       String textTitleCelebration,
                                       String textTitleCelebrationPage)
    {
        PiscilagoHomeRunner piscilagoHomeRunner = getPiscilagoHomeRunner();

        boolean isCorrectHomePage = piscilagoHomeRunner.celebrationSection(linkMain, textTitleCelebration);
        boolean isCorrectCelebrationPage = piscilagoHomeRunner.celebrationPage(linkMain, textTitleCelebrationPage);

        assertTrue(isCorrectHomePage && isCorrectCelebrationPage,
                "The Celebration section and Celebration page is not visible");
    }

    @Test
    @Parameters({"linkMain", "textTitle", "listTextTitle"})
    public void testWherePiscilagoSection(String linkMain, String textTitle, String listTextTitle)
    {
        PiscilagoHomeRunner piscilagoHomeRunner = getPiscilagoHomeRunner();

        boolean result = piscilagoHomeRunner.wherePiscilagoSection(linkMain, textTitle, listTextTitle);

        assertTrue(result, "The where is Piscilago section is not visible");
    }
}