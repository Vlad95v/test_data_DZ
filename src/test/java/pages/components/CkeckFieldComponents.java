package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;


public class CkeckFieldComponents {
    public void checkField(String key, String value) {
        $x("//tr[td[text()='" + key + "']]/td[2]").shouldHave(text(value));

    }
}
