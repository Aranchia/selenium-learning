import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

//test ze ścieżką

class PttkTestFormularzZapisy1 {

    WebDriver WebBrowser;

    @Test
    void PoprawneWypelnienieFormularza() {
        WebBrowser = new ChromeDriver();

        // Wchodzę na stronę główną.
        WebBrowser.get("https://pttkzabrze.mozellosite.com/");

        // Zamykam ciasteczka
        WebElement AkceptujCookies = WebBrowser.findElement(By.xpath("//*[contains(text(), 'Akceptuj wszystkie')]"));
        AkceptujCookies.click();

        // Klikam w zakładkę "Zapisy na wydarzenia"
        WebElement ZapisyLink = WebBrowser.findElement(By.linkText("Zapisy na wydarzenia"));
        ZapisyLink.click();

        // Wypełniam pole "Imię i nazwisko"
        WebElement PoleImieNazwisko = WebBrowser.findElement(By.id("moze-webform-ctrl-8315898"));
        PoleImieNazwisko.sendKeys("Małgorzata Kajdańska");

        // Wypełniam pole "Numer telefonu"
        WebElement PoleTelefon = WebBrowser.findElement(By.id("moze-webform-ctrl-8315914"));
        PoleTelefon.sendKeys("664645399");

        // Wypełniam pole  "E-mail"
        WebElement PoleEmail = WebBrowser.findElement(By.id("moze-webform-ctrl-8315899"));
        PoleEmail.sendKeys("malkaj@vp.pl");

        // Wybieram opcję z listy rozwijanej "Impreza"
        WebElement ListaImprez = WebBrowser.findElement(By.id("moze-webform-ctrl-8323981"));
        Select WyborImprezy = new Select(ListaImprez);
        WyborImprezy.selectByVisibleText("Kazimierz Wielki (05.09. - 09.09.2026)"); //tu muszę poprawić

        // Sprawdzam, czy dane faktycznie się wpisały
        assertEquals("Małgorzata Kajdańska", PoleImieNazwisko.getAttribute("value"));
        assertEquals("664645399", PoleTelefon.getAttribute("value"));
        assertEquals("malkaj@vp.pl", PoleEmail.getAttribute("value"));
    }

    @AfterEach
    void ZamknijPrzegladarke() {
        WebBrowser.quit();
    }
}