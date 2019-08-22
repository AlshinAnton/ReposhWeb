package tests

import core.DriverSettings
import org.testng.annotations.Test
import pages.LogInPage
import pages.MainPage

class LoginTests : DriverSettings()  {


    @Test
    fun loginTest() {
        LogInPage().login()
        MainPage().assertNickName()
    }

    @Test
    fun checkCodeError() {
        LogInPage().moveToSecondScreen()
        LogInPage().enterIncorrectCode()
        LogInPage().assertCodeError()
    }

    @Test(enabled = false)
    fun registrationTest() {
        LogInPage().login()
        LogInPage().waitThirdRegistrationScreen()

    }
}