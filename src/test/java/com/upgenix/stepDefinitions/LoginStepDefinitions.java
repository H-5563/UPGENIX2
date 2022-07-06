package com.upgenix.stepDefinitions;

import com.upgenix.pages.LoginPage;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LoginStepDefinitions {
    LoginPage loginPage=new LoginPage();
    @Given("user is on the login page of upgenix app")
    public void user_is_on_the_login_page_of_upgenix_app() {
        Driver.getDriver().get("https://qa.upgenix.net/web/login");

    }
    @When("User enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);

    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        loginPage.loginButton.click();

    }
    @Then("user should see the title is {string}")
    public void user_should_see_the_title_is(String string) {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Odoo";
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();
    }

    @Then("user should see {string}")
    public void userShouldSee(String errorMessage) {
     String expectedErrorMessage="Wrong login/password";
     String actualMessage=loginPage.errormessage.getText();
     Assert.assertEquals(expectedErrorMessage,actualMessage);
    }

    @Then("user should see message {string}")
    public void userShouldSeeMessage(String message) {
        String message1=loginPage.passwordBox.getAttribute("validationMessage");
        String message2=loginPage.usernameBox.getAttribute("validationMessage");
        System.out.println(message1);
        System.out.println(message2);
        Assert.assertTrue((message1.equals(message))||(message2.equals(message)));
    }

    @When("User enters {string} button")
    public void userEntersButton(String resetButton) {
        loginPage.resetPasswordButton.click();
    }

    @Then("user go to  Reset password page")
    public void userGoToResetPasswordPage() {
        String expectedUrl="https://qa.upgenix.net/web/reset_password?";
        String actualURL=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualURL);
        Driver.closeDriver();
    }

    @Then("user clicks to enter key")
    public void userClicksToEnterKey() {
        loginPage.loginButton.sendKeys(Keys.ENTER);
    }

    @Then("user should see the password in bullet signs by default")
    public void userShouldSeeThePasswordInBulletSignsByDefault() {
    Assert.assertTrue(loginPage.bulletPasswordVerify.isDisplayed());
    }
}
