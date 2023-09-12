package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPageDetails {
    final WebDriver driver;

    //Поле с датой
    private final static By fieldDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле с арендой
    private final static By fieldRent = By.className("Dropdown-arrow");
    //Список сроков аренды
    private final static By rentOptions = By.className("Dropdown-option");
    //Цвет самоката - список
    private final static By colorOptions = By.className("Checkbox_Input__14A2w");
    //Комментарий для курьера
    private final static By fieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка заказать
    private final static By finalOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");
    //Подтверждение заказа - кнопка "Да"
    private final static By buttonConfirm = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[2]");
    //Окно "Заказ оформлен"
    private final static By confirmOrderWindow = By.xpath(".//div[text()='Заказ оформлен']");

    //Конструктор
    public OrderPageDetails(WebDriver driver) {
        this.driver = driver;
    }

    //Ввести дату в поле
    public OrderPageDetails inputDate(String date) {
        driver.findElement(fieldDate).sendKeys(date);
        return this;
    }
    //Нажать на поле и выбрать Срок Аренды
    public OrderPageDetails clickAndChooseRent(int rentOption) {
        driver.findElement(fieldRent).click();
        List<WebElement> listOfRentOptions = driver.findElements(rentOptions);
        int placeInTheListOfRentOptions = rentOption - 1;
        listOfRentOptions.get(placeInTheListOfRentOptions).click();
        return this;
    }
    //Выбрать цвет самоката
    public OrderPageDetails clickAndChooseColor(int colorOption) {
        List<WebElement> listOfColors = driver.findElements(colorOptions);
        int placeInTheListOfColors = colorOption - 1;
        listOfColors.get(placeInTheListOfColors).click();
        return this;
    }
    //Оставить комментарий для курьера
    public OrderPageDetails leaveComment(String comment) {
        driver.findElement(fieldComment).sendKeys(comment);
        return this;
    }
    //Нажать кнопку Заказать
    public OrderPageDetails clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
        return this;
    }
    //Подтвердить заказ
    public OrderPageDetails clickYes() {
        driver.findElement(buttonConfirm).click();
        return this;
    }
    //Окно подтверждения заказа появилось
    public boolean checkThatConfirmWindowAppeared() {
        boolean confirmWindowAppeared;
        if (driver.findElement(confirmOrderWindow).isDisplayed()) confirmWindowAppeared = true;
        else confirmWindowAppeared = false;
        return confirmWindowAppeared;
    }

}
