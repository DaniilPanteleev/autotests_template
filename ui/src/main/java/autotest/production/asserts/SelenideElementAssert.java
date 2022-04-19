package autotest.production.asserts;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.*;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Allure;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Condition;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.WebDriverRunner.driver;
import static java.lang.String.format;

public class SelenideElementAssert extends AbstractAssert<SelenideElementAssert, SelenideElement> {

    public SelenideElementAssert(SelenideElement element) {
        super(element, SelenideElementAssert.class);
        describedAs(Allure.getLifecycle().getCurrentTestCaseOrStep().get());
    }

    public static SelenideElementAssert assertThat(SelenideElement selenideElement) {
        return new SelenideElementAssert(selenideElement);
    }

    public SelenideElementAssert isVisible() {
        is(new Conditions().visible());
        return this;
    }

    public SelenideElementAssert isExist() {
        is(new Conditions().exist(false));
        return this;
    }

    public SelenideElementAssert isNotVisible() {
        isNot(new Conditions().visible());
        return this;
    }

    public SelenideElementAssert isNotExist() {
        try {
            SelenideElementAssert.this.actual.getText();
            isNot(new Conditions().exist(true));
        } catch (ElementNotFound | NoSuchElementException e) {
        }
        return this;
    }

    /**
     * Check web element attribute value = "" and element has text ""
     *
     * @return
     */
    public SelenideElementAssert isEmpty() {
        is(new Conditions().empty());
        return this;
    }

    public SelenideElementAssert isNotEmpty() {
        isNot(new Conditions().empty());
        return this;
    }

    public SelenideElementAssert hasCssValue(String property, String value) {
        has(new Conditions().cssValue(property, value));
        return this;
    }

    public SelenideElementAssert hasNoCssValue(String property, String value) {
        isNot(new Conditions().cssValue(property, value));
        return this;
    }

    public SelenideElementAssert hasText(String text) {
        has(new Conditions().text(text));
        return this;
    }

    public SelenideElementAssert hasEmptyText() {
        has(new Conditions().exactText(""));
        return this;
    }

    public SelenideElementAssert matchText(String text) {
        has(new Conditions().matchText(text));
        return this;
    }

    public SelenideElementAssert hasNotText(String text) {
        doesNotHave(new Conditions().text(text));
        return this;
    }

    public SelenideElementAssert hasAttributeMatching(String attribute, String attributeRegex) {
        has(new Conditions().attributeMatching(attribute, attributeRegex));
        return this;
    }

    public SelenideElementAssert hasNotAttributeMatching(String attribute, String attributeRegex) {
        isNot(new Conditions().attributeMatching(attribute, attributeRegex));
        return this;
    }

    private class Conditions {

        private Condition createCondition(com.codeborne.selenide.Condition condition, SelenideElement element, String message) {
            return new Condition<>(c -> condition.apply(driver(), element), message == null ? condition.getName() : message);
        }

        public Condition visible() {
            return createCondition(new Visible(), SelenideElementAssert.this.actual, "visible");
        }

        public Condition exist(boolean isNegate) {
            return createCondition(isNegate ? new Exist().negate() : new Exist(), SelenideElementAssert.this.actual, "exist");
        }

        public Condition empty() {
            return createCondition(com.codeborne.selenide.Condition.and("empty", new ExactText(""), new AttributeWithValue("value", "")),
                    SelenideElementAssert.this.actual, "emptyText");
        }

        public Condition text(String text) {
            return createCondition(new Text(text), SelenideElementAssert.this.actual, format("text: '%s'", text));
        }

        public Condition exactText(String text) {
            return createCondition(new ExactText(text), SelenideElementAssert.this.actual, format("exact text: '%s'", text));
        }

        public Condition matchText(String regex) {
            return createCondition(new MatchText(regex), SelenideElementAssert.this.actual, format("match regex: '%s'", regex));
        }

        public Condition attributeMatching(String attribute, String attributeRegex) {
            return createCondition(new MatchAttributeWithValue(attribute, attributeRegex), SelenideElementAssert.this.actual,
                    format("attribute: '%s' matching regex: '%s' but actual is '%s'", attribute, attributeRegex,
                            SelenideElementAssert.this.actual.getAttribute("href")));
        }

        public Condition cssValue(String property, String value) {
            return createCondition(new CssValue(property, value), SelenideElementAssert.this.actual,
                    format("css property: '%s' has value: '%s' but actual is '%s'", property, value,
                            SelenideElementAssert.this.actual.getCssValue(property)));
        }

    }

}


