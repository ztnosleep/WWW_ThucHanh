package iuh.fit.app;

import iuh.fit.models.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXMLApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Employee emp1 = (Employee) context.getBean("employee1");
        emp1.showInfo();

        Employee emp2 = (Employee) context.getBean("employee2");
        emp2.showInfo();
    }
}
