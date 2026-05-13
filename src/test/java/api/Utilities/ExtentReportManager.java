package api.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            // Time stamp for unique report name
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                    .format(new Date());

            String reportName = "Test-Report-" + timeStamp + ".html";

            // Report path
            String path = System.getProperty("user.dir")
                    + "\\reports\\"
                    + reportName;

            // Spark Reporter
            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(path);

            sparkReporter.config().setDocumentTitle("RestAssuredAutomation Report");
            sparkReporter.config().setReportName("ReqRes API report");

            // ExtentReports object
            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            // System Information
            extent.setSystemInfo("Tester", "Soundarya");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("OS", System.getProperty("os.name"));

        }

        return extent;
    }
}
