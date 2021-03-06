package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class BingSearchTest {
    @Test
    void selenideBingSearch() {
        //open bing.com
        Configuration.browser = "firefox";
        open("https://bing.com");

        //find search fields
        $(byName("q")).setValue("Selenide").pressEnter();

        //check that selenide is displayed in result
        $("html").shouldHave(text("ru.selenide.org"));
    }
}
