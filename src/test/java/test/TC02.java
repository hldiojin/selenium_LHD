package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TC02 {
    @Test
    public void testcse02() {

        // Create an instance of the ChromeDriver
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // Step 1: Navigate to the specified URL
            driver.get("http://live.techpanda.org/");

            // Step 2: Click on the 'MOBILE' menu
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();

            // Step 3: Read the cost of Sony Xperia mobile
            WebElement costElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String cost = costElement.getText().replace("$", "");
            System.out.println("Cost of Sony Xperia mobile is: " + cost);

            // Step 4: Click on Sony Xperia mobile
            WebElement sonyXperiaLink = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
            sonyXperiaLink.click();

            // Step 5: Read the Sony Xperia mobile from the detail page
            WebElement detailElement = driver.findElement(By.xpath("//span[@class='h1']"));
            String detailProName = detailElement.getText();
            System.out.println("Sony Xperia mobile from detail page is: " + detailProName);

            WebElement detailElementCost = driver.findElement(By.xpath("//span[@class='price']"));
            String detailCost = detailElementCost.getText().replace("$", "");
            System.out.println("Cost of Sony Xperia mobile from detail page is: " + detailCost);

            // Step 6: Compare product value in list and detail page
            AssertJUnit.assertEquals("Produc in list and detail page are not equal.",cost, detailCost );

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
