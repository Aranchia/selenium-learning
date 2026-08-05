import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PttkZabrzeButtonsTest {

    @Test
    void shouldNavigateToWycieczkiViaButton() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://pttkzabrze.mozellosite.com/");

            WebElement button = driver.findElement(By.linkText("ZOBACZ WSZYSTKIE WYPRAWY"));
            button.click();

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("wycieczki"));
        } finally {
            driver.quit();
        }
    }

    @Test
    void shouldNavigateToGaleriaViaButton() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://pttkzabrze.mozellosite.com/");

            WebElement button = driver.findElement(By.linkText("ZOBACZ NASZĄ GALERIĘ"));
            button.click();

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("galeria"));
        } finally {
            driver.quit();
        }
    }
}