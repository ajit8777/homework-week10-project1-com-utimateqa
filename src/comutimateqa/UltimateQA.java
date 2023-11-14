package comutimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

/** Project-5 - ProjectName : com-utimateqa
 BaseUrl = https://courses.ultimateqa.com/
 1. Setup Chrome browser.
 2. Open URL.
 3. Print the title of the page.
 4. Print the current url.
 5. Print the page source.
 6. Click on ‘Sign In’ link
 7. Print the current url
 8. Enter the email to email field.
 9. Enter the password to password field.
 10. Click on Login Button.
 11. Navigate to baseUrl.
 12. Navigate forward to Homepage.
 13. Navigate back to baseUrl.
 14. Refresh the page.
 15. Close the browser.
 */

public class UltimateQA {
    static String browser = "Chrome";
    static String baseUrl = " https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // 1. Setup Multiple browser.
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else if (browser.equalsIgnoreCase("Internet Explorer")){
            driver = new InternetExplorerDriver();
        }else {
            System.out.println("Wrong web browser");
        }

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Implicitly wait time
        driver.manage().window().maximize(); // Maximise the window

        // 2. Open URL.
        driver.get(baseUrl);

        // 3. Print the title of the page.
        System.out.println("The tile of the page is : " + driver.getTitle());

        // 4. Print the current url.
        System.out.println("The current url is : " + driver.getCurrentUrl());

        // 5. Print the page source.
        System.out.println("The page source is : " + driver.getPageSource());

        // 6. Click on ‘Sign In’ link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        Thread.sleep(3000);


        // 7. Print the current url
        System.out.println("The current url is : " + driver.getCurrentUrl());

        // 8. Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("ajit1234@gmail.com");

        // 9. Enter the password to password field.
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("Prime1234");

        // 10. Click on Login Button.
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton.click();
        Thread.sleep(3000);

        // 11. Navigate to baseUrl.
        driver.navigate().to(baseUrl);

        // 12. Navigate forward to Homepage.
        driver.navigate().forward();

        // 13. Navigate back to baseUrl.
        driver.navigate().back();

        // 14. Refresh the page.
        driver.navigate().refresh();

        // 15. Close the browser.
        driver.quit();
    }
}
