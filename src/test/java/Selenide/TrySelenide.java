package Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit.ScreenShooter;
import core.BaseTest;
import org.junit.*;

import java.io.IOException;

import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selenide.*;


public class TrySelenide extends BaseTest {

    private String logInID = "auth-header-open-modal-button";
    private String logOutID = "auth-header-logout-button";
    private String headerUserNameID = "auth-header-username";

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
    ;

    private String errorMailText = "Значение «Email» не является правильным email адресом.";
    private String errLoginText = "Необходимо заполнить «Логин».";

    private String errNameStartFromNumberText = "Поле Имя должно начинаться с буквы";
    private String errNameWithNumbersText = "В Имя допустимы только буквы и дефис";
    private String errNameWith2SimbolsText = "минимум три буквы";

    private String inviteCodeText = "G42GD";
    private String errShortInviteCodeText = "Значение «Invite Code» должно содержать 5 символов.";

    private String correctMailText = "qqq@qqq.qqq";
    private String correctNickName = "tester123";

    private String correctName = "КорректНэйм";


    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @BeforeClass
    public static void setUp() {
        close();
        Configuration.baseUrl = "https://new.test.reposh.com";
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = PROXY;
        Configuration.reportsFolder = "/Users/Anton/Desktop/webSelenideReports";
    }

    @Test
    public void loginWithSelenide() throws InterruptedException {
        open("/faq");

        isDisplayed(logInID);
        clickBy(logInID);
        isDisplayed(firstLoginScreenID);
        isDisplayed(phoneNumberInputID);
        sendKeys(phoneNumberInputID, phoneNumber1);
        clickBy(receiveCodeBtnID);
        System.out.println("Нормальный клик прошел");
        /*isDisplayed(receiveCodeBtnID);
        clickBy(receiveCodeBtnID);*/

        sleep(3000);

        SelenideElement element = $("#auth-to-step-two-button");
        Selenide.executeJavaScript("document.getElementById('auth-to-step-two-button').removeAttribute('displayed:false')", element);
        Selenide.executeJavaScript("document.getElementById('auth-to-step-two-button').removeAttribute(\"displayed:false\")", element);
        Selenide.executeJavaScript("jQuery('select:not(:visible)').css('display','block')", element);
        element.click();
        System.out.println("Клик с executeJavaScript прошел");

        sleep(3000);

        actions().moveToElement($("#auth-to-step-two-button")).click().perform();
        actions().moveToElement($("#auth-to-step-two-button")).release().perform();
        System.out.println("Клик с click().perform прошел");
        sleep(2000);

        assert $("#auth-step-two").isDisplayed();


        //clickWithTimeOut();

    }


    @After
    public void tearDown() throws IOException {
        close();
        //screenshot();
    }

    /*@Attachmen
    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }*/
}