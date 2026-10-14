import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

class sauceDemo {
    WebDriver WebBrowser;

   @Test
   void addProduct()
   {
       WebBrowser = new ChromeDriver();
       WebBrowser.get("https://www.saucedemo.com/");

       // krok 1: logowanie
       WebBrowser.findElement(By.id("user-name")).sendKeys("standard_user"); //jeżel sie loguję to uzywam metody sendKeys
       WebBrowser.findElement(By.id("password")).sendKeys("secret_sauce");
       WebBrowser.findElement(By.id("login-button")).click();

       // krok 2: dodanie produktu
       WebElement addButton =  WebBrowser.findElement(By.id("add-to-cart-sauce-labs-backpack")); //znowu sprawdzam id w devtoolsach
       addButton.click();

       // sprawdzenie 1: licznik przy koszyku
       WebElement cartBadge =  WebBrowser.findElement(By.className("shopping_cart_badge")); //devtools
       assertEquals("1", cartBadge.getText());

       // krok 3: wejście do koszyka
       WebElement cartLink =  WebBrowser.findElement(By.className("shopping_cart_link"));
       cartLink.click();

       // sprawdzenie 2 i 3: adres i produkt w koszyku
       assertTrue( WebBrowser.getCurrentUrl().contains("cart")); //tego nie rozumiem do konca, nie rozumiem do konca działania asercji tru/false

       WebElement itemName =  WebBrowser.findElement(By.className("inventory_item_name"));
       assertEquals("Sauce Labs Backpack", itemName.getText());
   }
@AfterEach
   void closeBrowser()
   {
    WebBrowser.quit();
   }
}