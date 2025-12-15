package org.example.business;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.business.model.ProductInfo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class MobilePhonesPage {

    public List<ProductInfo> getAllProducts() {

        $$x("//rz-product-tile")
                .shouldHave(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(20));

        ElementsCollection productTiles = $$x("//rz-product-tile");
        List<ProductInfo> products = new ArrayList<>();

        for (SelenideElement tile : productTiles) {
            try {
                String name = tile.$x(".//a[contains(@class, 'tile-title')]").getText();

                String price = tile.$x(".//div[contains(@class, 'price')]").getText();

                boolean isTopSales = tile.$$x(".//rz-promo-label[contains(@class, 'promo-label_type_popularity')]")
                        .size() > 0;

                products.add(new ProductInfo(name, price, isTopSales));
            } catch (Exception ignored) {

            }
        }

        return products;
    }

    public List<ProductInfo> getTopSalesProducts() {
        return getAllProducts().stream()
                .filter(ProductInfo::isTopSales)
                .toList();
    }
}
