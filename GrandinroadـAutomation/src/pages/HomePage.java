package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriverWait wait;


    // Logo
    private By logo =
            By.cssSelector(
                    "#app-header a .c-dangerous-html svg"
            );


    // My Account button
    private By myAccountButton =
            By.xpath(
                    "//div[contains(@class,'visually-hidden') "
                    + "and normalize-space()='my account']"
                    + "/ancestor::button[1]"
            );


    // Sign In / Create an Account
    private By signInLink =
            By.cssSelector(
                    "a[title='Sign In / Create an Account']"
            );


    // Welcome user after successful login
    private By welcomeUser =
            By.xpath(
                    "//*[translate(normalize-space(.),"
                    + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ',"
                    + "'abcdefghijklmnopqrstuvwxyz')"
                    + "='welcome mohammad']"
            );


    // Constructor
    public HomePage(
            WebDriver driver,
            WebDriverWait wait) {

        this.wait = wait;
    }


    // Get Logo
    public WebElement getLogo() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        logo
                )
        );
    }


    // Get My Account button
    public WebElement getMyAccountButton() {

        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        myAccountButton
                )
        );
    }


    // Open My Account menu
    public void openMyAccount() {

        getMyAccountButton().click();
    }


    // Click Sign In / Create an Account
    public void clickSignIn() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        signInLink
                )
        ).click();
    }


    // Get Welcome user text
    public WebElement getWelcomeUser() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        welcomeUser
                )
        );
    }
}