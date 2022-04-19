package autotest.production;

import autotest.base.BooksTestBase;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j
@Epic("Book page debugging")
public class BooksTest extends BooksTestBase {


    @Test
    @DisplayName("Checking the price of books less than 100")
    @Story("The price ")
    void checkPrices() {

        softAssert(s -> {
            step(" 1. price comparison", () -> {
                assertThat(site.getBooks().getPrice()).allMatch(t -> Double.parseDouble(t.text()) < 100.00);
            });
            step("2. there is an add to cart button", () -> {
                assertThat(site.getBooks().getButton().size()).isEqualTo(3);
            });
        });

    }

    @Test
    @DisplayName("Check adding books to cart")
    @Story("Books to cart")
    void addBooks() {

        softAssert(s -> {
            step(" 1. adding one book", () -> {
                site.getBooks().addToCart(1);
                Thread.sleep(1000);

                assertThat(site.getBooks().getCartQty().text()).contains("1");
            });
            step(" 2. adding second book", () -> {
                site.getBooks().addToCart(2);
                Thread.sleep(1000);
                assertThat(site.getBooks().getCartQty().text()).contains("2");
            });
        });


    }

    @Test
    @DisplayName("Check sorting from z to a")
    @Story("Sorting")
    void sortedByName() {

        softAssert(s -> {
            step(" 1. Sorting by Z to A", () -> {
                site.getBooks().orderByZtoA();

                assertThat(site.getBooks().getTitle().texts()).isSortedAccordingTo(Collections.reverseOrder());
            });
        });

    }

    @Test
    @DisplayName("Check book separation and pagination appearance")
    @Story("Separation and pagination")
    void representation() {

        softAssert(s -> {
            step(" 1. division into 4 objects per page", () -> {
                site.getBooks().pageSizeFour();

                site.getBooks().getPages().shouldBe(Condition.visible);
            });
            step(" 3. checking elements on the page", () -> {
                assertThat(site.getBooks().getGrid().size()).isEqualTo(4);
            });
            step(" 4. move to the next page", () -> {
                site.getBooks().nextPage();

                assertThat(site.getBooks().getGrid().size()).isEqualTo(2);
            });
        });
    }

    @Test
    @DisplayName("Example of usage soft assertions")
    @Story("Use soft assertions")
    void testSoftAssertion() {

        softAssert(s -> {
            step(" 1. Assertion 1", () -> {
                s.assertThat(1).isEqualTo(2);
            });
            step(" 2. Assertion 2", () -> {
                s.assertThat(2).isEqualTo(2);
            });
            step(" 3. Assertion 3", () -> {
                s.assertThat(3).isEqualTo(3);
            });
        });
    }


}
