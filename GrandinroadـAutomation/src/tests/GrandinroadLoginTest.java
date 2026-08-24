package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utility.TestData;

public class GrandinroadLoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;


    // =====================================================
    // TEST 1
    // Verify Homepage
    // =====================================================

    @Test(priority = 1)
    public void verifyHomePage() {

        homePage = new HomePage(driver, wait);

        Assert.assertTrue(
                homePage.getLogo().isDisplayed(),
                "Grandinroad logo is not displayed"
        );

        System.out.println(
                "PASS: Logo is displayed"
        );
    }


    // =====================================================
    // TEST 2
    // Navigate to Login Page
    // =====================================================

    @Test(
            priority = 2,
            dependsOnMethods = "verifyHomePage"
    )
    public void navigateToLoginPage() {

        homePage.openMyAccount();

        System.out.println(
                "PASS: My Account clicked"
        );


        homePage.clickSignIn();

        System.out.println(
                "PASS: Sign In / Create an Account clicked"
        );


        loginPage = new LoginPage(driver, wait);


        String actualTitle =
                loginPage
                        .getLoginTitle()
                        .getText();

        String expectedTitle =
                "Sign in for Registered Customers";


        Assert.assertEquals(
                actualTitle.toLowerCase(),
                expectedTitle.toLowerCase(),
                "Login page title is incorrect"
        );


        System.out.println(
                "Login Form Title: " + actualTitle
        );

        System.out.println(
                "PASS: Login page title is correct"
        );
    }


    // =====================================================
    // TEST 3
    // Login
    // =====================================================

    @Test(
            priority = 3,
            dependsOnMethods = "navigateToLoginPage"
    )
    public void loginTest() {

        loginPage.enterEmail(
                TestData.EMAIL
        );

        System.out.println(
                "PASS: Email entered"
        );


        loginPage.enterPassword(
                TestData.PASSWORD
        );

        System.out.println(
                "PASS: Password entered"
        );


        loginPage.clickSignIn();

        System.out.println(
                "PASS: Sign In button clicked"
        );


        loginPage.waitForLoginSuccess();

        System.out.println(
                "PASS: Login completed"
        );
    }


    // =====================================================
    // TEST 4
    // Verify Successful Login
    // =====================================================

    @Test(
            priority = 4,
            dependsOnMethods = "loginTest"
    )
    public void verifyLoggedInUser() {

        // Verify My Account is displayed after login
        Assert.assertTrue(
                homePage.getMyAccountButton().isDisplayed(),
                "My Account is not displayed after login"
        );

        System.out.println(
                "PASS: My Account is displayed after login"
        );


        // Open My Account
        homePage.openMyAccount();

        System.out.println(
                "PASS: My Account opened after login"
        );


        // Get welcome message
        String welcomeText =
                homePage
                        .getWelcomeUser()
                        .getText();

        System.out.println(
                "Account text: " + welcomeText
        );


        // Extract first name
        String actualFirstName =
                welcomeText
                        .replaceAll(
                                "(?i)welcome",
                                ""
                        )
                        .trim();


        // Verify username
        Assert.assertEquals(
                actualFirstName.toLowerCase(),
                TestData.FIRST_NAME.toLowerCase(),
                "Logged-in user name is incorrect"
        );


        System.out.println(
                "PASS: User logged in successfully"
        );

        System.out.println(
                "PASS: Logged-in user name is correct"
        );
    }
}