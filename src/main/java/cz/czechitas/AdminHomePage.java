package cz.czechitas;

import org.openqa.selenium.*;

public class AdminHomePage {

    private WebDriver browser;

    public AdminHomePage(WebDriver webDriver) {
        browser =  webDriver;
    }

    public boolean IsNavigationMenuShown(){
        System.out.println("Hledam hlavni menu");

        WebElement navListElement = browser.findElement(By.className("nav-list"));
        return navListElement.isDisplayed();
    }

    public void clickOnUserIcon(){
        System.out.println("Hledam user icon a klikam na ni");

        WebElement userIcon = browser.findElement(By.className("icon-user"));
        userIcon.click();
    }

    public LoginPage clickOnLogout(){
        System.out.println("Hledam Logout a klikam na nej, po uspesnem prihlaseni by uzivatel mel byt presmerovan na Login page");

        WebElement userIcon = browser.findElement(By.xpath("//a[text()=\"Logout\"]"));
        userIcon.click();

        return new LoginPage(browser);
    }
}
