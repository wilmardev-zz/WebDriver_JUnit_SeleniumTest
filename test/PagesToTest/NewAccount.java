package PagesToTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

    WebDriver webDriver;

    By txtCustomerId = By.name("cusid");
    By listAccountType = By.name("selaccount");
    By txtInitialDeposit = By.name("inideposit");
    By btnSubmit = By.name("button2");

    public NewAccount(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void SetTxtId(String Id) {
        webDriver.findElement(txtCustomerId).sendKeys(Id);
    }

    public void SetListType(String Type) {
        new Select(webDriver.findElement(listAccountType)).selectByVisibleText(Type);
    }

    public void SetTxtInitialDeposit(String InitialDeposit) {
        webDriver.findElement(txtInitialDeposit).sendKeys(InitialDeposit);
    }

    public void ClickBtnSubmit() {
        webDriver.findElement(btnSubmit).click();
    }

    public void CreateNewAccount(String Id, String Type, String InitialDeposit) {
        SetTxtId(Id);
        SetListType(Type);
        SetTxtInitialDeposit(InitialDeposit);
        ClickBtnSubmit();
    }

    public String GetAccountId() {
        WebElement Id = webDriver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]"));
        return Id.getText();
    }

}
