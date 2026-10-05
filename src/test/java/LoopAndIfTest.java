import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoopAndIfTest {

    WebDriver WebBrowser;

    // 1. IF - sprawdzenie czy tytuł zawiera "PTTK'
    @Test
    void testIf() {
        WebBrowser = new ChromeDriver();
        WebBrowser.get("https://pttkzabrze.mozellosite.com/");

        String title = WebBrowser.getTitle();

        if (title.contains("PTTK")) {
            System.out.println("Tytuł zawiera PTTK");
        }

        assertTrue(title.contains("PTTK"));
    }

    // 2. IF/ELSE - sprawdzenie czy po wejściu do zakladki kontakt czy adres zawiera słowo kontakt, tak naprawdę jest to sprawdzenie czy adres się
    // nie zmienił. Ten test ogólnie jest słaby
    @Test
    void testIfElse() {
        WebBrowser = new ChromeDriver();
        WebBrowser.get("https://pttkzabrze.mozellosite.com/kontakt/");

        String url = WebBrowser.getCurrentUrl();

        if (url.contains("kontakt")) {
            System.out.println("Jestem na stronie Kontakt");
        } else {
            System.out.println("Jestem gdzie indziej: " + url);
        }

        assertTrue(url.contains("kontakt"));
    }

    // 3. if / else if / else - podobnie jak test wyżej, tylko szukamy słowa wycieczki
    @Test
    void testIfElseIfElse() {
        WebBrowser = new ChromeDriver();
        WebBrowser.get("https://pttkzabrze.mozellosite.com/wycieczki/");

        String url = WebBrowser.getCurrentUrl();

        if (url.contains("kontakt")) {
            System.out.println("Jestem na stronie Kontakt");
        } else if (url.contains("wycieczki")) {
            System.out.println("Jestem na stronie Wycieczki");
        } else {
            System.out.println("Jestem gdzie indziej: " + url);
        }

        assertTrue(url.contains("wycieczki"));
    }

    // 4. while - jak otwiera się srtona głowna i czy otwiera sie z tytułem pttk
    @Test
    void testWhile() {
        WebBrowser = new ChromeDriver();

        int attempts = 0;
        String title = "";

        while (!title.contains("PTTK") && attempts < 3) {
            WebBrowser.get("https://pttkzabrze.mozellosite.com/");
            title = WebBrowser.getTitle();
            attempts++;
        }

        System.out.println("Liczba prób: " + attempts);
        assertTrue(title.contains("PTTK"));
    }

    // 5. do-while - czyli chodzi o to, żeby dalej sprawdzić czy strona zawiera pttk
    @Test
    void testDoWhile() {
        WebBrowser = new ChromeDriver();

        int attempts = 0;
        String title = "";

        do {
            WebBrowser.get("https://pttkzabrze.mozellosite.com/");
            title = WebBrowser.getTitle();
            attempts++;
        } while (!title.contains("ZabrzePTTK") && attempts < 3);

        System.out.println("Liczba prób: " + attempts);
        assertTrue(title.contains("PTTK")); // upewniam się, że tytuł zawiera pttk
    }

    @AfterEach
    void closeBrowser() {
        WebBrowser.quit();
    }
}