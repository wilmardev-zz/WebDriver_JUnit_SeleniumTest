package PagesToTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BalanceEnquiry {

    WebDriver webDriver;

    By txtAccountNo = By.name("accountno");
    By btnSubmit = By.name("AccSubmit");

    public BalanceEnquiry(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void SetTxtAccountNo(String idAccount) {
        webDriver.findElement(txtAccountNo).sendKeys(idAccount);
    }

    public void ClickBtnSubmit() {
        webDriver.findElement(btnSubmit).click();
    }

    public void ConsultBalanceEnquiry(String idAccount) {
        SetTxtAccountNo(idAccount);
        ClickBtnSubmit();
    }

    public String GetBalanceValue() {
        WebElement messege = webDriver.findElement(By.xpath("//*[@id=\"balenquiry\"]/tbody/tr[16]/td[2]"));
        return messege.getText();
    }
}
