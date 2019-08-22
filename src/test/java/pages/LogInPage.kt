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
    val nickNameInputID = "auth-create-username"
    val errorUserNameID = "auth-create-username-error"
    val nameInputID = "auth-create-first_name"
    val errorNameID = "auth-create-first_name-error"
    val invateCodeInputID = "auth-create-invite_code"
    val errorInviteCodeID = "auth-create-invite_code-error"

    val phoneNumber1 = "111111111"
    val correctCode = "7642"
    val incorrectCode = "1234"
    val errorCodeText = "Неправильный код. Осталось 4 попытки"

    val errorMailText = "Значение «Email» не является правильным email адресом."
    val errLoginText = "Необходимо заполнить «Логин»."

    val errNameStartFromNumberText = "Поле Имя должно начинаться с буквы"
    val errNameWithNumbersText =  "В Имя допустимы только буквы и дефис"
    val errNameWith2SimbolsText = "минимум три буквы"

    val inviteCodeText = "G42GD"
    val errShortInviteCodeText = "Значение «Invite Code» должно содержать 5 символов."

    val correctMailText = "qqq@qqq.qqq"
    val correctNickName = "tester123"
    val correctName = "АбраКадабра"

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
        getDriver().findElement(By.ById(codeInputID)).sendKeys(incorrectCode)
    }

    fun assertCodeError() {
        val element = getDriver().findElement(By.ById(errorCodeID)).text
        Assert.assertEquals(element, errorCodeText)
    }

    fun clickConfirmCode() {
        getDriver().findElement(By.ById(confirmCodeBtnID)).click()
    }

    fun moveToSecondScreen() {
        MainPage().clickLoginBtn()
        waitFirstLoginScreen()
        enterPhoneNumber()
        clickReceiveCodeBtn()
        waitSecondLoginScreen()
    }

    fun login() {
        moveToSecondScreen()
        enterCode()
        clickConfirmCode()
    }

    fun enterMail() {
        getDriver().findElement(By.ById(mailInputID)).sendKeys(correctMailText)
    }
    fun assertWrongMailError() {
        val element = getDriver().findElement(By.ById(errorMailID)).text
        Assert.assertEquals(element, errorMailText)
    }

    fun enterNickName() {
        getDriver().findElement(By.ById(nickNameInputID)).sendKeys(correctNickName)
    }
    fun assertEmptyNickNameError() {
        val element = getDriver().findElement(By.ById(errorUserNameID)).text
        Assert.assertEquals(element, errLoginText)
    }

    fun enterName() {
        getDriver().findElement(By.ById(nameInputID)).sendKeys(correctName)
    }
    fun assertNameErrStartWithNumber() {
        val element = getDriver().findElement(By.ById(errorNameID)).text
        Assert.assertEquals(element, errNameStartFromNumberText)
    }
    fun assertNameWithNumbers() {
        val element = getDriver().findElement(By.ById(errorNameID)).text
        Assert.assertEquals(element, errNameWithNumbersText)
    }
    fun assertShortName() {
        val element = getDriver().findElement(By.ById(errorNameID)).text
        Assert.assertEquals(element, errNameWith2SimbolsText)
    }

    fun enterInviteCode() {
        getDriver().findElement(By.ById(invateCodeInputID)).sendKeys(inviteCodeText)
    }
    fun assertShortInviteCode() {
        val element = getDriver().findElement(By.ById(invateCodeInputID)).text

    }

}