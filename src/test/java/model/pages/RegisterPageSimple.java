package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageSimple {
    private WebDriver driver;

    // Declare element selector values here
    private By firstNameSelector = By.id("firstname");
    private By middleNameSelector = By.id("middlename");
    private By lastNameSelector = By.id("lastname");
    private By emailSelector = By.id("email_address");
    private By passwordSelector = By.id("password");
    private By confirmationSelector = By.id("confirmation");
    private By isSubscribedSelector = By.id("is_subscribed");
    private By registerBtnSelector = By.xpath("//button[@title='Register']");

    // Constructor with the required parameter as a WebDriver instance
    public RegisterPageSimple(WebDriver driver) {
        this.driver = driver;
    }

    // Getters to return elements on the page
    public WebElement firstName() {
        return driver.findElement(firstNameSelector);
    }

    public WebElement middleName() {
        return driver.findElement(middleNameSelector);
    }

    public WebElement lastName() {
        return driver.findElement(lastNameSelector);
    }

    public WebElement email() {
        return driver.findElement(emailSelector);
    }

    public WebElement password() {
        return driver.findElement(passwordSelector);
    }

    public WebElement confirmation() {
        return driver.findElement(confirmationSelector);
    }

    public WebElement isSubscribed() {
        return driver.findElement(isSubscribedSelector);
    }

    public WebElement registerBtn() {
        return driver.findElement(registerBtnSelector);
    }

    public void inputFirstName(String firstName) {
        WebElement firstNameElement = driver.findElement(firstNameSelector);
        firstNameElement.sendKeys(firstName);
    }

    public void inputMiddleName(String middleName) {
        WebElement middleNameElement = driver.findElement(middleNameSelector);
        middleNameElement.sendKeys(middleName);
    }

    public void inputLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(lastNameSelector);
        lastNameElement.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        WebElement emailElement = driver.findElement(emailSelector);
        emailElement.sendKeys(email);
    }

    public void inputPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordSelector);
        passwordElement.sendKeys(password);
    }

    public void inputConfirmation(String confirmation) {
        WebElement confirmationElement = driver.findElement(confirmationSelector);
        confirmationElement.sendKeys(confirmation);
    }

    public void tickIsSubscribed() {
        WebElement isSubscribedElement = driver.findElement(isSubscribedSelector);
        isSubscribedElement.click();
    }

    public void clickRegister() {
        WebElement registerBtnElement = registerBtn();
        registerBtnElement.click();
    }
}

