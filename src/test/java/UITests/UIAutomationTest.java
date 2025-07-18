package UITests;

import neseilhan.insider.drivers.BaseDriver;
import neseilhan.insider.pages.CareersPage;
import neseilhan.insider.pages.HomePage;
import neseilhan.insider.pages.JobApplicationPage;
import neseilhan.insider.pages.QAJobsPage;
import org.junit.Test;

public class UIAutomationTest extends BaseDriver {

    @Test
    public void webAutomationTest() {
        HomePage homePage = new HomePage();
        CareersPage careersPage = new CareersPage();
        JobApplicationPage openJobsPage = new JobApplicationPage();
        QAJobsPage qaJobsPage = new QAJobsPage();

        homePage.checkHomePage();
        homePage.selectCareerDropDownButton();

        careersPage.checkCareerPage();
        careersPage.gotoSearchJobPage();

        qaJobsPage.filterJobDetails();
        qaJobsPage.checkPresenceOfTheJobsList();
        qaJobsPage.checkAllJobsDetailContains();
        qaJobsPage.clickViewRoleBtn();

        openJobsPage.checkJobPage();

    }
}
