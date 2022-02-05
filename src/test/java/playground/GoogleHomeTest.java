package playground;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

@RunWith(Parameterized.class)
public class GoogleHomeTest {

    private static WebDriver driver;

    @Parameterized.Parameter
    public static String textData;

    @BeforeClass
    public static void setupBrowser() {

        driver = new FirefoxDriver();

    }

    @AfterClass
    public static void quitBrowser() {
        driver.quit();
    }

    @Parameterized.Parameters(name="Text: {0}")
    public static List<String> getParameters() {
        return Arrays.asList(
                "Simple Text",
                "Text with 412412 numbers",
                "Special chars !\"@#$¨%",
                "4354",
                "<h1> tag </h1>"
        );
    }

    @Test
    public void checkSelenium() {

        //setup
        GoogleHome google = new GoogleHome(driver);
        google.load();

        //action
        String currentPage = google.url();
        google.search(textData);

        //assert
        WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
        wdw.until(not(urlToBe(currentPage)));
        assertThat(driver.getTitle(), startsWith(textData));

    }

}
