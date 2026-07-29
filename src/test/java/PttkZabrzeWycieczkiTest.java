import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PttkZabrzeWycieczkiTest {

    @Test
    void shouldNavigateToWycieczkiPage() {
        WebDriver driver = new EdgeDriver();

        try {
            driver.get("https://pttkzabrze.mozellosite.com/");

            WebElement wycieczkiLink = driver.findElement(By.linkText("Wycieczki"));
            wycieczkiLink.click();

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("Wycieczki"));
        } finally {
            driver.quit();
        }
    }
}
