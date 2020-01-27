package test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookingPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//input[@id='ss']")
    WebElement cityField;
    @FindBy(how = How.XPATH, xpath = "//li[contains(@class,'c-autocomplete__item sb-autocomplete__item sb-autocomplete__item-with_photo sb-autocomplete__item--airport sb-autocomplete__item__item--elipsis')]")
    WebElement dropMenu;
    @FindBy(how = How.XPATH, xpath = "//div[contains(@class,'bui-calendar__main')]//div[1]//table[1]//tbody[1]//tr[6]//td[7]")
    WebElement dayDeparture;
    @FindBy(how = How.XPATH, xpath = "//div[@class='bui-calendar__content']/div[2]/table/tbody/tr[2]/td[7]")
    WebElement dayArrival;
    @FindBy(how = How.XPATH, xpath = "//div[contains(@class,'sb-searchbox-submit-col -submit-button')]//button[contains(@class,'')]")
    WebElement buttonCheckPrice;
    @FindBy(how = How.XPATH, xpath = "//div[@class='map_full_overlay__close']")
    WebElement closeMap;
    @FindBy(how = How.XPATH, xpath = "//li[contains(@class,'sort_price')]")
    WebElement sortMinPrice;
    @FindBy(how = How.XPATH, xpath = "//div[contains(@class,'sr_header--title')]//div[contains(@class,'sr_header')]")
    WebElement apartments;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.booking.com");
    }

    public void sortPrices() throws InterruptedException {

        List<WebElement> allPricesElements = driver.findElements(By.xpath("//div[contains(@class, 'price-display__value')]"));
        List<Integer> allPricesSorted = new ArrayList<Integer>();
        for (WebElement e : allPricesElements) {
            if (!e.getText().isEmpty()) {
                String price = e.getText().replaceAll("[^0-9]", "");
                allPricesSorted.add(Integer.parseInt(price));
            }
        }

        List<Integer> sortedPricesList = new ArrayList<Integer>(allPricesSorted);
        Collections.sort(sortedPricesList);
        sortList(sortedPricesList, allPricesSorted);
    }

    public void sortList(List<Integer> first, List<Integer> second) {
        Assert.assertEquals("Price sorting doesn't work correctly",second,first);
        System.out.println("Price sorting works correctly");
    }
    
     /*     $(byId("login")).shouldBe(visible);
        $(byId("login")).setValue("lion");
        $(byId("password")).setValue("4e24e740");
        $(".btn").click();
        $(byId("form_Filter[orderId]")).setValue("26283402").pressEnter();
        $(".order_link").shouldBe(visible).click();
        $(byText("Изменить Статус Заказа")).scrollTo();
        String statusOfOrder = $(".btn-link").getText().substring(16);
        System.out.println(statusOfOrder);
        if (statusOfOrder.equals("Testbestellunge")) {
            System.out.println("всё ок");
        } else {
            System.out.println("хрень");
            $(byId("form_OrderStatus[newStatus]")).selectOptionByValue("139");
        }
*/

}
