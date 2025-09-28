package iuh.fit.models;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component()
public class Employee {
    private int id;
    private String name;
    @Autowired
    private Address address;
    public void showInfo() {
        System.out.println("Employee: " + id + " - " + name);
        System.out.println("Address: " + address.getCity());
    }
}
