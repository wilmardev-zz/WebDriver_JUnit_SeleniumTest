package PagesToTest;

import org.openqa.selenium.By;
import org.openqa.selenium.*;

public class NewCustomer {

    WebDriver webDriver;

    By txtCustomerName = By.name("name");
    By txtDateBirth = By.id("dob");
    By txtAddress = By.name("addr");
    By txtCity = By.name("city");
    By txtState = By.name("state");
    By txtPIN = By.name("pinno");
    By txtTelephoneNumber = By.name("telephoneno");
    By txtEmail = By.name("emailid");
    By txtPassword = By.name("password");
    By btnSubmit = By.name("sub");

    public NewCustomer(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void SetTxtName(String name) {
        webDriver.findElement(txtCustomerName).sendKeys(name);
    }

    public void SetCheckGender(String gender) {
        if (gender.equals("f")) {
            webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();
        } else {
            webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")).click();
        }
    }

    public void SetTxtDateBirth(String dateBirth) {
        webDriver.findElement(txtDateBirth).sendKeys(dateBirth);
    }

    public void SetTxtAddress(String address) {
        webDriver.findElement(txtAddress).sendKeys(address);
    }

    public void SetTxtCity(String city) {
        webDriver.findElement(txtCity).sendKeys(city);
    }

    public void SetTxtState(String state) {
        webDriver.findElement(txtState).sendKeys(state);
    }

    public void SetTxtPIN(String pin) {
        webDriver.findElement(txtPIN).sendKeys(pin);
    }

    public void SetTxtMobileNumber(String mobileNumber) {
        webDriver.findElement(txtTelephoneNumber).sendKeys(mobileNumber);
    }

    public void SetTxtEmail(String email) {
        webDriver.findElement(txtEmail).sendKeys(email);
    }

    public void SetTxtPassword(String password) {
        webDriver.findElement(txtPassword).sendKeys(password);
    }

    public void ClickBtnSubmitCustomer() {
        webDriver.findElement(btnSubmit).click();
    }
    
    public void CreateCustomer(String[] dataCustomer) throws InterruptedException{
        SetTxtName(dataCustomer[0]);
        SetCheckGender(dataCustomer[1]);
        SetTxtDateBirth(dataCustomer[2]);
        SetTxtAddress(dataCustomer[3]);
        SetTxtCity(dataCustomer[4]);
        SetTxtState(dataCustomer[5]);
        SetTxtPIN(dataCustomer[6]);
        SetTxtMobileNumber(dataCustomer[7]);
        SetTxtEmail(dataCustomer[8]);
        SetTxtPassword(dataCustomer[9]);
        ClickBtnSubmitCustomer();
        
    }
    
    public String GetIdCustomer(){
        WebElement Id = webDriver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]"));
        return Id.getText();
    }
}
