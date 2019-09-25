package demo.spring.xml.repository;

import java.util.List;

import demo.spring.xml.model.Customer;

public interface CustomerRepository {
	List<Customer> findAll();
}
