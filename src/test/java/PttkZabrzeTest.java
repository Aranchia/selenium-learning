import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PttkZabrzeTest {

    @Test
    void shouldOpenPttkZabrzePage() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://pttkzabrze.mozellosite.com/");

            String pageTitle = driver.getTitle();
            assertTrue(pageTitle.contains("PTTK"));
        } finally {
            driver.quit();
        }
    }
}
