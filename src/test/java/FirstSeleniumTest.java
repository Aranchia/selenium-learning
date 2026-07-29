import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FirstSeleniumTest {

    @Test
    void shouldOpenSeleniumPage() {
        WebDriver driver = new EdgeDriver();

        try {
            driver.get("https://www.selenium.dev/");

            String pageTitle = driver.getTitle();
            assertTrue(pageTitle.contains("Selenium"));
        } finally {
            driver.quit();
        }
    }
}
