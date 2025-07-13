package neseilhan.insider.pages;

import neseilhan.insider.methods.BaseMethods;
import org.openqa.selenium.By;

public class HomePage extends BaseMethods {

    private final By insiderLogo = By.xpath("//img[@alt='insider_logo']");
    private final By acceptCookies = By.id("wt-cli-accept-all-btn");
    private final By exploreInsiderTitle = By.id("highlight-en");
    private final By companyDropdownBtn = By.xpath("//a[@id='navbarDropdownMenuLink' and contains(text(),'Company')]");
    private final By careerDropdownBtn = By.xpath("//a[@class='dropdown-sub' and contains(text(),'Careers')]");

    public void checkHomePage() {
//         waitForElementToBeVisible(By.id("insiderLogo")); // olsun mu
//        findElement(insiderLogo);
        click(acceptCookies);
        checkIfElementVisible(insiderLogo, "Insider logo not visible, Homepage not open");
        checkIfElementVisible(exploreInsiderTitle, "Explore Insider Title not visible, Homepage not open");
        checkIfElementVisible(companyDropdownBtn, "Company menu button not visible.");
    }

    public void selectCareerDropDownButton() {
        click(companyDropdownBtn);
        checkIfElementVisible(careerDropdownBtn, "Career dropdown button is not visible.");
        click(careerDropdownBtn);

    }
}
