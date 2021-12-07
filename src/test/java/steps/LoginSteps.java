package steps;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class LoginSteps extends TestBase {
    public LoginSteps() throws IOException {
    }

    LoginPage loginPage;
    HomePage homePage;

    @Given("User open login page")
    public void user_open_login_page() {
        initialization(prop.getProperty("browser"));
    }


    @When("enter valid userId and password")
    public void enter_valid_userId_and_password() throws IOException {
        loginPage = new LoginPage();
        String userId = prop.getProperty("UserId");
        String password = prop.getProperty("Password");
        loginPage.validLogin(userId, password);
    }

    @When("enter invalid {string} and {string}")
    public void enterValidAnd(String userId, String password) throws IOException {
        loginPage = new LoginPage();
        homePage = loginPage.invalidLogin(userId, password);
    }

    @Then("User see error message")
    public void userSeeErrorMessage() {
        loginPage.errorMsg();
    }
}
