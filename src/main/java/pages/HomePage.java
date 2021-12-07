package pages;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {
    public HomePage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//marquee[@class='heading3']")
    WebElement successMsg;

    public void successMsg() {
        System.out.println("----successMsg is : " + successMsg.getText());
        Assert.assertTrue(successMsg.isDisplayed());
        System.out.println("----home title is : " + driver.getTitle());
        Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
    }
}
