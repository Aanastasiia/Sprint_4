package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPage;
import praktikum.pages.OrderPageDetails;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class OrderScooterTest {

    @Rule
    public DriverRule driverRule = new DriverRule();

    private final int whichOrderButton;
    private final String name;
    private final String lastName;
    private final String address;
    private final int numberOfTheSubwayStation;
    private final String phoneNumber;
    private final String date;
    private final int rentOption;
    private final int colorOption;
    private final String comment;
    private final boolean expected;

    public OrderScooterTest(int whichOrderButton, String name, String lastName, String address, int numberOfTheSubwayStation, String phoneNumber, String date, int rentOption, int colorOption, String comment, boolean expected) {
        this.whichOrderButton = whichOrderButton;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.numberOfTheSubwayStation = numberOfTheSubwayStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentOption = rentOption;
        this.colorOption = colorOption;
        this.comment = comment;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] orderCompleted() {
        return new Object[][] {
                {1, "Анна", "Маркс", "150 Смит Стрит", 3, "71234567890", "10/10/2023", 4, 1, "Спасибо", true},
                {2, "Максимилиан", "Иванов", "Стрит 100", 2, "78901234536", "01/01/2024", 5, 2, "", true},
        };
    }

    @Test
    public void shouldDisplayOrderConfirmation() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open().clickCookieAgreement();

        OrderPage orderPage = mainPage.clickOnOrderButton(whichOrderButton);
        orderPage.typeName(name).typeLastName(lastName).typeAddress(address).clickAndChooseSubwayStation(numberOfTheSubwayStation)
                .typePhoneNumber(phoneNumber);

        OrderPageDetails orderPageDetails = orderPage.clickButtonNext();
        orderPageDetails.inputDate(date).clickAndChooseRent(rentOption).clickAndChooseColor(colorOption).leaveComment(comment)
                .clickFinalOrderButton().clickYes();

        boolean actual = orderPageDetails.checkThatConfirmWindowAppeared();
        assertEquals(expected, actual);
    }
}
