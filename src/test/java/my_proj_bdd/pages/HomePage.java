package my_proj_bdd.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    public  HomePage(WebDriver driver) {
        super(driver);
    }

    //elemente din pagina
    @FindBy(xpath = "//button[@data-testid='cookie-popup-accept']")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//h2[@data-testid='cookie-popup-title']")
    private WebElement cookieHeader;

    @FindBy(xpath = "//button[@data-testid='header-myhub-toggle']")
    private WebElement contulMeuButton;

    @FindBy(xpath = "//button[@data-testid='product-block-add']")
    private List<WebElement> addToBasketButtonsAsList;

    @FindBy(xpath = "//a[@data-testid='header-minibasket']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//span[@class='sc-dyjemn-11 dclxXB']")
    private WebElement alegeMaiTarziuBtn;


    //actiuni ale acelor elemente
    public void clickAcceptCookiesButton() {
        acceptCookiesButton.click();
    }

    public void openHomePage() {
        driver.get("https://www.mega-image.ro/");
    }

    public void clickContulMeuButton() {
        contulMeuButton.click();
    }

    public void clickAddToBasketButtonByIndex(String index) {
        int index_as_int = Integer.valueOf(index);
        WebElement element = addToBasketButtonsAsList.get(index_as_int);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,700)", "");

        executor.executeScript("arguments[0].click();", element);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickShoppingCartButton(){
        shoppingCartButton.click();

    }

    public void clickAlegeMaiTarziuButton() {
        try {
            // incearca sa dai click daca gasesti acest element
            alegeMaiTarziuBtn.click();
        } catch (NoSuchSessionException e) {
            // testul trece mai departe si daca nu am gasit acel element
        }
    }

    //validari daca vrem sa facem anumite verificari

    public void validateCookieHeader() {
        Assert.assertEquals("Cookie Header title is incorrect", "Cookie-uri pe mega-image.ro", cookieHeader.getText());
    }
}
