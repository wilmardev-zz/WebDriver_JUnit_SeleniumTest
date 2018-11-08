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
public class ChangePassword {

    private final WebDriver webDriver;

    By txtOldPassword = By.name("oldpassword");
    By txtNewPassword = By.name("newpassword");
    By txtConfirmPassword = By.name("confirmpassword");
    By btnSubmit = By.name("sub");

    public ChangePassword(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void SetTxtOldPassword(String oldPassword) {
        webDriver.findElement(txtOldPassword).sendKeys(oldPassword);
    }

    public void SetTxtNewPasswird(String newPassword) {
        webDriver.findElement(txtNewPassword).sendKeys(newPassword);
    }

    public void SetTxtConfirmPassword(String confirmPassword) {
        webDriver.findElement(txtConfirmPassword).sendKeys(confirmPassword);
    }

    public void ClickBtnSubmitChangePassword() {
        webDriver.findElement(btnSubmit).click();
    }

    public String getMessageChangePassword() {
        Alert Messege = webDriver.switchTo().alert();
        return Messege.getText();
    }
    
    public void ChangePassword(String oldPassword, String newPassword, String confirmPassword){
        SetTxtOldPassword(oldPassword);
        SetTxtNewPasswird(newPassword);
        SetTxtConfirmPassword(confirmPassword);
        ClickBtnSubmitChangePassword();
    }

}
