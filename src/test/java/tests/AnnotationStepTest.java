package tests;

import org.junit.jupiter.api.Test;
import steps.WebSteps;

public class AnnotationStepTest {

    private final static String REPOSITORY = "margoprist/SelenideSoftAssertionsPageTest";
    private final static int ISSUE_NUMBER = 1;

    private WebSteps steps = new WebSteps();

    @Test
    public void testSearch() {
        steps.openMainPage();
        steps.goToRepository(REPOSITORY);
        steps.goToIssueTab();
        steps.checkIssueExists(ISSUE_NUMBER);
    }

}