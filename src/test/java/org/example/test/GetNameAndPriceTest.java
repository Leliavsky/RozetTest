package org.example.test;

import org.example.business.MobilePhonesPage;
import org.example.business.components.CatalogMenu;
import org.example.business.model.ProductInfo;
import org.example.core.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

public class GetNameAndPriceTest extends BaseTest {

    @Test
    public void getMobilePhonesDataTest() {
        CatalogMenu catalogMenu = new CatalogMenu();
        MobilePhonesPage mobilePhonesPage = new MobilePhonesPage();

        catalogMenu.openMobilePhones();

        List<ProductInfo> allProducts = mobilePhonesPage.getAllProducts();
        List<ProductInfo> topSalesProducts = mobilePhonesPage.getTopSalesProducts();

        printProducts(allProducts, topSalesProducts);
    }

    private void printProducts(List<ProductInfo> allProducts, List<ProductInfo> topSales) {
        System.out.println("\n=== ALL MOBILE PHONES (" + allProducts.size() + ") ===");
        for (int i = 0; i < allProducts.size(); i++) {
            System.out.println((i + 1) + ". " + allProducts.get(i));
        }

        System.out.println("\n=== TOP SALES (" + topSales.size() + ") ===");
        for (int i = 0; i < topSales.size(); i++) {
            System.out.println((i + 1) + ". " + topSales.get(i));
        }
    }
}
