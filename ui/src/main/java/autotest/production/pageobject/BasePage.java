package autotest.production.pageobject;

import autotest.production.annotations.Page;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;

@Getter
public abstract class BasePage {
    private SelenideElement cartQty = Selenide.$(".cart-qty");

    public  void goToBooks() {
        SelenideElement books = Selenide.$("[href='/books']");
        books.click();
    }
    public void goToCart() {
        SelenideElement gotToCart = Selenide.$("[class=cart-label]");
        gotToCart.click();
    }
    public void open() {
        String value = this.getClass().getAnnotation(Page.class).value();
        Selenide.open("http://demowebshop.tricentis.com" + value );
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


}
