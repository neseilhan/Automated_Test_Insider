package neseilhan.insider.pages;

import neseilhan.insider.methods.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class OpenJobsPage extends BaseMethods {

    private final By jobTitleInJobPage = By.cssSelector("div.posting-headline h2");
    private final By jobLocationInJobPage = By.cssSelector("div.posting-headline div.posting-categories div.location");
    private final By jobDepartmentInJobPage = By.cssSelector("div.posting-headline div.posting-categories div.department");


    public void checkJobPage() {
        switchToNewTab();
        findElement(jobTitleInJobPage);
        isSavedValueEqualExpectedValue(jobTitleInJobPage, "jobsPositionTitles");
        isSavedValueEqualExpectedValue(jobDepartmentInJobPage, "jobsPositionDepartment");
        isSavedValueEqualExpectedValue(jobLocationInJobPage, "jobsPositionLocation");
    }

//    public void checkJobPage() {
//        switchToNewTab();
//        String currentUrl = getCurrentUrl();
//        Assert.assertTrue("Not redirected to Lever application page", currentUrl.contains("jobs.lever.co"));
//        waitForElementToBeVisible(jobTitleInJobPage);
//        checkIfElementVisible(jobTitleInJobPage, "Job title not visible");
//        compareWithSavedElement(jobTitleInJobPage, "jobsPositionTitles");
//
//        compareWithSavedElement(jobDepartmentInJobPage, "jobsPositionDepartment");
//
//        compareWithSavedElement(jobLocationInJobPage, "jobsPositionLocation");
//        String departmentText = findElement(jobDepartmentInJobPage).getText().replace(" /", "").trim();
//        Assert.assertTrue("Department is not Quality Assurance", departmentText.contains("Quality Assurance"));
//    }

}
