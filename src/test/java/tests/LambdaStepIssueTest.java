package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepIssueTest {

    private final static String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "margoprist/SelenideSoftAssertionsPageTest";
    private final static int ISSUE_NUMBER = 1;

    @Test

    public void searchForIssue() {
        step("Open the main page", () ->
            open(BASE_URL)
        );
        step("Search for repository", (step) -> {
            step.parameter("repository", REPOSITORY);

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Go to repository", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Go to Issues", () -> {
            $(withText("Issues")).click();
        });
        step("Check issue #1", () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }
}