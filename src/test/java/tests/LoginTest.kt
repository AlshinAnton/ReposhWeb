package tests

import core.DriverSettings
import org.testng.Assert
import org.testng.annotations.Test
import pages.LogInPage
import pages.MainPage

class LoginTest : DriverSettings()  {


    @Test
    fun loginTest() {
        System.setProperty("webdriver.chrome", "/usr/local/bin/chromedriver")

        DriverSettings.getDriver().get("https://new.test.reposh.com/brands")

        MainPage().clickLoginBtn()
        LogInPage().waitFirstLoginScreen()
        LogInPage().enterPhoneNumber()
        LogInPage().clickReceiveCodeBtn()
        LogInPage().waitSecondLoginScreen()
        LogInPage().enterCode()
        LogInPage().clickConfirmCode()
        MainPage().assertNickName()

    }
}