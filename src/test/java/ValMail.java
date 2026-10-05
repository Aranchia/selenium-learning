import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class EmailValidationTest {

    WebDriver WebBrowser;

    @Test
    void shouldValidateEmailFormat() {
        WebBrowser = new ChromeDriver();
        WebBrowser.get("https://pttkzabrze.mozellosite.com/");

        WebElement AkceptujCookies = WebBrowser.findElement(By.xpath("//*[contains(text(), 'Akceptuj wszystkie')]"));
        AkceptujCookies.click();

        WebElement ZapisyLink = WebBrowser.findElement(By.linkText("Zapisy na wydarzenia"));
        ZapisyLink.click();

        WebElement PoleEmail = WebBrowser.findElement(By.id("moze-webform-ctrl-8315899"));

        // 1. zły adres (bez @)
        PoleEmail.sendKeys("malkajvp.pl");
        String komunikat = PoleEmail.getDomProperty("validationMessage");
        assertFalse(komunikat.isEmpty(), "Zły adres powinien być odrzucony");

        // 2. dobry adres
        PoleEmail.clear();
        PoleEmail.sendKeys("malkaj@vp.pl");
        komunikat = PoleEmail.getDomProperty("validationMessage");
        assertEquals("", komunikat);
    }

    @AfterEach
    void closeBrowser() {
        WebBrowser.quit();
    }
}
