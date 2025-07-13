package neseilhan.insider.pages;

import neseilhan.insider.methods.BaseMethods;
import org.openqa.selenium.By;

public class CareersPage extends BaseMethods {
    private final By teamsSection = By.id("career-find-our-calling");
    private final By locationsTitle = By.xpath("//*[contains(text(),'Our Locations')]");
    private final By locationsSection = By.id("career-our-location");
    private final By lifeAtInsiderTitle = By.xpath("//*[contains(text(),'Life at Insider')]");
    private final By lifeAtInsiderSection = By.cssSelector("section.elementor-element-a8e7b90");
    private final By seeAllJobsBtn = By.cssSelector("div.button-group a.btn-outline-secondary");

    public void checkCareerPage() {
        checkIfElementVisible(teamsSection, "Teams section not visible");

        scrollToElement(locationsTitle);
        checkIfElementVisible(locationsSection, "Location section not visible");

        scrollToElement(lifeAtInsiderTitle);
        checkIfElementVisible(lifeAtInsiderSection, "Life at Insider section not visible");
    }

    public void gotoSearchJobPage() {
        goToUrl("https://useinsider.com/careers/quality-assurance/");
        click(seeAllJobsBtn);
    }
}
