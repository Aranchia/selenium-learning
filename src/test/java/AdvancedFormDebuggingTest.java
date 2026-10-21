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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdvancedFormDebuggingTest {

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
    @DisplayName("ZADANIE 1: DemoQA - Walidacja formularza i numeru telefonu")
    public void testStudentRegistrationForm() {
        driver.get("https://demoqa.com/automation-practice-form");

        // BŁĄD 1: Celowo błędny ID dla pola 'First Name' ('firstNameInput' zamiast 'firstName') -> NoSuchElementException
        WebElement firstName = driver.findElement(By.id("firstNameInput"));
        firstName.sendKeys("Anna");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Kowalska");

        // BŁĄD 2: Zły ID w e-mailu ('userEmailAddress' zamiast 'userEmail') -> NoSuchElementException
        WebElement userEmail = driver.findElement(By.id("userEmailAddress"));
        userEmail.sendKeys("anna.kowalska@example.com");

        // BŁĄD 3: Kliknięcie w label radio buttona
        WebElement genderFemale = driver.findElement(By.cssSelector("label[for='gender-radio-2']"));
        genderFemale.click();

        // BŁĄD 4: Zły format numeru - przesłano za krótki string (9 cyfr zamiast wymaganych 10)
        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("123456789");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // BŁĄD 5: Modal się nie pojawia ze względu na błąd walidacji numeru tel. -> NoSuchElementException / TimeoutException
        WebElement modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg"));
        assertEquals("Thanks for submitting the form", modalTitle.getText());
    }

    @Test
    @DisplayName("ZADANIE 2: Automation Testing Practice - Kraj i Wybór z Listy")
    public void testDropdownsAndMultiSelect() {
        driver.get("https://testautomationpractice.blogspot.com/");

        // BŁĄD 6: Błędny ID rozwijanej listy krajów ('country-select' zamiast 'country') -> NoSuchElementException
        WebElement countrySelectElement = driver.findElement(By.id("country-select"));
        Select countrySelect = new Select(countrySelectElement);

        // BŁĄD 7: Wybór opcji ze złą wielkością liter ("poland" zamiast "Poland") -> NoSuchElementException
        countrySelect.selectByVisibleText("poland");

        // BŁĄD 8: Błędny lokator listy kolorów ('color' zamiast 'colors') -> NoSuchElementException
        Select colorsSelect = new Select(driver.findElement(By.id("color")));
        colorsSelect.selectByValue("red");

        assertEquals("Poland", countrySelect.getFirstSelectedOption().getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
