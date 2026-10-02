import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {

    @Test
    void succesfulFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Roman");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("roman@ivi.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999655666");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2027");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("E").pressEnter();
        $("#subjectsInput").clear();
        $("#subjectsInput").setValue("H").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("photo.jpg");
        $("#currentAddress").setValue("Москва, проспект Андропова");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $x("//tr[td[text()='Student Name']]/td[2]").shouldHave(text("Roman Ivanov"));
        $x("//tr[td[text()='Student Email']]/td[2]").shouldHave(text("roman@ivi.ru"));
        $x("//tr[td[text()='Gender']]/td[2]").shouldHave(text("Male"));
        $x("//tr[td[text()='Mobile']]/td[2]").shouldHave(text("8999655666"));
        $x("//tr[td[text()='Date of Birth']]/td[2]").shouldHave(text("19 May,2027"));
        $x("//tr[td[text()='Subjects']]/td[2]").shouldHave(text("English, Hindi"));
        $x("//tr[td[text()='Hobbies']]/td[2]").shouldHave(text("Music"));
        $x("//tr[td[text()='Picture']]/td[2]").shouldHave(text("photo.jpg"));
        $x("//tr[td[text()='Address']]/td[2]").shouldHave(text("Москваhggg, проспект Андропова"));
        $x("//tr[td[text()='State and City']]/td[2]").shouldHave(text("Uttar Pradesh Lucknow"));

    }
        @Test
        void succesfulRequiredFieldsTests() {
            open("/automation-practice-form");
            $("#firstName").setValue("Roman");
            $("#lastName").setValue("Ivanov");
            $("#genterWrapper").$(byText("Female")).click();
            $("#userNumber").setValue("8999655666");
            $("#submit").click();

            $(".modal-content").shouldBe(visible);
            $x("//tr[td[text()='Student Name']]/td[2]").shouldHave(text("Roman Ivanov"));
            $x("//tr[td[text()='Gender']]/td[2]").shouldHave(text("Female"));
            $x("//tr[td[text()='Mobile']]/td[2]").shouldHave(text("8999655666"));

    }

        @Test
        void negativeUserNumberTests() {
            open("/automation-practice-form");
            $("#firstName").setValue("Roman");
            $("#lastName").setValue("Ivanov");
            $("#genterWrapper").$(byText("Female")).click();
            $("#userNumber").setValue("8999");
            $("#submit").click();

            $("#userForm").shouldHave(cssClass("was-validated"));

    }
         @Test
         void negativeRequiredFieldsTests() {
             open("/automation-practice-form");
             $("#submit").click();

             $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
             $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
             $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
             $("#genterWrapper").$(byText("Male")).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
             $("#genterWrapper").$(byText("Female")).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
             $("#genterWrapper").$(byText("Other")).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

         @Test
         void negativeUserEmailTests() {
             open("/automation-practice-form");
             $("#userEmail").setValue("roman@ivi");
             $("#submit").click();

             $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

        @Test
        void succesfulSimpleFormTests() {
            open("/text-box");
            $("#userName").setValue("Ivanov Roman");
            $("#userEmail").setValue("roman@ivi.ru");
            $("#currentAddress").setValue("Москва");
            $("#permanentAddress").setValue("Питер");
            $("#submit").click();

            $("#output #name").shouldHave(text("Ivanov Roman"));
            $("#output #email").shouldHave(text("roman@ivi.ru"));
            $("#output #currentAddress").shouldHave(text("Москва"));
            $("#output #permanentAddress").shouldHave(text("Питер"));

    }

        @Test
        void negativeSimpleFormTests() {
            open("/text-box");
            $("#userName").setValue("Ivanov Roman");
            $("#userEmail").setValue("romanivi.ru");
            $("#submit").click();

            $("#userEmail").shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));
            $("#output #name").shouldNotBe(visible);
            $("#output #email").shouldNotBe(visible);

    }
}
