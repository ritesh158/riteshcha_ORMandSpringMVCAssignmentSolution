import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.customermanagement.entity.Customer;
import com.customermanagement.service.CustomerService;
import com.customermanagement.service.CustomerServiceImpl;


public class AppMain {
	public static void main(String[] args) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = con.buildSessionFactory();

		CustomerService customerService = new CustomerServiceImpl(sessionFactory);

		List<Customer> CustomerList = customerService.findAll();
		for (Customer customer : CustomerList) {
			System.out.println(customer.toString());
		}
	

	}
	}
