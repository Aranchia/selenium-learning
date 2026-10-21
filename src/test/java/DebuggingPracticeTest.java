package testy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DebuggingPracticeTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("ZADANIE 1: Strona Formularz - Błędny lokator ID")
    public void testFormSubmission() {
        driver.get("https://testautomationpractice.blogspot.com/");

        // BŁĄD 1: Błędny ID ('nam' zamiast 'name') -> NoSuchElementException
        WebElement nameInput = driver.findElement(By.id("nam"));
        nameInput.sendKeys("Jan Kowalski");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("jan@example.com");

        WebElement maleRadio = driver.findElement(By.id("male"));
        maleRadio.click();

        assertTrue(maleRadio.isSelected(), "Radio button powinien być zaznaczony");
    }

    @Test
    @DisplayName("ZADANIE 2: Dynamiczne ładowanie AJAX oraz brak oczekiwania")
    public void testDynamicLoading() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();

        // BŁĄD 2: Brak oczekiwania na element ładujący się dynamicznie -> NoSuchElementException
        WebElement finishText = driver.findElement(By.id("finish"));

        // BŁĄD 3: Literówka w oczekiwanym tekście ("Hello World" vs "Hello World!") -> AssertionError
        assertEquals("Hello World", finishText.getText(), "Tekst nagłówka się nie zgadza");
    }

    @Test
    @DisplayName("ZADANIE 3: Błędny indeks w XPath")
    public void testTextRetrieval() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // BŁĄD 4: Odwołanie do nieistniejącego elementu input[3] -> NoSuchElementException
        WebElement checkbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[3]"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        assertTrue(checkbox.isSelected(), "Checkbox powinien być zaznaczony");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
