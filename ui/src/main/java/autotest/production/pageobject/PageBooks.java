package autotest.production.pageobject;

import autotest.production.annotations.Page;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Page("/books")
@Getter
public class PageBooks extends BasePage {

    private ElementsCollection price = Selenide.$$("[class='price actual-price']");
    private ElementsCollection button = Selenide.$$("[value='Add to cart' ]");
    private ElementsCollection buttonCount = Selenide.$$("[class='cart-item-row']");
    private ElementsCollection title = Selenide.$$("[class='product-title']");
    private SelenideElement pages = Selenide.$("[class='pager']");
    private ElementsCollection grid = Selenide.$$("[class='item-box']");


    public void addToCart(int element) {
        button.get(element).click();
    }


    public void orderByZtoA() {
        SelenideElement orderBy = Selenide.$("[id='products-orderby']");
        SelenideElement orderByZtoA = Selenide.$("[value='http://demowebshop.tricentis.com/books?orderby=6']");
        orderBy.click();
        orderByZtoA.click();
    }

    public void pageSizeFour() {
        SelenideElement pageSize = Selenide.$("[id='products-pagesize']");
        SelenideElement selected = Selenide.$("[value='http://demowebshop.tricentis.com/books?pagesize=4']");
        pageSize.click();
        selected.click();
    }

    public void nextPage() {
        SelenideElement nextPage = Selenide.$("[class='next-page']");
        nextPage.click();
    }

}
