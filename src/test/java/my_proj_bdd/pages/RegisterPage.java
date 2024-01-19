package my_proj_bdd.pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    public  RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Elemente
    @FindBy(xpath = "//button[@data-testid='submit-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//p[@data-testid='form-error-message']")
    private WebElement validationErrorMsg;

    @FindBy(xpath = "//input[@data-testid='input-field']")
    private WebElement emailPhoneInput;

    @FindBy(xpath = "//h2[@data-testid='create-account-title']")
    private WebElement registerHeader;

    @FindBy(xpath = "//h3[@data-testid='styled-title']")
    private WebElement registerPopupHeader;

    @FindBy(xpath = "//div[contains(text(), 'Creeaza un cont nou')]")
    private WebElement creeazaUnContNouButton;

    @FindBy(xpath = "//span[@data-testid='potential-order-promotions']")
    private WebElement promotionBtn;

    // Actiuni
    public void clickContinueButton() {
        continueButton.click();
    }

    public void fillEmailPhoneInput(String emailPhone) {
        emailPhoneInput.sendKeys(emailPhone);
    }

    public void clickCreeazaUnContNouButton() {
        creeazaUnContNouButton.click();
    }

    public void clickPromotionButton() {
        try {
            // incearca sa dai click daca gasesti acest element
            promotionBtn.click();
        } catch (NoSuchSessionException e) {
            // testul trece mai departe si daca nu am gasit acel element
        }
    }

    // Validari
    public void validateErrorMessage(String expectedMsg) {
        Assert.assertEquals("Validation msg is wrong", expectedMsg, validationErrorMsg.getText());
    }

    public void validateRegisterHeader() {
        Assert.assertEquals("Register header is wrong", "Creeaza un cont nou", registerHeader.getText());
    }
    public void validateRegisterPopupHeader() {
        Assert.assertEquals("Popup register header is wrong", "Se pare ca nu ai un cont activ", registerPopupHeader.getText());
    }

}
