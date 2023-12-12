package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlistener.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class ComputerTest extends BaseTest {
HomePage homePage;
LoginPage loginPage;
@BeforeMethod(alwaysRun = true)
    public void init(){
    homePage = new HomePage();
    loginPage = new LoginPage();
}
@Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
    homePage.clickOnLoginLink();
    loginPage.enterEmailId("Yogmaya@gmail.com");
    loginPage.enterPassword("Ohm108");
    loginPage.clickOnLoginButton();
    String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"+ "No customer account found";
    String actualErrorMessage = loginPage.getErrorMessage();
    Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
}
@Test(groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(){
    homePage.clickOnLoginLink();
    loginPage.enterEmailId("Yogmaya@gamil.com");
    loginPage.enterPassword("Ohm108");
    loginPage.clickOnLoginButton();
    String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" + "no customer account found";
    String actualErrorMessage = loginPage.getErrorMessage();
    Assert.assertEquals(expectedErrorMessage,actualErrorMessage,"Error message not displayed");
}
}
