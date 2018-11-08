/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PagesToTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author wilmar.duque
 */
public class FundTransfer {

    private final WebDriver webDriver;

    By txtPayersAccountNo = By.name("payersaccount");
    By txtPayeesAccountNo = By.name("payeeaccount");
    By txtAmount = By.name("ammount");
    By txtDescription = By.name("desc");
    By btnSubmit = By.name("AccSubmit");

    public FundTransfer(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void SetTxtPayersAccountNo(String PayersAccountNo) {
        webDriver.findElement(txtPayersAccountNo).sendKeys(PayersAccountNo);
    }

    public void SetTxtPayeesAccountNo(String PayeesAccountNo) {
        webDriver.findElement(txtPayeesAccountNo).sendKeys(PayeesAccountNo);
    }

    public void SetTxtAmount(String Amount) {
        webDriver.findElement(txtAmount).sendKeys(Amount);
    }

    public void SetTxtDescription(String Description) {
        webDriver.findElement(txtDescription).sendKeys(Description);
    }

    public void ClickBtnSubmit() {
        webDriver.findElement(btnSubmit).click();
    }

    public String GetAlterMessageFundTransfer() {
        Alert Messege = webDriver.switchTo().alert();
        return Messege.getText();
    }

    public void RealizeFundTransfer(String PayersAccount, String PayeesAccount, String Amount, String Description) {
        SetTxtPayersAccountNo(PayersAccount);
        SetTxtPayeesAccountNo(PayeesAccount);
        SetTxtAmount(Amount);
        SetTxtDescription(Description);
        ClickBtnSubmit();
    }

}
