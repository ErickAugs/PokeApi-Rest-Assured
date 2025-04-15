package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static void createInstance() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-report.html");
        spark.config().setDocumentTitle("Poke Api Rest-Assured");
        spark.config().setReportName("PokeAPI Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
}
