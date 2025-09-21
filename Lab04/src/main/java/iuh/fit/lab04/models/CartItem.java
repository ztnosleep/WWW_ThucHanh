package iuh.fit.lab04.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItem {
    private Product product;
    private int quantity;
    public double getTotal() { return quantity * product.getPrice();}
}
