package tests

import core.DriverSettings
import org.testng.Assert
import org.testng.annotations.Test
import pages.LogInPage
import pages.MainPage

class LoginTests : DriverSettings()  {


    @Test
    fun loginTest() {

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