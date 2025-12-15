package org.example.business.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogMenu {

        private SelenideElement catalogButton = $x("//button[@data-testid='fat_menu_btn']");
        private SelenideElement electronicsCategory = $$("a[data-testid='fat_menu_category_link']")
                        .findBy(Condition.text("Смартфони, ТВ і електроніка"));
        private SelenideElement mobilePhonesLink = $$("a[data-testid='fat_menu_popular_categories_link']")
                        .findBy(Condition.text("Мобільні телефони"));

        public void openMobilePhones() {
                catalogButton.click();
                electronicsCategory.shouldBe(Condition.visible).hover();
                mobilePhonesLink.click();
                Selenide.sleep(3000);
        }
}
