package qaguru.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Open new page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search for a repository {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Open the repository {repo}")
    public void openRepository(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Go to tab Issue")
    public void openIssueTab() {
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Checking for tabs Issue {num}")
    public void shouldSeeIssueWithNumber(int num) {
        $(withText("#1")).should(Condition.exist);
    }
}
