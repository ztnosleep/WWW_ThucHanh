package iuh.fit.app;

import iuh.fit.models.Address;
import iuh.fit.models.Employee;
import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean
    public Address address() {
        return new Address("Hue", "TT", "Vietnam");
    }

    @Bean
    public Employee employee() {
        return new Employee(4, "Pham Thi D", address());
    }
}
