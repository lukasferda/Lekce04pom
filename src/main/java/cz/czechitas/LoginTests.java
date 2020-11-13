package cz.czechitas;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class LoginTests {
    WebDriver browser;

    @Before
    public void SetUp() {
        //nastavte si prosím cestu k svemu driveru
        System.setProperty("webdriver.gecko.driver", "C:\\DevGit\\geckodriver.exe");

        //muzete pouzit FirefoxOptions pokud chete nebo jste meli problem s firefox binary
        browser = new FirefoxDriver();

        browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/admin/logon.html");
    }

    @Test
    public void Login_ValidUser_AdminSectionIsShown() throws InterruptedException {
        LoginPage loginPage = new LoginPage(browser);

        loginPage.fillUserName("admin@shopizer.com");

        loginPage.fillUserPassword("password");

        AdminHomePage adminHomePage = loginPage.clickOnLogon();

        Thread.sleep(5000);

        Assert.assertTrue("navigacni menu nebylo nalezeno", adminHomePage.IsNavigationMenuShown());
    }

    @Test
    public void Login_InvalidUser_ErrorIsShown() throws InterruptedException {
        LoginPage loginPage = new LoginPage(browser);

        loginPage.fillUserName("nouser");

        loginPage.fillUserPassword("nopass");

        loginPage.clickOnLogon();
        Thread.sleep(5000);

        Assert.assertTrue("mel by se zobrazit alert",loginPage.isInvalidUserAlertPresent());
    }

    @Test
    public void LoginLogout_ValidUser_LogInPageIsShown() throws InterruptedException {
        LoginPage loginPage = new LoginPage(browser);

        loginPage.fillUserName("admin@shopizer.com");

        loginPage.fillUserPassword("password");

        loginPage.clickOnLogon();

        AdminHomePage adminHomePage = new AdminHomePage(browser);

        // potrebuji chvilku pockat :/
        Thread.sleep(5000);

        adminHomePage.clickOnUserIcon();

        adminHomePage.clickOnLogout();

        Thread.sleep(5000);
    }

    @After
    public void CleanUp() {
        browser.quit();
    }
}
