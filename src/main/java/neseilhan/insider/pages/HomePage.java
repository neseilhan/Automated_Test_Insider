package neseilhan.insider.pages;

import neseilhan.insider.methods.BaseMethods;
import org.openqa.selenium.By;

public class HomePage extends BaseMethods {

    public void checkHomePage() {
//        waitForElementToBeVisible("insider_logo");
        clickElement("AcceptCookies");
//        checkForElement("insider_logo", "insider logo not visible, Homepage not open");
        checkForElement("exploreInsiderTitle", "explore Insider Title not visible, Homepage not open");
        checkForElement("companyDropdownBtn", "company menu button not visible.");
    }

    public void selectCareerDropDownButton() {
        clickElement("companyDropdownBtn");
        checkForElement("careerDropdownBtn", "Carreer dropdown button not visible.");
        clickElement("careerDropdownBtn");

    }

}
