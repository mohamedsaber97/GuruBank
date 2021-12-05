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

    @FindBy(xpath = "//marquee[@class='heading3']")
    WebElement successMsg;


    public void validLogin(String id, String pass) {
        userId.sendKeys(id);
        password.sendKeys(pass);
        submit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void invalidLogin(String id, String pass) {
        userId.sendKeys(id);
        password.sendKeys(pass);
        submit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    public void successMsg() {
        System.out.println("----successMsg is : " + successMsg.getText());
        Assert.assertTrue(successMsg.isDisplayed());
        System.out.println("----home title is : " + driver.getTitle());
        Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
    }

    public void errorMsg() {
        Alert alert = driver.switchTo().alert();
        String error = alert.getText();
        System.out.println("----error message is : " + error);
        Assert.assertTrue(error.contains("User or Password is not valid"));
        alert.accept();
    }

}
