package com.shinodyan;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Yan");

        $("#lastName").setValue("Bord");

        $("#userEmail").setValue("shinodyan@gmail.com");

        $(byText("Male")).click();

        $("#userNumber").setValue("9032048811");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--002").click();

        $("#subjectsInput").setValue("Arts").pressEnter();

        $(byText("Sports")).click();
        $(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("image/fake.jpg");

        $("#currentAddress").setValue("gagarina street").scrollTo();


        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();



        $("#submit").scrollTo().click();

        // далее проверки окна с таблицей

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));

        $x("//td[text()='Student Name']").parent().shouldHave(text("Yan Bord"));
        $x("//td[text()='Student Email']").parent().shouldHave(text("shinodyan@gmail.com"));
        $x("//td[text()='Gender']").parent().shouldHave(text("Male"));
        $x("//td[text()='Mobile']").parent().shouldHave(text("9032048811"));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text("02 March,1990"));
        $x("//td[text()='Subjects']").parent().shouldHave(text("Arts"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Sports, Music"));
        $x("//td[text()='Picture']").parent().shouldHave(text("fake.jpg"));
        $x("//td[text()='Address']").parent().shouldHave(text("gagarina street"));
        $x("//td[text()='State and City']").parent().shouldHave(text("Haryana Panipat"));







        // 1 способ - грубый

        // $(".table-responsive").shouldHave(text("Yan Bord"), text("shinodyan@gmail.com"), text("Male"), text("9032048811"), text("02 March,1990"), text("Arts"), text("Sports, Music"), text("fake.jpg"), text("gagarina street"), text("Haryana Panipat"));

        // 2 способ - пока не понимаю, что не так

        /* $(".table-responsive").$(byText("Student Name")).shouldHave(text("Yan Bord"));
        $(".table-responsive").$(byText("Student Email")).shouldHave(text("shinodyan@gmail.com"));
        $(".table-responsive").$(byText("Gender")).shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).shouldHave(text("9032048811"));
        $(".table-responsive").$(byText("Date of Birth")).shouldHave(text("02 March,1990"));
        $(".table-responsive").$(byText("Subjects")).shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).shouldHave(text("fake.jpg"));
        $(".table-responsive").$(byText("Address")).shouldHave(text("gagarina street"));
        $(".table-responsive").$(byText("State and City")).shouldHave(text("Haryana Panipat")); */



    }
}



