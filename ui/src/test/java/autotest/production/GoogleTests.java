package autotest.production;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;


public class GoogleTests extends GoogleTestBase{


    @Test
    void checkGoogleHeader(){
        String title = WebDriverRunner.getWebDriver().getTitle();
        assertThat(title)
                .isEqualTo("Google");


    }
    @Test
    void checkGoogleRequest(){
        SelenideElement test2 = $("[title = 'Поиск']");
        test2.sendKeys("вк");
        test2.sendKeys(Keys.ENTER);
        $("#result-stats").shouldHave(visible);
    }
}
