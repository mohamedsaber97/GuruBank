package steps;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;

import java.io.IOException;

public class HomeSteps extends TestBase {
    public HomeSteps() throws IOException {
    }

    HomePage homePage;

    @Then("User see success message and home title")
    public void userSeeSuccessMessage() throws IOException {
        homePage = new HomePage();
        homePage.successMsg();
    }

    @And("User take a snapshot")
    public void userTakeASnapshot() throws IOException {
        homePage = new HomePage();
        takeSnapshot();
    }
}
