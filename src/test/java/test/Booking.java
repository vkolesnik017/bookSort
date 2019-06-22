package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Booking {
    WebDriver driver = new ChromeDriver();
@Test
    public void testApartmentsSortingByPrice () throws InterruptedException {
    BookingPage page = PageFactory.initElements(driver, test.BookingPage.class);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    page.cityField.sendKeys("Rome");
    page.dropMenu.click();
    page.dayDeparture.click();
    page.dayArrival.click();
    page.buttonCheckPrice.click();
    page.closeMap.click();
    page.sortMinPrice.click();
    String total = (page.apartments.getText()).replaceAll("[^0-9]", "");
    System.out.println("Total apartments: " + total);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    TimeUnit.SECONDS.sleep(3);
    page.minPriceApartment();
    driver.quit();
    }
}
