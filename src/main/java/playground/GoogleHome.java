package playground;

import locators.GoogleHomeLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHome {

    public WebDriver driver;
    public GoogleHomeLocators uiMap = new GoogleHomeLocators();

    public GoogleHome(WebDriver driver) {
        this.driver = driver;
    }

    public String url() {
        return driver.getCurrentUrl();
    }

    public void load() {
        driver.get("https://google.com");
    }

    public void search(String text) {
        driver.findElement(uiMap.SEARCH_FIELD).sendKeys(text + Keys.ENTER);
    }

}
