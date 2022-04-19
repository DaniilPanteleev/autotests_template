package autotest.production.asserts;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import lombok.Getter;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.error.AssertionErrorCreator;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class CustomSoftAssertions extends SoftAssertions {

    private final AssertionErrorCreator assertionErrorCreator = new AssertionErrorCreator();

    private HashSet<String> stepSet = new HashSet<>();

    public AtomicInteger errorsCounter = new AtomicInteger(0);

    public SelenideElementAssert assertThat(SelenideElement actual) {
        stepSet.add(Allure.getLifecycle().getCurrentTestCaseOrStep().get());
        return proxy(SelenideElementAssert.class, SelenideElement.class, actual);
    }

    public Boolean hasNewErrors() {
        if (assertionErrorsCollected().size() == errorsCounter.get()) {
            return false;
        }
        if (assertionErrorsCollected().size() > errorsCounter.get()) {
            errorsCounter.set(assertionErrorsCollected().size());
            return true;
        }
        return false;
    }

}
