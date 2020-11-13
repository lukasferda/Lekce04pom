package cz.czechitas;

import org.openqa.selenium.*;

public class SearchResultPage {
    private WebDriver browser;

    public SearchResultPage(WebDriver webDriver) {
        browser = webDriver;
    }

    public String getSearchResultText(){
        WebElement el = browser.findElement(By.id("products-qty"));
        return el.getText();
    }
}
