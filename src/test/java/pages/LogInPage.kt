package pages

import core.DriverSettings
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Action
import org.testng.Assert
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.interactions.Actions




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
        /*Thread.sleep(2000)
        //1
        getDriver().findElement(By.id(receiveCodeBtnID))
        Thread.sleep(1000)
        getDriver().findElement(By.id(receiveCodeBtnID)).click()*/

        getDriver().findElement(By.linkText("Получить код")).click()

        //2
        /*val wait = WebDriverWait(getDriver(), 3)
        val js = getDriver() as JavascriptExecutor
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(receiveCodeBtnID)))
        val element = getDriver().findElement(By.id(receiveCodeBtnID))*/

        //3
        /*val element = getDriver().findElement(By.id(receiveCodeBtnID))
        val wait = WebDriverWait(DriverSettings.getDriver(), 3)
        wait.until<WebElement>(ExpectedConditions.visibilityOf(element))
        wait.until(ExpectedConditions.elementToBeClickable(element))
        val action = Actions(DriverSettings.getDriver())
        action.moveToElement(element)
        val javascript = getDriver() as JavascriptExecutor
        javascript.executeScript("var element = document.querySelector('id=auth-to-step-two-button'); element.value = 3;")*/

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