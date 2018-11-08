package PagesToTest;

import org.openqa.selenium.*;

public class HomePage {

    WebDriver webDriver;

    public HomePage(WebDriver driver) {

        this.webDriver = driver;

    }

    public void ClickOptionFundTransfer() {
        webDriver.findElement(By.linkText("Fund Transfer")).click();
    }

    public void ClickOptionNewCustomer() {
        webDriver.findElement(By.linkText("New Customer")).click();
    }

    public void ClickOptionNewAccount() {
        webDriver.findElement(By.linkText("New Account")).click();
    }

    public void ClickOptionChangePassword() {
        webDriver.findElement(By.linkText("Change Password")).click();
    }

    public void ClickOptionBalanceEnquiry() {
        webDriver.findElement(By.linkText("Balance Enquiry")).click();
    }
}
