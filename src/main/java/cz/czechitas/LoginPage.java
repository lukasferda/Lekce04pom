package cz.czechitas;

import org.openqa.selenium.*;

public class LoginPage {
    private WebDriver browser;

    public LoginPage(WebDriver webDriver) {
        browser =  webDriver;
    }

    public void fillUserName(String userName){
        System.out.println("Hledam user name box a zapisuji do nej:" + userName);

        WebElement nameInput = browser.findElement(By.id("username"));
        nameInput.sendKeys(userName);
    }

    public void fillUserPassword(String password){
        System.out.println("Hledam password box a zapisuji do nej:" + password);

        WebElement passwordInput = browser.findElement(By.id("password"));
        passwordInput.sendKeys(password);
    }

    public AdminHomePage clickOnLogon(){
        System.out.println("Hledam Logon tlacitko a klikam na nej, po uspesnem prihlaseni by uzivatel mel byt presmerovan do admin sekce");

        WebElement logonButton = browser.findElement(By.id("formSubmitButton"));
        logonButton.click();

        return new AdminHomePage(browser);
    }
    
    public boolean isInvalidUserAlertPresent(){
        System.out.println("Hledam element s class alert-error ktera znaci ze se prihlaseni nepovedlo");

        WebElement logonButton = browser.findElement(By.className("alert-error"));
        return logonButton.isDisplayed();
    }

}
