import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import static testdata.TestData.*;

public class PracticeFormTest extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void succesfulFormTests() {

        practiceFormPage.openPage()
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .typeUserEmail(userEmail)
                    .setGender(genderMale)
                    .typeUserNumber(userNumber)
                    .setDateOfBirth(birthDay, birthMonth, birthYear)
                    .typeSubjects(subjectValueFirst)
                    .typeSubjects(subjectValueSecond)
                    .setHobbies(hobby)
                    .uploadPicture(picture)
                    .typeAddress(currentAddress)
                    .setState(stateOption)
                    .setCity(cityOption)
                    .submitForm()

                    .checkModalWindow()
                    .CkeckFields("Student Name", firstName + " " + lastName)
                    .CkeckFields("Student Email", userEmail)
                    .CkeckFields("Gender", genderMale)
                    .CkeckFields("Mobile", userNumber)
                    .CkeckFields("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                    .CkeckFields("Subjects", subjectValueFirst + ", " + subjectValueSecond)
                    .CkeckFields("Hobbies", hobby)
                    .CkeckFields("Picture", picture)
                    .CkeckFields("Address", currentAddress)
                    .CkeckFields("State and City", stateOption + " " + cityOption);

    }
        @Test
        void succesfulRequiredFieldsTests() {
            practiceFormPage.openPage()
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .setGender(genderMale)
                    .typeUserNumber(userNumber)
                    .submitForm()

                    .checkModalWindow()
                    .CkeckFields("Student Name", firstName + " " + lastName)
                    .CkeckFields("Gender", genderMale)
                    .CkeckFields("Mobile", userNumber);

    }

        @Test
        void negativeUserNumberTests() {
            practiceFormPage.openPage()
                    .typeFirstName(firstName)
                    .typeLastName(lastName)
                    .setGender(genderMale)
                    .typeUserNumber("8999")
                    .submitForm()

                    .checkUserValidForm();

    }
         @Test
         void negativeRequiredFieldsTests() {
             practiceFormPage.openPage()
                     .submitForm()

                    .checkUserNameBorderColor()
                    .checkUserSurnameBorderColor()
                    .checkUserNumberBorderColor()
                    .checkSetGenderBorderColor(genderMale)
                    .checkSetGenderBorderColor(genderFemale)
                    .checkSetGenderBorderColor(genderOther);
    }

         @Test
         void negativeUserEmailTests() {
             practiceFormPage.openPage()
                     .typeUserEmail("roman@ivi")
                     .submitForm()

                     .checkUserMailBorderColor();

    }
}
