package iuh.fit.lab04.models;

import lombok.*;
import org.checkerframework.checker.units.qual.A;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private double price;
    private String image;
}
