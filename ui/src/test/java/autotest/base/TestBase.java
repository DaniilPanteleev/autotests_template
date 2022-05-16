package autotest.base;

import autotest.production.asserts.CustomSoftAssertions;
import autotest.production.interfaces.SoftAssert;
import autotest.production.interfaces.Step;
import autotest.production.pageobject.Site;
import autotest.production.utils.AllureUtils;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.Iterables;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

import static autotest.production.utils.AllureUtils.takeAndAttachBrowserLogs;
import static autotest.production.utils.AllureUtils.takeAndAttachPageSource;


public abstract class TestBase {

    protected Site site = new Site();
    protected ThreadLocal<CustomSoftAssertions> softAssertionsTL = ThreadLocal.withInitial(() -> null);

    private Consumer<String> attachmentsTask = screenName -> {
        AllureUtils.takeAndAttachScreenshot(screenName);
        takeAndAttachBrowserLogs();
        takeAndAttachPageSource();
    };

    private Consumer<String> errHandleSupplier = (stepId) -> {
        Allure.getLifecycle().updateStep(stepId, s -> s.setStatus(Status.FAILED));
        attachmentsTask.accept("Actual");
        Allure.getLifecycle().stopStep(stepId);
    };

    @SneakyThrows
    protected void step(String stepName, Step stepsToExecute) {
        String stepId = UUID.randomUUID().toString();

        Allure.getLifecycle().startStep(stepId, new StepResult().setName(stepName).setStatus(Status.PASSED));
        try {
            stepsToExecute.doStep();
        } catch (Throwable e) {
            errHandleSupplier.accept(stepId);
            throw new AssertionError(e);
        }
        if (Optional.ofNullable(softAssertionsTL.get()).isPresent()) {
            if (softAssertionsTL.get().hasNewErrors()) {
                errHandleSupplier.accept(stepId);
            } else {
                Allure.getLifecycle().stopStep(stepId);
            }
        } else {
            Allure.getLifecycle().stopStep(stepId);
        }

    }

    @SneakyThrows
    @BeforeEach
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "98");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", false
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterEach
    public void tearDown(){
        WebDriverRunner.getWebDriver().quit();
    }

    protected void softAssert(SoftAssert softAssert) {
        softAssertionsTL.set(new CustomSoftAssertions());
        try {
            softAssert.doSoftAssert(softAssertionsTL.get());
        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
            errHandleSupplier.accept(Iterables.getLast(softAssertionsTL.get().getStepSet()));
        }
        softAssertionsTL.get().assertAll();
        softAssertionsTL.set(null);
    }

}
