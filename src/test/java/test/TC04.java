package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class TC04 {
    public static void main(String[] args) {
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            driver.get("http://live.techpanda.org/");
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();

            WebElement sonyAddToCompare = driver.findElement(By.xpath("//a[@title='Sony Xperia']//following::a[text()='Add to Compare']"));
            sonyAddToCompare.click();

            WebElement iphoneAddToCompare = driver.findElement(By.xpath("//a[@title='IPhone']//following::a[text()='Add to Compare']"));
            iphoneAddToCompare.click();

            WebElement compareButton = driver.findElement(By.xpath("//button[@title='Compare']"));
            compareButton.click();

            String mainWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();

            for (String handle : allWindows) {
                if (!handle.equals(mainWindow)) {
                    driver.switchTo().window(handle);

                    WebElement popupHeading = driver.findElement(By.xpath("//h1[text()='Compare Products']"));
                    System.out.println("Popup window heading: " + popupHeading.getText());

                    WebElement product1 = driver.findElement(By.xpath("//a[normalize-space()='Sony Xperia']"));
                    WebElement product2 = driver.findElement(By.xpath("//a[normalize-space()='IPhone']"));

                    String actualTitle = driver.getTitle();
                    System.out.println("Title in the comparison window: " + actualTitle);

                    System.out.println("Products in the comparison window: ");
                    System.out.println(product1.getText());
                    System.out.println(product2.getText());

                    driver.close();
                }
            }
            driver.switchTo().window(mainWindow);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
