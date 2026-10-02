import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        open("https://duckduckgo.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[data-testid='result']").shouldHave(text("selenide.org"));
    }
}
