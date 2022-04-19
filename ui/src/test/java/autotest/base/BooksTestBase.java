package autotest.base;

import autotest.production.pageobject.BasePage;
import autotest.production.pageobject.PageBooks;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

@Log4j
public abstract class BooksTestBase extends TestBase {
        String urlDemoWebShop = "http://demowebshop.tricentis.com/";
    BasePage generalPage = new PageBooks();

    @BeforeEach
    void precondition(){
        log.info("Open URL: " + urlDemoWebShop);
        open(urlDemoWebShop);
        generalPage.goToBooks();

    }



}
