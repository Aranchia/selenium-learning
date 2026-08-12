import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PttkTest1 {

    // Sprawdzanie tytułu strony
    @Test
    void PoprawnyTytulStrony() {
        WebDriver Przegladarka = new ChromeDriver();

        try {
            Przegladarka.get("https://pttkzabrze.mozellosite.com/");

            WebElement Tytul = Przegladarka.findElement(By.tagName("h1"));
            String TytulStrony = Tytul.getText();

            assertTrue(TytulStrony.contains("PTTK Oddział Miejski Zabrze"));
            assertTrue(TytulStrony.contains("im. Andrzeja Jakusa"));
        } finally {
            Przegladarka.quit();
        }
    }

    // Sprawdzanie hasła strony
    @Test
    void PoprawneHasloStrony() {
        WebDriver Przegladarka = new ChromeDriver();

        try {
            Przegladarka.get("https://pttkzabrze.mozellosite.com/");

            WebElement Haslo = Przegladarka.findElement(By.id("haslo-strony"));
            String HasloStrony = Haslo.getText();

            assertTrue(HasloStrony.contains("Rusz z nami w drogę!"));

        } finally {
            Przegladarka.quit();
        }
    }

    // Sprawdzanie loga strony
    @Test
    void PoprawneLogoStrony() {
        WebDriver Przegladarka = new ChromeDriver();

        try {
            Przegladarka.get("https://pttkzabrze.mozellosite.com/");

            WebElement Logo = Przegladarka.findElement(By.className("logo-default"));

            assertTrue(Logo.isDisplayed());
        } finally {
            Przegladarka.quit();
        }
    }

    // Sprawdzanie nagłówka
    @Test
    void PoprawnaNazwaNaglowka () {
        WebDriver Przegladarka = new ChromeDriver();

        try {
            Przegladarka.get("https://pttkzabrze.mozellosite.com/czlonkostwo/");

            WebElement Naglowek = Przegladarka.findElement(By.id("czlonkostwo-pttk"));
            String NaglowekZakladki = Naglowek.getText();

            assertTrue(NaglowekZakladki.contains("Członkostwo PTTK"));
        } finally {
            Przegladarka.quit();
        }
    }
}


