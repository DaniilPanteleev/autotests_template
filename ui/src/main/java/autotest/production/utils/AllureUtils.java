package autotest.production.utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.source;

@Log4j
public class AllureUtils {
    public static void takeAndAttachScreenshot(String name) {
        try {
            if (WebDriverRunner.hasWebDriverStarted()) {
                Allure.addAttachment(name, "image/png", new ByteArrayInputStream(((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES)), ".png");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public static void attachScreenshot(String name, InputStream content) {
        try {
            if (WebDriverRunner.hasWebDriverStarted()) {
                Allure.addAttachment(name, "image/png", content, ".png");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public static void takeAndAttachPageSource() {
        try {
            if (WebDriverRunner.hasWebDriverStarted()) {
                Allure.addAttachment("Page source", "text/html", source(), ".html");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    /**
     * Works only with Google Chrome browser
     */
    public static void takeAndAttachBrowserLogs() {
        try {
            if (WebDriverRunner.hasWebDriverStarted()) {
//                if (Config.currentBrowser.getBrowser().equals(BrowserNames.CHROME)) {
                Allure.addAttachment("Browser logs", "text/plain", getWebDriver().manage().logs().get(LogType.BROWSER).getAll().stream()
                        .map(LogEntry::toString).collect(Collectors.joining("\n")));
//                }
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
    }
}
