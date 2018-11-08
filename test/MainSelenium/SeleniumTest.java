/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSelenium;

import PagesToTest.BalanceEnquiry;
import PagesToTest.ChangePassword;
import PagesToTest.FundTransfer;
import PagesToTest.HomePage;
import PagesToTest.Login;
import PagesToTest.NewAccount;
import PagesToTest.NewCustomer;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author wilmar.duque
 */
public class SeleniumTest {

    private WebDriver webDriver = null;
    private Login login = null;
    private HomePage homePage = null;
    private FundTransfer fundTransfer = null;
    private ChangePassword changePassword = null;
    private NewAccount newAccount = null;
    private NewCustomer newCustomer = null;
    private BalanceEnquiry balanceEnquiry = null;
    private String payersAccountId = "";
    private String payeesAccountId = "";

    // Static variables
    private final String URL = "http://demo.guru99.com/V4/index.php";
    private final String USER = "mngr161509";
    private final String PASSWORD = "nueva123*";
    private final String INITIAL_DEPOSIT_ACCOUNTS = "50000";
    private final String AMOUNT_TRANSFER_VALUE = "5000";
    private final String ACCOUNT_TYPE_CURRENT = "Current";
    private final String ACCOUNT_TYPE_SAVING = "Savings";

    public SeleniumTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", ".//ChromeWebDriver//chromedriver.exe");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get(URL);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        login = new Login(webDriver);
        login.SignIn(USER, PASSWORD);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    // Este caso de prueba se encargará de la validar si el login se realizó
    // correctamente.
    @Test
    public void Test1VerifyLogin() {
        assertEquals("Manger Id : " + USER, login.getUserNameLogin());
    }

    // Este caso de prueba validará que el campo "Payees Account No"
    // sea requerido para realizar la transferencia
    @Test
    public void Test2RequiredFieldPayeesAccountNo() throws InterruptedException {
        homePage = new HomePage(webDriver);
        fundTransfer = new FundTransfer(webDriver);
        homePage.ClickOptionFundTransfer();
        fundTransfer.RealizeFundTransfer("50685", "", "1000", "TestFundTransfer");
        assertEquals("Please fill all fields", fundTransfer.GetAlterMessageFundTransfer());
    }

    // Este caso de prueba validará el correcto cambio de contraseña
    @Test
    public void Test3ChangePassword() throws InterruptedException {
        homePage = new HomePage(webDriver);
        homePage.ClickOptionChangePassword();
        changePassword = new ChangePassword(webDriver);
        changePassword.ChangePassword(PASSWORD, "nueva123*", "nueva123*");
        assertEquals("Password is Changed", changePassword.getMessageChangePassword());
    }

    // Este caso de prueba validará que al realizar una transferencia las
    // cuentas tanto de origen como de destino se vean impactadas en su saldo.
    @Test
    public void Test4VerifyFoundTransfer() throws InterruptedException {
        String customerId = CreateCustomer();
        // Cuenta que hará la transferencia -> PayersAccount
        payersAccountId = CreateAccounts(customerId, ACCOUNT_TYPE_CURRENT);
        // Cuenta que recibirá la transferencia -> PayeesAccount
        payeesAccountId = CreateAccounts(customerId, ACCOUNT_TYPE_SAVING);
        RealizeFundTransfer();
        String balanceValuePayers = ConsultBalanceAccount(payersAccountId);
        String balanceValuePayees = ConsultBalanceAccount(payeesAccountId);

        // Valor inicial cuenta origen se debe de disminuir
        Integer originBalance = (Integer.parseInt(INITIAL_DEPOSIT_ACCOUNTS))
                - Integer.parseInt(AMOUNT_TRANSFER_VALUE);

        // Valor inicial cuenta origen se debe de disminuir
        Integer destinyBalance = (Integer.parseInt(INITIAL_DEPOSIT_ACCOUNTS))
                + Integer.parseInt(AMOUNT_TRANSFER_VALUE);

        String correctMessage = "Saldo Origen: " + originBalance + ". Saldo Destino: " + destinyBalance;
        String testResults = "Saldo Origen: " + balanceValuePayers + ". Saldo Destino: " + balanceValuePayees;
        
        assertEquals(correctMessage, testResults);
    }

    private String CreateCustomer() throws InterruptedException {
        homePage = new HomePage(webDriver);
        homePage.ClickOptionNewCustomer();
        newCustomer = new NewCustomer(webDriver);
        newCustomer.CreateCustomer(GenerateNewCustomer());
        return newCustomer.GetIdCustomer();
    }

    private String[] GenerateNewCustomer() {
        Random rnd = new Random();
        return new String[]{
            "Wilmar Duque", //[0] Name
            "m", //[1] Gender
            "01/03/1997",//[2] Date Birth
            "Calle Siempre viva 123", //[3] Address
            "Medellin", //[4] City
            "Antioquia", //[5] State
            "6666666", //[6] PIN
            "12375432", //[7] Mobile number
            "wsduque" + rnd.nextInt(10000) + "@gmail.com", //[8] Email
            "pruebas123", //[9] Password
        };
    }

    private String CreateAccounts(String customerId, String accountType) throws InterruptedException {
        homePage = new HomePage(webDriver);
        homePage.ClickOptionNewAccount();
        newAccount = new NewAccount(webDriver);
        newAccount.CreateNewAccount(customerId, accountType, INITIAL_DEPOSIT_ACCOUNTS);
        return newAccount.GetAccountId();
    }

    private void RealizeFundTransfer() throws InterruptedException {
        homePage = new HomePage(webDriver);
        homePage.ClickOptionFundTransfer();
        fundTransfer = new FundTransfer(webDriver);
        fundTransfer.RealizeFundTransfer(payersAccountId, payeesAccountId, AMOUNT_TRANSFER_VALUE, "Fund Transfer Test");
    }

    private String ConsultBalanceAccount(String accountId) throws InterruptedException {
        homePage = new HomePage(webDriver);
        homePage.ClickOptionBalanceEnquiry();
        balanceEnquiry = new BalanceEnquiry(webDriver);
        balanceEnquiry.ConsultBalanceEnquiry(accountId);
        return balanceEnquiry.GetBalanceValue();
    }

}
