package pages

import core.DriverSettings
import org.openqa.selenium.By
import org.testng.Assert

class MainPage : DriverSettings() {

    val logInID = "auth-header-open-modal-button"
    val logOutID = "auth-header-logout-button"
    val headerUserNameID = "auth-header-username"

    fun clickLoginBtn() {
        getDriver().findElement(By.ById(logInID)).click()
    }

    fun clickLogOutBtn() {
        getDriver().findElement(By.ById(logOutID)).click()
    }

    fun assertNickName() {
        val element = getDriver().findElement(By.ById(headerUserNameID)).text
        Assert.assertEquals(element, "@tester")
    }
}

