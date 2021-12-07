package pages;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

public class LoginPage extends TestBase {

    public LoginPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "uid")
    WebElement userId;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement submit;


    public void validLogin(String id, String pass) {
        userId.sendKeys(id);
        password.sendKeys(pass);
        submit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public HomePage invalidLogin(String id, String pass) throws IOException {
        userId.sendKeys(id);
        password.sendKeys(pass);
        submit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return new HomePage();
    }

    public void errorMsg() {
        Alert alert = driver.switchTo().alert();
        String error = alert.getText();
        System.out.println("----error message is : " + error);
        Assert.assertTrue(error.contains("User or Password is not valid"));
        alert.accept();
    }

}
