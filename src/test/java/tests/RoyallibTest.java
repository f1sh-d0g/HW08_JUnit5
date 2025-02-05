package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RoyallibTest extends TestBase {
    @CsvSource(value = {
            "Детективы и Триллеры",
            "Приключения"
    })
    @ParameterizedTest(name = "Проверка наличия раздела со списком книг при переходе к жанру \"{0}\"")
    void checkListOfBooksByGenreTest(String genre) {
        open("https://royallib.com/");
        $(".menu").$(byText(genre)).click();
        $(".content").shouldHave(text(genre + " на \"А\""));

    }
}
