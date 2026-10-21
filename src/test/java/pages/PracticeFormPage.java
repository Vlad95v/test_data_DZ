package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CkeckFieldComponents;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;


public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();
    CkeckFieldComponents fields = new CkeckFieldComponents();

    //Elements
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement addressInput = $("#currentAddress");
    private SelenideElement stateContainer = $("#react-select-3-input");
    private SelenideElement cityContainer = $("#react-select-4-input");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement modalWindow = $(".modal-content");
    private SelenideElement userForm = $("#userForm");

    // Actions
    public PracticeFormPage  openPage() {
        open("/automation-practice-form");

        return this;
    }

    public PracticeFormPage  typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage  typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage  typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPage  setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage  typeUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage  setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage  typeSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage  setHobbies(String value) {
        hobbiesContainer.$(byText(value)).click();


        return this;
    }

    public PracticeFormPage  uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage  typeAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public PracticeFormPage  setState(String value) {
        stateContainer.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage  setCity(String value) {
        cityContainer.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage submitForm() {
        submitButton.click();

        return this;
    }


    public PracticeFormPage checkModalWindow() {
        modalWindow.shouldBe(visible);

        return this;
    }

    public PracticeFormPage  CkeckFields(String key, String value) {

        fields.checkField(key,value);

        return this;
    }

    public PracticeFormPage checkUserValidForm() {
        userForm.shouldHave(cssClass(validateClass));

        return this;
    }

    public PracticeFormPage checkUserNumberBorderColor() {
        userNumberInput.shouldHave(cssValue(borderColorProperty, errorColor));

        return this;
    }

    public PracticeFormPage checkUserNameBorderColor() {
        firstNameInput.shouldHave(cssValue(borderColorProperty, errorColor));

        return this;
    }

    public PracticeFormPage checkUserSurnameBorderColor() {
        lastNameInput.shouldHave(cssValue(borderColorProperty, errorColor));

        return this;
    }

    public PracticeFormPage checkSetGenderBorderColor(String value) {
        genderContainer.$(byText(value)).shouldHave(cssValue(borderColorProperty, errorColor));

        return this;
    }

    public PracticeFormPage checkUserMailBorderColor() {
        userEmailInput.shouldHave(cssValue(borderColorProperty, errorColor));

        return this;
    }

}
