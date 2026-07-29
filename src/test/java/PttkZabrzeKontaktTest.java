import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PttkZabrzeKontaktTest {

    @Test
    void shouldNavigateToKontaktPage() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://pttkzabrze.mozellosite.com/");

            WebElement kontaktLink = driver.findElement(By.linkText("Kontakt"));
            kontaktLink.click();

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("kontakt"));
        } finally {
            driver.quit();
        }
    }
}
