import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

/*class theInternet {
   WebDriver WebBrowser; */

   /*@Test
   void checkbox()
   {
       WebBrowser = new ChromeDriver();
       WebBrowser.get("https://the-internet.herokuapp.com/checkboxes");

      WebElement firstCheckbox = WebBrowser.findElement(By.tagName("input"));
      firstCheckbox.click();

      assertTrue(firstCheckbox.isSelected());

      WebElement secondCheckbox = WebBrowser.findElement(By.cssSelector("input:nth-of-type(2)")); //css
      secondCheckbox.click();

      assertFalse(secondCheckbox.isSelected());

   }
@AfterEach
   void closeBrowser()
   {
    WebBrowser.quit();
   }
}*/

/*   @Test
   void dropdown() {
      WebBrowser = new ChromeDriver();
      WebBrowser.get("https://the-internet.herokuapp.com/dropdown");

      WebElement dropdown = WebBrowser.findElement(By.id("dropdown")); //pytanie - żeby napisać poprawny test w oparciu id/name/css to muszę sprawdzić w devtoolsach
      Select select = new Select(dropdown);
      select.selectByVisibleText("Option 2");

      assertEquals("Option 2", select.getFirstSelectedOption().getText()); // to mi się samo pojawilo
   }

   @AfterEach
   void closeBrowser() {
      WebBrowser.quit();
   }
} */


/*@Test
void wrongPassword() {
    WebBrowser = new ChromeDriver();
   WebBrowser.get("https://the-internet.herokuapp.com/login");

   WebElement username = WebBrowser.findElement(By.id("username"));
   username.sendKeys("tomsmith"); // o co tu chodzi?

   WebElement password = WebBrowser.findElement(By.id("password"));
   password.sendKeys("wrong");

   WebElement loginButton = WebBrowser.findElement(By.className("radius")); //css?
   loginButton.click();

   String message = WebBrowser.findElement(By.id("message")).getText();

   assertTrue(message.contains("Wrong Password"));
    assertEquals(false, WebBrowser.getCurrentUrl().contains("/secure")); // ? tu coś jest nie tak
}
   @AfterEach
   void closeBrowser() {
      WebBrowser.quit();
   }
} */


