package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriverWait wait;


    // Login page title
    private By loginTitle =
            By.cssSelector(
                    "h2.c-login__heading"
            );


    // Email field
    private By email =
            By.id("email");


    // Password field
    private By password =
            By.id("password");


    // Sign In button
    private By signInButton =
            By.cssSelector(
                    "button[data-analytics-name='login']"
            );


    // Sign In / Create Account link
    // Used to wait until login is completed
    private By signInLink =
            By.cssSelector(
                    "a[title='Sign In / Create an Account']"
            );


    // Constructor
    public LoginPage(
            WebDriver driver,
            WebDriverWait wait) {

        this.wait = wait;
    }


    // Get login page title
    public WebElement getLoginTitle() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        loginTitle
                )
        );
    }


    // Enter email
    public void enterEmail(String userEmail) {

        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        email
                )
        );

        emailField.clear();
        emailField.sendKeys(userEmail);
    }


    // Enter password
    public void enterPassword(String userPassword) {

        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        password
                )
        );

        passwordField.clear();
        passwordField.sendKeys(userPassword);
    }


    // Click Sign In
    public void clickSignIn() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        signInButton
                )
        ).click();
    }


    // Wait until login is completed
    public void waitForLoginSuccess() {

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        signInLink
                )
        );
    }
}