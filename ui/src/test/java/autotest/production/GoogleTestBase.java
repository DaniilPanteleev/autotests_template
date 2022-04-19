package autotest.production;

import autotest.base.TestBase;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
@Log4j
public class GoogleTestBase extends TestBase {

    String urlGoogle = "https://www.google.ru/";

    @BeforeEach
    void precondition(){
        log.info("Open URL: " + urlGoogle);
        open(urlGoogle);
        int i = 0;
    }

}
