package core;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BaseTest {

    /**********
    Клики
    **********/

    protected void clickBy(String id) {
        $("#" + id).shouldBe(enabled).click();
    }


    protected boolean isDisplayed(String id) {
        $("#" + id).isDisplayed();
        return true;
    }

    protected void sendKeys(String id, String text) {
        $("#" + id).setValue(text);
    }

    //ждем пока элемент исчезнет
    protected void waitUntillDisappears(String id) {
        $("#"+id).should(disappear);
    }

    //ждем, когда элемент получит текст
    protected void waitWnenElementGetText(String id, String text) {
        $("#"+id).shouldHave(text(text));
    }

    protected void findByText(String text) {

    }


    protected void clickWithTimeOut(String id) {
        int timeout=0;
        while(timeout<30)
        {
            try
            {
                $(id).shouldBe(enabled).click();
                timeout=30;

            }catch(Exception e){

                $(id).shouldBe(enabled).click();

                timeout=timeout+2;
            }
        }
    }
}
