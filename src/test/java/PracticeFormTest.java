import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class PracticeFormTest extends TestBase {

    @Test
    void succesfulFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(genderMale)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("E").pressEnter();
        $("#subjectsInput").clear();
        $("#subjectsInput").setValue("H").pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $x("//tr[td[text()='Student Name']]/td[2]").shouldHave(text(firstName + " " + lastName));
        $x("//tr[td[text()='Student Email']]/td[2]").shouldHave(text(userEmail));
        $x("//tr[td[text()='Gender']]/td[2]").shouldHave(text(genderMale));
        $x("//tr[td[text()='Mobile']]/td[2]").shouldHave(text(userNumber));
        $x("//tr[td[text()='Date of Birth']]/td[2]").shouldHave(text("19" + " " + birthMonth + "," + birthYear));
        $x("//tr[td[text()='Subjects']]/td[2]").shouldHave(text("English, Hindi"));
        $x("//tr[td[text()='Hobbies']]/td[2]").shouldHave(text(hobby));
        $x("//tr[td[text()='Picture']]/td[2]").shouldHave(text(picture));
        $x("//tr[td[text()='Address']]/td[2]").shouldHave(text(currentAddress));
        $x("//tr[td[text()='State and City']]/td[2]").shouldHave(text("Uttar Pradesh Lucknow"));

    }
        @Test
        void succesfulRequiredFieldsTests() {
            open("/automation-practice-form");
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#genterWrapper").$(byText(genderFemale)).click();
            $("#userNumber").setValue(userNumber);
            $("#submit").click();

            $(".modal-content").shouldBe(visible);
            $x("//tr[td[text()='Student Name']]/td[2]").shouldHave(text(firstName + " " + lastName));
            $x("//tr[td[text()='Gender']]/td[2]").shouldHave(text(genderFemale));
            $x("//tr[td[text()='Mobile']]/td[2]").shouldHave(text(userNumber));

    }

        @Test
        void negativeUserNumberTests() {
            open("/automation-practice-form");
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#genterWrapper").$(byText(genderFemale)).click();
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
             $("#genterWrapper").$(byText(genderMale)).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
             $("#genterWrapper").$(byText(genderFemale)).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
             $("#genterWrapper").$(byText(genderOther)).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

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
            $("#userName").setValue(firstName + " " + lastName);
            $("#userEmail").setValue(userEmail);
            $("#currentAddress").setValue(currentAddress);
            $("#permanentAddress").setValue(permanentAddress);
            $("#submit").click();

            $("#output #name").shouldHave(text(firstName + " " + lastName));
            $("#output #email").shouldHave(text(userEmail));
            $("#output #currentAddress").shouldHave(text(currentAddress));
            $("#output #permanentAddress").shouldHave(text(permanentAddress));

    }

        @Test
        void negativeSimpleFormTests() {
            open("/text-box");
            $("#userName").setValue(firstName + " " + lastName);
            $("#userEmail").setValue("romanivi.ru");
            $("#submit").click();

            $("#userEmail").shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));
            $("#output #name").shouldNotBe(visible);
            $("#output #email").shouldNotBe(visible);

    }
}
