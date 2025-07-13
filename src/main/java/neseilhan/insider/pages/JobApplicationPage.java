package neseilhan.insider.pages;

import neseilhan.insider.methods.BaseMethods;

public class JobApplicationPage extends BaseMethods {

    public void checkJobPage() {
        switchToSecondTab();
        waitForElementToBeVisible("jobTitleInJobPage");
        checkUrlContains("jobs.lever.co");
        checkDepartmentContains("jobDepartmentInJobPage", "Quality Assurance");
    }
}
