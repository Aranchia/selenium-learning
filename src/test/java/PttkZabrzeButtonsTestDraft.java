import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PttkZabrzeButtonsTestDraft {

    @Test
    void shouldNavigateToWycieczkiViaButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://pttkzabrze.mozellosite.com/");
            Thread.sleep(30000);  // czekaj 0,5 minutę, żeby zobaczyć stronę

            WebElement acceptCookiesButton = driver.findElement(By.xpath("//*[contains(text(), 'Akceptuj wszystkie')]"));
            acceptCookiesButton.click();
            Thread.sleep(30000);  // 60000 milisekund = 1 minuta

            WebElement button = driver.findElement(By.linkText("ZOBACZ WSZYSTKIE WYPRAWY"));
            button.click();
            Thread.sleep(30000);  // 60000 milisekund = 1 minuta

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("wycieczki"));
        } finally {
            driver.quit();
        }
    }

    @Test
    void shouldNavigateToGaleriaViaButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://pttkzabrze.mozellosite.com/");
            Thread.sleep(30000);  // czekaj 0,5 minutę, żeby zobaczyć stronę

            WebElement acceptCookiesButton = driver.findElement(By.xpath("//*[contains(text(), 'Akceptuj wszystkie')]"));
            acceptCookiesButton.click();
            Thread.sleep(30000);

            WebElement button = driver.findElement(By.linkText("ZOBACZ NASZĄ GALERIĘ"));
            button.click();
            Thread.sleep(30000);

            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("galeria"));
        } finally {
            driver.quit();
        }
    }
}

