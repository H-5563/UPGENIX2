package com.upgenix.stepDefinitions;

import com.upgenix.pages.LoginPage;
import com.upgenix.pages.LogoutPage;
import com.upgenix.utilities.BrowserUtilities;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDefinitions {
    LoginPage loginPage=new LoginPage();
    LogoutPage logoutPage=new LogoutPage();
    @Given("user is on the Upgenix home page")
    public void user_is_on_the_upgenix_home_page() {
        Driver.getDriver().get("https://qa.upgenix.net/web/login");
        loginPage.usernameBox.sendKeys("posmanager70@info.com");
        loginPage.passwordBox.sendKeys("posmanager");
        loginPage.loginButton.click();
    }

    @When("user clicks to user menu button")
    public void userClicksToUserMenuButton() {
        BrowserUtilities.sleep(2);
        logoutPage.userMenu.click();
    }

    @And("user clicks logout button")
    public void userClicksLogoutButton() {
        BrowserUtilities.sleep(2);
        logoutPage.logoutButton.click();
    }

    @Then("user go to login page")
    public void userGoToLoginPage() {
        String expectedURL="https://qa.upgenix.net/web/login";
        String actualURL= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);
    }

    @When("user back to page but doesn't see homepage")
    public void userBackToPageButDoesnTSeeHomepage() {
        Driver.getDriver().navigate().back();
        String expectedURL="https://qa.upgenix.net/web/login";
        String actualURL= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);

    }
}
