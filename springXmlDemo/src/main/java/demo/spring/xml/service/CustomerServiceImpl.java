package demo.spring.xml.service;

import java.util.List;

import demo.spring.xml.model.Customer;
import demo.spring.xml.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("constructor injection");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

//	public void setFoo(CustomerRepository customerRepository) {
//		System.out.println("using setter injection");
//		this.customerRepository = customerRepository;
//	}

}
