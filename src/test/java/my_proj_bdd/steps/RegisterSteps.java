package my_proj_bdd.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my_proj_bdd.driver.DriverManager;
import my_proj_bdd.pages.RegisterPage;

public class RegisterSteps extends DriverManager {

    RegisterPage registerPage = new RegisterPage(driver);

    @When("I click 'Continua' button")
    public void clickContinue() {
        registerPage.clickContinueButton();
    }

    @When("I fill email/phone input: (.*)$")
    public void fillEmailPhone(String phoneEmail) {
        registerPage.fillEmailPhoneInput(phoneEmail);
//        registerPage.clickPromotionButton();
    }

    @When("I click 'Creeaza un cont nou' button")
    public void clickCreeazaUnContNou() {
        registerPage.clickCreeazaUnContNouButton();
    }

    @Then("I validate error message: (.*)$")
    public void validateMsg(String expectedMsg) {
        registerPage.validateErrorMessage(expectedMsg);
    }

    @Then("I validate register header is displayed")
    public void validateRegisterHeader() {
        registerPage.validateRegisterHeader();
    }

    @Then("I validate register popup header is displayed")
    public void validatePopupRegisterHeader() {
        registerPage.validateRegisterPopupHeader();
    }
}
