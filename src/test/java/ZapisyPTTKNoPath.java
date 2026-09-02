import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

//test bez ścieżki

class PttkTestFormularzZapisy {

    WebDriver WebBrowser;

    @Test
    void PoprawneWypelnienieFormularza() throws InterruptedException {
        WebBrowser = new ChromeDriver();

        WebBrowser.get("https://pttkzabrze.mozellosite.com/");
        //zamykanie cookies
        WebElement AkceptujCookies = WebBrowser.findElement(By.xpath("//*[contains(text(), 'Akceptuj wszystkie')]"));
        AkceptujCookies.click();

        // przejście do zakładki zapisów
        WebElement ZapisyLink = WebBrowser.findElement(By.linkText("Zapisy na wydarzenia"));
        ZapisyLink.click();

        // imię i nazwisko
        WebElement PoleImieNazwisko = WebBrowser.findElement(By.id("moze-webform-ctrl-8315898"));
        PoleImieNazwisko.sendKeys("Małgorzata Kajdańska");

        //telefon
        WebElement PoleTelefon = WebBrowser.findElement(By.id("moze-webform-ctrl-8315914"));
        PoleTelefon.sendKeys("664645399");

        // e-mail
        WebElement PoleEmail = WebBrowser.findElement(By.id("moze-webform-ctrl-8315899"));
        PoleEmail.sendKeys("malkaj@vp.pl");

        //wybieram wydarzenie
        WebElement ListaImprez = WebBrowser.findElement(By.id("moze-webform-ctrl-8323981"));
        Select WyborImprezy = new Select(ListaImprez);
        WyborImprezy.selectByVisibleText("IV Jesienny Rajd Jurajski (19.09.2026)");

       // sprawdzam asercje - logika wykonywania
        assertEquals("Małgorzata Kajdańska", PoleImieNazwisko.getAttribute("value"));
        assertEquals("664645399", PoleTelefon.getAttribute("value"));
        assertEquals("malkaj@vp.pl", PoleEmail.getAttribute("value"));

        // leci do zapisów
        WebElement PrzyciskWyslij = WebBrowser.findElement(By.className("moze-formbutton"));
        PrzyciskWyslij.click();
        Thread.sleep(10000);
    }

    @AfterEach
    void ZamknijPrzegladarke() {
        WebBrowser.quit();
    }
}
