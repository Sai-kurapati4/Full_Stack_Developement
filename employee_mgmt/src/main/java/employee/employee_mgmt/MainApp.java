package employee.employee_mgmt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MainApp {
public static void main(String[] args) {
	ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
	EmployeeService service=context.getBean(EmployeeService.class);
	service.addEmployee(101,"SAI","CSE");
	service.addEmployee(102,"Hushh","CSE");
	service.addEmployee(103,"juhh","ECE");
	System.out.println("All employees:");
	service.getAllEmployees().forEach(System.out::println);
	System.out.println("\nFind Employee 102:");
	System.out.println(service.getEmployee(102));
	System.out.println("\n Delete Employee 101:");
	System.out.println("Deleted?"+service.removeEmployee(101));
	System.out.println("\n ALl Employees After Delete:");
	service.getAllEmployees().forEach(System.out::println);
}
}
