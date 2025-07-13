package neseilhan.insider.pages;

import neseilhan.insider.methods.BaseMethods;
import org.openqa.selenium.By;

public class CareersPage extends BaseMethods {
    public void checkCareerPage() {
        scrollToElementToBeVisible("loadMoreBtn");
        javascriptclicker("loadMoreBtn");
        waitBySecond(2);
        checkForElement("teamsSection", "teams section not visible");
        scrollToElementToBeVisible("locationsTitle");
        checkForElement("locationsSection", "location section not visible");
        scrollToElementToBeVisible("lifeatInsiderTitle");
        checkForElement("lifeatInsiderSection", "life at Insider section not visible");
    }

    public void gotoSearchJobPage() {
        gotoURL("https://useinsider.com/careers/quality-assurance/");
        clickElement("seeAllJobsBtn");
    }
}
