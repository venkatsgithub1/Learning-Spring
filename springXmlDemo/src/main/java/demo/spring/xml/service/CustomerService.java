package demo.spring.xml.service;

import java.util.List;

import demo.spring.xml.model.Customer;

public interface CustomerService {
	List<Customer> findAll();
}
