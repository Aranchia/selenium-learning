import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PttkTest2 {

    // Sprawdzanie kafelków - Kafelek "Dołącz do PTTK"


    @Test
    void KafelkiCzlonkostwo1() {
        WebDriver Przegladarka = new ChromeDriver();

        try {
            Przegladarka.get("https://pttkzabrze.mozellosite.com/");

            WebElement Kafelek1 = Przegladarka.findElement(By.id("dolacz-do-pttk"));
            //String TytulStrony = Tytul.getText();

            assertTrue(Kafelek1.isDisplayed());
            //assertTrue(TytulStrony.contains("im. Andrzeja Jakusa"));
        } finally {
            Przegladarka.quit();
        }
    }

    // Sprawdzanie kafelków - Kafelek "Jestem już w PTTK"

    @Test
    void KafelkiCzlonkostwo2() {
        WebDriver Przegladarka = new ChromeDriver();

        try {
            Przegladarka.get("https://pttkzabrze.mozellosite.com/");

            WebElement Kafelek2 = Przegladarka.findElement(By.id("jestem-juz-w-pttk"));
            //String TytulStrony = Tytul.getText();

            assertTrue(Kafelek2.isDisplayed());
            //assertTrue(TytulStrony.contains("im. Andrzeja Jakusa"));
        } finally {
            Przegladarka.quit();
        }
    }
}