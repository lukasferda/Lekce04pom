package cz.czechitas;

import org.openqa.selenium.*;

public class HomePage {
    private WebDriver browser;

    public HomePage(WebDriver webDriver) {
        browser =  webDriver;
    }

    public void fillSearchText(String text) {
        System.out.println("Hledam search box a zapisuji do nej:" + text);

        WebElement searchBox = browser.findElement(By.id("searchField"));
        searchBox.sendKeys(text);
    }

    public SearchResultPage clickOnSearchButton(){
        System.out.println("Hledam search button a klikam na nej. Uzivatel bude presmerovan na vysledek vyhledavani.");

        WebElement searchButton = browser.findElement(By.className("searchButton"));
        searchButton.click();
        return new SearchResultPage(browser);
    }
}
