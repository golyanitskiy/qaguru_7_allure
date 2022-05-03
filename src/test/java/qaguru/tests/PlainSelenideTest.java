package qaguru.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class PlainSelenideTest {
    @BeforeAll
    static void setUp() {
        Configuration.headless = true;
    }

    @AfterAll
    static void tearDown() {
        closeWebDriver();
    }

    @Test
    public void testIssueSearch() {
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("golyanitskiy/qaguru_6_junit");
        $(".header-search-input").submit();

        $(By.linkText("golyanitskiy/qaguru_6_junit")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("#1")).should(Condition.exist);
    }
}
