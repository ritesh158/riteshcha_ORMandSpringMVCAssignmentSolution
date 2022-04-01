package com.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customermanagement.entity.Customer;
import com.customermanagement.service.CustomerService;

@Controller
@RequestMapping("/customer")

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	// add mapping for "/list"

	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		System.out.println("request recieved");
		// get Books from db
		List<Customer> theCustomer = customerService.findAll();

		// add to the spring model
		theModel.addAttribute("Customer", theCustomer);

		return "list-Customer";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("Customer", theCustomer);

		return "Customer-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the Book from the service
		Customer theCustomer = customerService.findById(theId);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomer);

		// send over to our form
		return "Customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		System.out.println(id);
		Customer theCustomer;
		if (id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(firstName);

			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);
		} else
			theCustomer = new Customer(firstName, lastName, email);
		// save the Book
		customerService.save(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customer/list";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		// delete the Book
		customerService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/customer/list";

	}

}
