package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

public class TrackPage {

    final WebDriver driver;
    //Картинка-ошибка, что заказ по номеру не найден
    public static final By notFound = By.cssSelector("[alt='Not found']");

    //Конструктор
    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    //Проеврить, что при вводе неправильного заказа отображается картинка "Такого заказа нет"
    public boolean waitForNoStatus() {
        boolean isNotFoundShown;

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(notFound));

        if (driver.findElement(notFound).isDisplayed()) isNotFoundShown = true;
        else isNotFoundShown = false;
        return isNotFoundShown;
    }
}
