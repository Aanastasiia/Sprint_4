package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.MainPage;
import praktikum.pages.TrackPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WrongOrderNumberTest {

    @Rule
    public DriverRule driverRule = new DriverRule();
    private final String invalidOrderNumber;
    private final boolean expected;

    public WrongOrderNumberTest(String invalidOrderNumber, boolean expected) {
        this.invalidOrderNumber = invalidOrderNumber;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] orderCompleted() {
        return new Object[][]{
                {"12345", true},
                {"", true},
        };
    }

    @Test
    public void checkInvalidOrderNumber() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open().showStatus().typeOrderNumber(invalidOrderNumber);

        TrackPage trackPage = mainPage.clickOnGo();

        boolean actual = trackPage.waitForNoStatus();

        assertEquals(expected, actual);
    }

}
