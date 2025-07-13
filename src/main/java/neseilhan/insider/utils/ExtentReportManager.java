package neseilhan.insider.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class ExtentReportManager {

    private static ExtentReports extent;

//    public static ExtentReports getInstance() {
//        if (extent == null) {
//            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
//            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
//            htmlReporter.config().setDocumentTitle("Insider Test Raporu");
//            htmlReporter.config().setReportName("UI Otomasyon Test Raporu");
//            htmlReporter.config().setTheme(Theme.STANDARD);
//
//            extent = new ExtentReports();
//            extent.attachReporter(htmlReporter);
//            extent.setSystemInfo("Test Uzmanı", "Neşe İlhan");
//            extent.setSystemInfo("Proje", "Insider Kariyer Sayfası");
//        }
//        return extent;
//    }
//
//    public static ExtentTest createTest(String name) {
//        return getInstance().createTest(name);
//    }
}
