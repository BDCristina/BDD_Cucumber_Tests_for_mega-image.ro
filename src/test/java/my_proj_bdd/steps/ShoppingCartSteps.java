package my_proj_bdd.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my_proj_bdd.driver.DriverManager;
import my_proj_bdd.pages.ShoppingCartPage;

public class ShoppingCartSteps extends DriverManager {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

    @When("I click 'Remove product' button")
    public void clickRemoveProductBtn() {
        shoppingCartPage.clickRemoveProductBtn();
    }

    @Then("I validate empty basket message is displayed")
    public void acceptCookies() {
        shoppingCartPage.validateEmptyBasketMsg();
    }

    @Then("I validate shopping cart url is correct")
    public void validateCartUrl() {
        shoppingCartPage.validatePageURL("/checkout");
    }
}
