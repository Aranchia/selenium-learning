import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

class pttkZ {
    WebDriver WebBrowser;

    @Test
    void checkAddress() {
        WebBrowser = new ChromeDriver();

        String[] pages = {
                "https://pttkzabrze.mozellosite.com/",           //tablica, jeszcze potrzebuję wyjaśnienia
                "https://pttkzabrze.mozellosite.com/kontakt/",
                "https://pttkzabrze.mozellosite.com/wycieczki/"         //no usage - po co to
        };

        int i = 0;
        while (i < pages.length) {

            WebBrowser.get(pages[i]);

            String title = WebBrowser.getTitle();
            assertTrue(title.contains("PTTK"), "Zły tytuł strony: " + pages[i]);

            i++;
        }

    }

    @AfterEach
    void closeBrowser()
    {
        WebBrowser.quit();
    }
}