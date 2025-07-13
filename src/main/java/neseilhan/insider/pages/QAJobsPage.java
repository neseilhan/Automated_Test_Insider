package neseilhan.insider.pages;

import neseilhan.insider.methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class QAJobsPage extends BaseMethods {

    public void filterJobDetails() {
        waitForElementToBeVisible("checkSearchPageisOpen");
        clickElement("locationFilterBox");
        clickElement("selectIstanbulLocation");
        waitBySecond(1);
        clickElement("departmentFilterBox");
        clickElement("selectQualityAssuranceDepartment");

    }

    public void checkPresenceOfTheJobsList() {
        scrollToElementToBeVisible("sectionOfThePositionArea");
        checkForElement("sectionOfThePositionArea", "Open Positions section not visible");
        checkForElement("sectionCarrerListTitle", "Open Positions section not visible");
    }

    public void checkAllJobsDetailContains() {
        waitForElementToBeVisible("jobsPositionTitles");
        waitBySecond(3); //beklenmedigi zaman sayfa yavas yuklenebiliyor ve "position title bulunmadı hatası geliyor.
        // (Screenshot klasöründe hata alındıgı zamanki ss mevcut.)
        try {
            checkIsTextContainsList("jobsPositionTitles", "Quality Assurance."); //hata almak için sonuna nokta ekledim ve screenshotlarda görebildim.
            saveValueLastJob("jobsPositionTitles");
        } catch (AssertionError e) {
            try {
                WebElement element = findElement("jobsPositionTitles");
                MakeBorder(element);
                TakeScreenshot("JobPositionTitles_Error");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            throw e;
        }
    }


    public void clickViewRoleBtn() {
        hoverOverElementWithSelectedSize("viewRoleButton");
//        scrollToElementToBeVisible("viewRoleButton");
//        clickElement("viewRoleButton");
        javascriptclicker("viewRoleButton");  //Sadece javascript degisken ismi ile tıklama da saglanabilir.
    }
}
