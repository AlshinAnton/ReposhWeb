package pages

import core.DriverSettings
import org.openqa.selenium.By
import org.testng.Assert
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait



class LogInPage : DriverSettings() {

    val firstLoginScreenID = "auth-step-one"
    val phoneNumberInputID = "auth-phone-input"
    val errorPhoneNumberID = "auth-phone-input-error"
    val receiveCodeBtnID = "auth-to-step-two-button"

    val secondLoginScreenID = "auth-step-two"
    val codeInputID = "auth-code-input"
    val errorCodeID = "auth-code-input-error"
    val confirmCodeBtnID = "auth-to-step-three-button"

    val thirdRegistrationScreen = "auth-step-three"
    val mailInputID = "auth-create-email"
    val errorMailID = "auth-create-email-error"
    val userNameInputID = "auth-create-username"
    val errorUserNameID = "auth-create-username-error"
    val nameInputID = "auth-create-first_name"
    val errorNameID = "auth-create-first_name-error"
    val invateCodeInputID = "auth-create-invite_code"
    val errorInviteCodeID = "auth-create-invite_code-error"

    val phoneNumber1 = "111111111"
    val correctCode = "7642"
    val incorrectCode = "1234"
    val errorCodeText = "Неправильный код. Осталось 4 попытки"

    fun waitFirstLoginScreen() {
        val element = getDriver().findElement(By.ById(firstLoginScreenID)).isDisplayed
    }

    fun waitSecondLoginScreen() {
        getDriver().findElement(By.ById(secondLoginScreenID)).isDisplayed
    }

    fun waitThirdRegistrationScreen() {
        getDriver().findElement(By.ById(thirdRegistrationScreen)).isDisplayed
    }

    fun enterPhoneNumber() {
        val element = getDriver().findElement(By.ById(phoneNumberInputID)).sendKeys(phoneNumber1)

    }

    fun clickReceiveCodeBtn() {
        Thread.sleep(2000)
        val wait = WebDriverWait(getDriver(), 10)
        val element = wait.until(ExpectedConditions.elementToBeClickable(By.ById(receiveCodeBtnID)))
        element.click()
        //WebDriverWait(DriverSettings.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.ById(receiveCodeBtnID))).click()
        //val element = getDriver().findElement(By.ById(receiveCodeBtnID)).click()

    }

    fun enterCode() {
        getDriver().findElement(By.ById.id(codeInputID)).sendKeys(correctCode)
    }

    fun enterIncorrectCode() {
        getDriver().findElement(By.ById.id(codeInputID)).sendKeys(incorrectCode)
    }

    fun assertCodeError() {
        val element = getDriver().findElement(By.ById.id(errorCodeID)).text
        Assert.assertEquals(element, errorCodeText)
    }

    fun clickConfirmCode() {
        getDriver().findElement(By.ById.id(confirmCodeBtnID)).click()
    }





}