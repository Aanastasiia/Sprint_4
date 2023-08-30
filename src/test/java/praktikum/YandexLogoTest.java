package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.MainPage;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class YandexLogoTest {

    @Rule
    public DriverRule driverRule = new DriverRule();

    private final String expected;

    public YandexLogoTest(String expected) {
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] orderCompleted() {
        return new Object[][]{
                {"https://dzen.ru/?yredirect=true"},
        };
    }

    @Test
    public void logosShouldLeadToPages() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open().clickYandexLogo();

        Set<String> windowHandles = driverRule.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            driverRule.getDriver().switchTo().window(handle);
        }

        String actual = driverRule.getDriver().getCurrentUrl();
        assertEquals(expected, actual);
    }
}

