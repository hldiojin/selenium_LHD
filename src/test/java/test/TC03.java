package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TC03 {
    @Test
    public void testcse03(){

        // Create an instance of the ChromeDriver
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // Step 1: Navigate to the specified URL
            driver.get("http://live.techpanda.org/");

            // Step 2: Click on the 'MOBILE' menu
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();

            // Step 3: Click on 'ADD TO CART' for Sony Xperia mobile
            WebElement addToCartButton = driver.findElement(By.xpath("//a[@title='Sony Xperia']//following::button[@title='Add to Cart']"));
            addToCartButton.click();

            // Step 4: Change 'QTY' value to 1000 and click 'UPDATE' button
            WebElement qtyInput = driver.findElement(By.xpath("//input[@title='Qty']"));
            qtyInput.clear();
            qtyInput.sendKeys("1000");

            WebElement updateButton = driver.findElement(By.xpath("//button[@title='Update']"));
            updateButton.click();

            // Step 5: Verify the error message
            WebElement errorMessage = driver.findElement(By.xpath("//li[@class='error-msg']"));
            String errorText = errorMessage.getText();
            AssertJUnit.assertEquals("The requested quantity for \"Sony Xperia\" is not available.", errorText, "Error message mismatch.");

            // Step 6: Click on 'EMPTY CART' link
            WebElement emptyCartLink = driver.findElement(By.xpath("//a/span[contains(text(),'Empty Cart')]"));
            emptyCartLink.click();

            // Step 7: Verify cart is empty
            WebElement emptyCartMessage = driver.findElement(By.xpath("//h1[text()='Shopping Cart is Empty']"));
            String emptyCartText = emptyCartMessage.getText();
            AssertJUnit.assertEquals("SHOPPING CART IS EMPTY", emptyCartText, "Cart is not empty.");

            System.out.println("Thanks for testing");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
