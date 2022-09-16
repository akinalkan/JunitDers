package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OdevAutomationExercises01 {
    /*
    Test Case 1: Register User
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public  void teardown(){
        driver.close();
    }
    @Test
    public  void  method(){
        driver.get("http://automationexercise.com");


    }


}
