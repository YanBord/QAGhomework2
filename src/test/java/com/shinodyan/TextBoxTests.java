package com.shinodyan;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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

        $(".table-responsive").shouldHave(text("Yan Bord"));

        //$(".table-responsive").$(byText("Student Name")).shouldHave(text("Yan Bord")); вариант 2

        $(".table-responsive").$(byText("Student Email")).shouldHave(text("shinodyan@gmail.com"));
        $(".table-responsive").$(byText("Gender")).shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).shouldHave(text("9032048811"));
        $(".table-responsive").$(byText("Date of Birth")).shouldHave(text("02 March,1990"));
        $(".table-responsive").$(byText("Subjects")).shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).shouldHave(text("fake.jpg"));
        $(".table-responsive").$(byText("Address")).shouldHave(text("gagarina street"));
        $(".table-responsive").$(byText("State and City")).shouldHave(text("Haryana Panipat"));



    }
}



