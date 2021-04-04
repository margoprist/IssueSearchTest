import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.exist;

public class WebSteps {

    @Step("Open the main page")
    public void openMainPage() {

        open("https://github.com");
    }

    @Step("Go to the repository {REPOSITORY}")
    public void goToRepository(String REPOSITORY) {
        $(".header-search-input").click();
        $(".header-search-input").val(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
    }

    @Step("Go to issues tab")
    public void goToIssueTab() {

        $(withText("Issues")).click();
    }

    @Step("Check if issue with number {ISSUE_NUMBER} exists")
    public void checkIssueExists(int ISSUE_NUMBER) {

        $(withText("#" + ISSUE_NUMBER)).should(exist);
    }
}