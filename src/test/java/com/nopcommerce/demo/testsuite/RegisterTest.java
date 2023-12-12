package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlistener.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterTest extends BaseTest {
  HomePage homePage;
  LoginPage loginPage;
  @BeforeMethod(alwaysRun = true)
    public void inIt(){
      loginPage = new LoginPage();
      homePage = new HomePage();
  }
  @Test(groups= {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPAgeSuccessfully(){
      homePage.clickOnLoginLink();
      String expectedMessage = "Welcome, Please Sign in!";
      String actualMessage = loginPage.getWelcomeText();
      Assert.assertEquals(expectedMessage,actualMessage, "Login page not displayed");
  }
    @Test(groups={"smoke" , "regression" })
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("prime123@gmail.com");
        loginPage.enterPassword("prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
    }

    @Test(groups= {"regression" })
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("prime123@gmail.com");
        loginPage.enterPassword("prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
    }
}
