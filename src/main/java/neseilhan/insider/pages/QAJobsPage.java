package neseilhan.insider.pages;

import neseilhan.insider.methods.BaseMethods;
import org.openqa.selenium.By;

public class QAJobsPage extends BaseMethods {
    private final By checkSearchPage = By.xpath("//span[@title='Quality Assurance']");
    private final By locationFilterBox = By.cssSelector("#filter-by-location + span");
    private final By selectIstanbulLocation = By.xpath("//li[contains(@id,'Istanbul')]");
    private final By departmentFilterBox = By.id("select2-filter-by-department-container");
    private final By selectQADepartment = By.xpath("//li[contains(@id,'Quality Assurance')]");

    private final By sectionPositionArea = By.id("jobs-list");
//    private final By careerListTitle = By.cssSelector("section#career-position-list h3");

    private final By jobPositionTitles = By.cssSelector("p.position-title");
    private final By jobDepartments = By.cssSelector("span.position-department");
    private final By jobLocations = By.cssSelector("div.position-location");

    private final By viewRoleButton = By.cssSelector("div.position-list div a");


    private final By viewRoleButtons = By.xpath("//a[contains(text(),'View Role')]");

    public void filterJobDetails() {
        findElement(checkSearchPage);
        click(locationFilterBox);
        click(selectIstanbulLocation);
        waitSeconds(1);
        click(departmentFilterBox);
        click(selectQADepartment);
    }

    public void checkPresenceOfTheJobsList() {
        scrollToElement(sectionPositionArea);
        waitForElementToBeVisible(sectionPositionArea);
        checkIfElementVisible(sectionPositionArea, "Browse Open Positions section not visible");
//        checkIfElementVisible(careerListTitle, "Browse Open Positions title not visible");
    }

    public void checkAllJobsDetailContains() {

        waitForElementToBeVisible(jobPositionTitles);

        assertTextContainsInList(jobPositionTitles, "Quality Assurance");
        saveValueLastJob(jobPositionTitles, "jobsPositionTitles");

        assertTextContainsInList(jobDepartments, "Quality Assurance");
        saveValueLastJob(jobDepartments, "jobsPositionDepartment");

        assertTextContainsInList(jobLocations, "Istanbul, Turkey");
        saveValueLastJob(jobLocations,"jobsPositionLocation");

        waitSeconds(1);
    }

    public void clickViewRoleBtn() {
        hoverOverLastElement(viewRoleButtons);
        click(viewRoleButtons);
        waitSeconds(1);

    }
}
