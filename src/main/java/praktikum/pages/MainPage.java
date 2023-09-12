package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import praktikum.EnvConfig;

import java.util.List;

public class MainPage {

    final WebDriver driver;

    //Лого Самоката
    private static final By logoScooter = By.xpath(".//img[@alt='Scooter']");
    //Лого Яндекса
    private static final By logoYandex = By.xpath(".//img[@alt='Yandex']");
    //Кнопка Статус заказа
    private static final By goButton = By.cssSelector("[class*=Header_Button_]");
    //Поле для ввода номера заказа
    private static final By orderInput = By.className("Input_Input__1iN_Z");
    //Кнопка Го!
    private static final By statusButton = By.className("Header_Link__1TAG7");
    //Кнопки заказать на домашней странице страницы
    private static final By orderButtons = By.xpath(".//button[text()='Заказать']");
    //Куки - "да все привыкли" кнопка
    private static final By cookieButton = By.id("rcc-confirm-button");
    //Надпись "Вопросы о важном"
    private final static By questionsSection = By.xpath(".//div[text()='Вопросы о важном']");
    //Лист вопросов
    private final static By questionsList = By.className("accordion__item");
    //Лист ответов
    private final static By answerList = By.tagName("p");

    //Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открыть домашнюю страницу
    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);
        return this;
    }

    //Нажать на кнопку заказа
    public OrderPage clickOnOrderButton(int whichOrderButton) {
        List<WebElement> listOfOrderButtons = driver.findElements(orderButtons);
        int placeInTheListOfOrderButtons = whichOrderButton - 1;
        listOfOrderButtons.get(placeInTheListOfOrderButtons).click();
        return new OrderPage(driver);
    }

    //Нажать на кнопку Go!
    public TrackPage clickOnGo() {
        driver.findElement(goButton).click();
        return new TrackPage(driver);
    }

    //Напечатать номер заказа
    public MainPage typeOrderNumber(String orderNumber) {
        driver.findElement(orderInput).sendKeys(orderNumber);
        return this;
    }

    //Нажать на кнопку Статус заказа
    public MainPage showStatus() {
        driver.findElement(statusButton).click();
        return this;
    }

    //Нажать на принять куки
    public MainPage clickCookieAgreement() {
        driver.findElement(cookieButton).click();
        return this;
    }

    //Найти секцию вопросов и ответов на странице
    public MainPage findQuestionsAndAnswers() {
        WebElement element = driver.findElement(questionsSection);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    //Проверить, что на все вопросы показываются соответствующие ответы
    public String clickOnQuestionAndGetAnswers(int questionNumber) {

        List<WebElement> listQuestions = driver.findElements(questionsList);
        List<WebElement> listAnswers = driver.findElements(answerList);
        String answer = "Placeholder";

        int placeInTheListOfQuestions = questionNumber - 1;

        listQuestions.get(placeInTheListOfQuestions).click();

        answer = listAnswers.get(placeInTheListOfQuestions).getText();
        return answer;
    }

    //Нажать на лого Самоката
    public MainPage clickScooterLogo() {
        driver.findElement(logoScooter).click();
        return this;
    }
    //Нажать на лого Яндекса
    public MainPage clickYandexLogo() {
        driver.findElement(logoYandex).click();
        return this;
    }
}
