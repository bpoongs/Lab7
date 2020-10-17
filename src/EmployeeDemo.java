import java.util.List;
import java.util.Scanner;
import com.cg.eis.bean.Employee;
import com.cg.eis.enums.InsuranceScheme;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

public class EmployeeDemo {

	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeServiceImpl();

		Scanner scan = new Scanner(System.in);

		char proceed = 'n';

		do {
			System.out.println("**************************************");
			System.out.println("MENU");
			System.out.println("**************************************");
			System.out.println("1. Add an Employee");
			System.out.println("2. Delete an Employee");
			System.out.println("3. Display employees based on Insurance Scheme");
			System.out.println("4. Exit");
			System.out.println("**************************************");
			System.out.println("Enter an Option:");
			int option = scan.nextInt();

			switch(option) {
			case 1:
				System.out.println("Enter name of the Employee:");
				String name = scan.next();
				System.out.println("Enter salary of the Employee:");
				long salary = scan.nextLong();
				Employee employee = new Employee(name, salary);
				Employee returnedEmp = employeeService.addEmployee(employee);
				System.out.println("Employee added succesfuly!! Employee ID is : " + returnedEmp.getId());
				System.out.println("Do you want to continue ? (y/n)");
				proceed = scan.next().charAt(0);
				break;
			case 2:
				
				break;
			case 3:
				System.out.println("************************");
				System.out.println("INSURANCE SCHEME");
				System.out.println("************************");
				System.out.println("0. No Scheme");
				System.out.println("1. Scheme A");
				System.out.println("2. Scheme B");
				System.out.println("3. Scheme C");
				System.out.println("************************");
				System.out.println("Enter the number:");
				int schemeOption = scan.nextInt();
				List<Employee> schemeEmployees = employeeService.fetchEmployeeByScheme(schemeOption);
				System.out.println(schemeEmployees);
				System.out.println("Do you want to continue ? (y/n)");
				proceed = scan.next().charAt(0);
				break;
			case 4:
				System.exit(0);

			}
		}while(proceed == 'y');
	}
}