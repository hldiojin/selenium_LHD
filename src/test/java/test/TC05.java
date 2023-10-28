package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import model.pages.RegisterPageSimple;

import java.util.Random;

public class TC05 {
    public static void main(String[] args) {
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // Step 1: Navigate to the specified URL
            driver.get("http://live.techpanda.org/");

            // Step 2: Click on the 'My Account' link
            WebElement accountMenu = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            accountMenu.click();
            WebElement myAccountLink = driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']"));
            myAccountLink.click();

            // Step 3: Click 'Create an Account' link and fill New User information
            WebElement createAccountLink = driver.findElement(By.xpath("//a[@title='Create an Account']"));
            createAccountLink.click();
            RegisterPageSimple registerPage = new RegisterPageSimple(driver); // Assuming you have a RegisterPageSimple class
            Random random = new Random();
            String firstName = "User" + random.nextInt(1000);
            String middleName = "Middle" + random.nextInt(1000);
            String lastName = "Test" + random.nextInt(1000);
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";
            registerPage.inputFirstName(firstName);
            registerPage.inputMiddleName(middleName);
            registerPage.inputLastName(lastName);
            registerPage.inputEmail(email);
            registerPage.inputPassword("test123");
            registerPage.inputConfirmation("test123");
            registerPage.tickIsSubscribed();

            // Step 4: Click 'Register'
            registerPage.clickRegister();

            // Step 5: Verify Registration is done
            WebElement registrationMessage = driver.findElement(By.xpath("//span[normalize-space()='Thank you for registering with Main Website Store.']"));
            String message = registrationMessage.getText();
            System.out.println("Registration message: " + message);

            // Step 6: Go to TV menu
            WebElement tvMenu = driver.findElement(By.xpath("//a[normalize-space()='TV']"));
            tvMenu.click();

            // Step 7: Add product to your wish list - use product - LG LCD
            WebElement product = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]"));
            product.click();

            // Step 8: Click 'SHARE WISHLIST'
            WebElement shareWishlist = driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]"));
            shareWishlist.click();

            // Step 9: Enter Email and a message and click 'SHARE WISHLIST'
            WebElement emailField = driver.findElement(By.id("email_address"));
            emailField.sendKeys("example@example.com");
            WebElement messageField = driver.findElement(By.id("message"));
            messageField.sendKeys("Check out my wishlist!");
            WebElement shareButton = driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]"));
            shareButton.click();

            // Step 10: Check wishlist is shared
            WebElement sharedMessage = driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']"));
            String sharedMsg = sharedMessage.getText();
            System.out.println("Share wishlist message: " + sharedMsg);
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
