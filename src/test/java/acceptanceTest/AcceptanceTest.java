package acceptanceTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by pascaldufour on 11/08/16.
 */
@Category(AcceptanceTest.class)

public class AcceptanceTest {

    WebDriver webDriver = null;
    String serverURL = "http://localhost:8080/";

    @Before
    public void webDriver()

    {
        if (webDriver == null)
            webDriver = new ChromeDriver();
        else
            webDriver.quit();
        webDriver = new ChromeDriver();

    }

    @Test
    public void hasTheMainPageTheCorrectTitle() throws InterruptedException {
        webDriver.get(serverURL);
        assertEquals("Title should match",
                "Apache Tomcat/8.0.36", webDriver.getTitle());
    }


     @Test
    public void hasTheEmployeePageASearchOption() throws InterruptedException {
        webDriver.get(serverURL + "/myPetProject/employee");
         webDriver.findElement(By.id("seachEmployeeForm"));
     }
       @After
    public void closeTheWebdriver() {
           webDriver.close();
           webDriver.quit();

       }

}
