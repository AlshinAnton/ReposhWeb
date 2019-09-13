/*
package pages;

import core.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogiNJavaPage {



    class LogInPage extends DriverSettings {

        private String firstLoginScreenID = "auth-step-one";
        private String phoneNumberInputID = "auth-phone-input";
        private String errorPhoneNumberID = "auth-phone-input-error";
        private String receiveCodeBtnID = "auth-to-step-two-button";

        private String secondLoginScreenID = "auth-step-two";
        private String codeInputID = "auth-code-input";
        private String errorCodeID = "auth-code-input-error";
        private String confirmCodeBtnID = "auth-to-step-three-button";

        private String thirdRegistrationScreen = "auth-step-three";
        private String mailInputID = "auth-create-email";
        private String errorMailID = "auth-create-email-error";
        private String nickNameInputID = "auth-create-username";
        private String errorUserNameID = "auth-create-username-error";
        private String nameInputID = "auth-create-first_name";
        private String errorNameID = "auth-create-first_name-error";
        private String invateCodeInputID = "auth-create-invite_code";
        private String errorInviteCodeID = "auth-create-invite_code-error";

        private String phoneNumber1 = "111111111";
        private String correctCode = "7642";
        private String incorrectCode = "1234";
        private String errorCodeText = "Неправильный код. Осталось 4 попытки";

        private String errorMailText = "Значение «Email» не является правильным email адресом.";
        private String errLoginText = "Необходимо заполнить «Логин».";

        private String errNameStartFromNumberText = "Поле Имя должно начинаться с буквы";
        private String errNameWithNumbersText =  "В Имя допустимы только буквы и дефис";
        private String errNameWith2SimbolsText = "минимум три буквы";

        private String inviteCodeText = "G42GD";
        private String errShortInviteCodeText = "Значение «Invite Code» должно содержать 5 символов.";

        private String correctMailText = "qqq@qqq.qqq";
        private String correctNickName = "tester123";
        private String correctName = "АбраКадабра";

        public void waitFirstLoginScreen() {
            WebElement element = getDriver().findElement(By.id(firstLoginScreenID));
            if (!element.isDisplayed()) {
                System.out.println("Ew lost first login screen");
            }
        }

        public void waitSecondLoginScreen() {
            getDriver().findElement(By.ById(secondLoginScreenID)).isDisplayed
        }

        public void waitThirdRegistrationScreen() {
            getDriver().findElement(By.ById(thirdRegistrationScreen)).isDisplayed
        }

        public void enterPhoneNumber() {
            val element = getDriver().findElement(By.ById(phoneNumberInputID)).sendKeys(phoneNumber1)

        }

        public void clickReceiveCodeBtn() {
           */
/* Thread.sleep(2000);
            WebDriverWait wait = new  WebDriverWait(getDriver(), 10);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(receiveCodeBtnID)));
            Action action = new Action(getDriver());
            element.click()
            getDriver().findElement(By.id(receiveCodeBtnID)).click()*//*


        }

        public void enterCode() {
            getDriver().findElement(By.ById.id(codeInputID)).sendKeys(correctCode)
        }

        public void enterIncorrectCode() {
            getDriver().findElement(By.ById(codeInputID)).sendKeys(incorrectCode)
        }

        public void assertCodeError() {
            WebElement element = getDriver().findElement(By.ById(errorCodeID)).text
            Assert.assertEquals(element, errorCodeText);
        }

        public void clickConfirmCode() {
            getDriver().findElement(By.ById(confirmCodeBtnID)).click()
        }

        public void moveToSecondScreen() {
            new MainPage().clickLoginBtn();
            waitFirstLoginScreen();
            enterPhoneNumber();
            clickReceiveCodeBtn();
            waitSecondLoginScreen();
        }

        public void login() {
            moveToSecondScreen();
            enterCode();
            clickConfirmCode();
        }

        public void enterMail() {
            getDriver().findElement(By.id(mailInputID)).sendKeys(correctMailText);
        }
        public void assertWrongMailError() {
            WebElement element = getDriver().findElement(By.id(errorMailID)).getText();
            Assert.assertEquals(element, errorMailText);
        }

        public void enterNickName() {
            getDriver().findElement(By.ById(nickNameInputID)).sendKeys(correctNickName)
        }
        public void assertEmptyNickNameError() {
            val element = getDriver().findElement(By.ById(errorUserNameID)).text
            Assert.assertEquals(element, errLoginText)
        }

        public void enterName() {
            getDriver().findElement(By.ById(nameInputID)).sendKeys(correctName)
        }
        public void assertNameErrStartWithNumber() {
            val element = getDriver().findElement(By.ById(errorNameID)).text
            Assert.assertEquals(element, errNameStartFromNumberText)
        }
        public void assertNameWithNumbers() {
            val element = getDriver().findElement(By.ById(errorNameID)).text
            Assert.assertEquals(element, errNameWithNumbersText)
        }
        public void assertShortName() {
            val element = getDriver().findElement(By.ById(errorNameID)).text
            Assert.assertEquals(element, errNameWith2SimbolsText)
        }

        public void enterInviteCode() {
            getDriver().findElement(By.ById(invateCodeInputID)).sendKeys(inviteCodeText)
        }
        public void assertShortInviteCode() {
            val element = getDriver().findElement(By.ById(invateCodeInputID)).text
        }

    }
}
*/
