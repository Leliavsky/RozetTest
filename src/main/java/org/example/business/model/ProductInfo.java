package org.example.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo {
    private String name;
    private String price;
    private boolean isTopSales;

    @Override
    public String toString() {
        return String.format("Product: %s | Price: %s%s",
                name,
                price,
                isTopSales ? " | ⭐ ТОП ПРОДАЖІВ" : "");
    }
}
