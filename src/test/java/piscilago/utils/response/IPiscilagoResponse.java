package piscilago.utils.response;

public interface IPiscilagoResponse
{
    String PISCILAGO_FAIL_TIMEOUT = "The web element is not visible in timeout: ";
    String PISCILAGO_FAIL_MATCH = "The web element does not match the expected result. ";
    String PISCILAGO_FAIL_WINDOW = "The tab with the identifier could not be found: ";
    String PISCILAGO_SUCCESS_TEST = "The test execution is correct. ";
    String PISCILAGO_FAIL_BUY_TEST = "The buy order title is not visible. ";
}