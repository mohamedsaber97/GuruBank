package steps;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hocks extends TestBase {

    public Hocks() throws IOException {
    }

    @Before
    public void beforeTestCase() {
        System.out.println("----------run before test-----------");
    }

    @After
    public void afterTestCase() {
        System.out.println("----------test is finished-----------");
        driver.quit();
    }
}
