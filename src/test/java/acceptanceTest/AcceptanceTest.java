package acceptanceTest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by pascaldufour on 11/08/16.
 */
public class AcceptanceTest {



    @Test
    public void correctTitle() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        sleep(5000);  // Let the user actually see something!
        assertEquals("Title should match",
                "Apache Tomcat/8.0.36", driver.getTitle());
        driver.quit();
    };
}
