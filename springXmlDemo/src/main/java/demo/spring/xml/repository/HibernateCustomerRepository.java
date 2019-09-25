package demo.spring.xml.repository;

import java.util.ArrayList;
import java.util.List;

import demo.spring.xml.model.Customer;

public class HibernateCustomerRepository implements CustomerRepository {

	@Override
	public List<Customer> findAll() {
		Customer customer = new Customer();

		customer.setFirstname("Tom");
		customer.setLastname("Haverford");

		List<Customer> customers = new ArrayList<>();

		customers.add(customer);

		return customers;
	}

}
