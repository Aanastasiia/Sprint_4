package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage {

    final WebDriver driver;

    //Поле Имя
    public static final By fieldName = By.xpath(".//input[@placeholder='* Имя']");
    //Поле Фамилия
    public static final By fieldLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле Адрес
    public static final By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле Станция Метро
    public static final By fieldChooseSubwayStation = By.xpath(".//input[@placeholder='* Станция метро']");
    //Список станций метро
    public static final By subwayStations = By.className("select-search__row");
    //Поле Телефон
    public static final By fieldPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    public static final By buttonNext = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");

    //Конструктор
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кликнуть по окну и ввести имя
    public OrderPage typeName(String name) {
        driver.findElement(fieldName).sendKeys(name);
        return this;
    }
    //Кликнуть по окну и ввести фамилию
    public OrderPage typeLastName(String lastName) {
        driver.findElement(fieldLastName).sendKeys(lastName);
        return this;
    }
    //Кликнуть по окну и ввести адрес
    public OrderPage typeAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
        return this;
    }
    //Кликнуть по окну для выбора станции метро и выбрать станцию
    public OrderPage clickAndChooseSubwayStation(int numberOfTheSubwayStation) {
        driver.findElement(fieldChooseSubwayStation).click();
        List<WebElement> listOfSubwayStations = driver.findElements(subwayStations);
        int placeInTheListOfSubwayStations = numberOfTheSubwayStation - 1;
        listOfSubwayStations.get(placeInTheListOfSubwayStations).click();
        return this;
    }

    //Кликнуть по окну и ввести телефон
    public OrderPage typePhoneNumber(String phoneNumber) {
            driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
            return this;
    }
    //Кликнуть далее
    public OrderPageDetails clickButtonNext() {
        driver.findElement(buttonNext).click();
        return new OrderPageDetails(driver);
    }
}
