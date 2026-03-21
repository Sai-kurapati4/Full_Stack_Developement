package employee.employee_mgmt;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
@Component
public class EmployeeService {
	private final EmployeeRepository repo;
	@Autowired
	public EmployeeService(EmployeeRepository repo) {
		this.repo=repo;
	}
	public void addEmployee(int id,String name,String dept) {
		repo.save(new Employee(id,name,dept));
	}
	public Employee getEmployee(int id) {
		return repo.findById(id);
	}
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	public boolean removeEmployee(int id) {
		return repo.deleteById(id);
	}
}
