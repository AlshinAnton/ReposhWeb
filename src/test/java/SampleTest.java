import core.DriverSettings;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends DriverSettings {

    @Test()
    public void browserInitTest() {
        System.setProperty("webdriver.chrome", "/usr/local/bin/chromedriver");
        getDriver().get("https://new.test.reposh.com/brands");
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());

        Assert.assertEquals(getDriver().getTitle(),"Бренды");

    }
}
