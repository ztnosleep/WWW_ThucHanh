package iuh.fit.app;

import iuh.fit.models.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAnnotationApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainAnnotationApp.class);

        Employee emp = context.getBean(Employee.class);
        emp.showInfo();
    }
}
