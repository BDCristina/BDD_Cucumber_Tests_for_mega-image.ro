package my_proj_bdd.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my_proj_bdd.driver.DriverManager;
import my_proj_bdd.pages.HomePage;

public class HomeSteps extends DriverManager {

    HomePage homePage = new HomePage(driver);

    @Given("I am a user on Mega Image home page")
    public void openHomepage(){
        homePage.openHomePage();
    }

    @Then("I validate cookie header and click accept cookies button")
    public void acceptCookieHeader(){
        homePage.validateCookieHeader();
        homePage.clickAcceptCookiesButton();
    }

    @When("I click 'Contul meu' button")
    public void clickContulMeu() {
        homePage.clickContulMeuButton();
    }

    @When("I click 'Shopping Cart' button")
    public void clickShoppingCart() {
        homePage.clickShoppingCartButton();
    }

    @When("I click 'Adauga' button with index: (.*)$")
    public void clickAdauga(String index) {
        homePage.clickAddToBasketButtonByIndex(index);
        homePage.clickAlegeMaiTarziuButton();
    }


}
