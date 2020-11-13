package cz.czechitas;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class SearchTests {

    WebDriver browser;

    @Before
    public void SetUp() {
        //nastavte si prosím cestu k svemu driveru
        System.setProperty("webdriver.gecko.driver", "C:\\DevGit\\geckodriver.exe");

        //muzete pouzit FirefoxOptions pokud chete nebo jste meli problem s firefox binary
        browser = new FirefoxDriver();
    }

    @Test
    public void Search_NonExistingItem_ZeroItemsFound() throws InterruptedException {
        //arrange
        System.out.println("Jdu na home page eshopu");
        browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop/");

        System.out.println("vypisuji Ahoj do search pole");
        WebElement searchBox = browser.findElement(By.className("tt-input"));
        searchBox.sendKeys("nexistujiciVec"); //vypsání ahoj do pole

        Thread.sleep(2000);

        System.out.println("klikam na search button");

        WebElement searchButton = browser.findElement(By.className("searchButton"));
        searchButton.click();

        Thread.sleep(2000);

        System.out.println("Kontroluji ze uzivatel byl presmerovan");

        String currentUrl = browser.getCurrentUrl();

        Assert.assertEquals("Po kliknuti na search button by mel byt uzivatel presmerovan na jinou url", "http://czechitas-shopizer.azurewebsites.net/shop/search/search.html", currentUrl);
    }

    @Test
    public void Search_NonExistingItem_ZeroItemsFound_POM() throws InterruptedException {
        //arrange
        System.out.println("Jdu na home page eshopu");
        browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop/");

        HomePage homePage = new HomePage(browser);

        homePage.fillSearchText("nexistujiciVec");

        SearchResultPage resultPage = homePage.clickOnSearchButton();

        Thread.sleep(2000);

        String result = resultPage.getSearchResultText();

        Assert.assertEquals("msg", "0 item(s) found", result);
    }

    @After
    public void CleanUp() {
        browser.quit();
    }
}
