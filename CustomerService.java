package com.customermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customermanagement.entity.Customer;



@Service
public interface CustomerService {
	
	public List<Customer> findAll();
	
	public List<Customer> searchBy(String FirstName, String LastName);

	public Customer findById(int id);

	public void save(Customer customer);

	public void deleteById(int id);
}
