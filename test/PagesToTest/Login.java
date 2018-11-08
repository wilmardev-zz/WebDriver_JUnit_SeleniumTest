
package PagesToTest;
import org.openqa.selenium.*;

public class Login {
    WebDriver webDriver;
    
    By txtUser = By.name("uid");
    By txtPassword = By.name("password");
    By btnLogin = By.name("btnLogin");
    
    public Login(WebDriver Driver){
        this.webDriver = Driver;
    }
    
    public void SetTxtUser(String User){
        webDriver.findElement(txtUser).sendKeys(User);
    }
    
    public void SetTxtPassword(String Password){
        webDriver.findElement(txtPassword).sendKeys(Password);
    }
    
    public void ClickBtnLogin(){
        webDriver.findElement(btnLogin).click();
    }
    
    public void SignIn(String User, String Password){
        SetTxtUser(User);
        SetTxtPassword(Password);
        ClickBtnLogin();
    }
    
    public String getUserNameLogin(){
        WebElement message = webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
        return message.getText();
    }
}
