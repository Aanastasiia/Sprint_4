package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScooterLogoTest {

    @Rule
    public DriverRule driverRule = new DriverRule();

    private final String expected;

    public ScooterLogoTest(String expected) {
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] orderCompleted() {
        return new Object[][]{
                {"https://qa-scooter.praktikum-services.ru/"},
        };
    }

    @Test
    public void logosShouldLeadToPages() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open().clickScooterLogo();
        String actual = driverRule.getDriver().getCurrentUrl();
        assertEquals(expected, actual);
    }
}


