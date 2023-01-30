package com.capgemini.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entity.Customer;
import com.capgemini.exception.DuplicateCustomerException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer registerCustomer(Customer customer) throws DuplicateCustomerException {
		return customerRepository.save(customer);
	}

	@Override
	public Customer viewCustomerProfile(int customerId) throws NoSuchCustomerException {
		return searchCustomerByCustomerId((long) customerId);
	}

	@Override
	public Customer editCustomerProfile(int customerId, Customer customer) throws NoSuchCustomerException {
		return customerRepository.save(customer);
	}

	@Override
	public Customer searchCustomerByCustomerId(Long customerId) throws NoSuchCustomerException {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public Customer searchCustomerByEmail(String email) throws NoSuchCustomerException {
		return customerRepository.findByEmail(email)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public Customer searchCustomerByAadhaar(Long aadhaarNumber) throws NoSuchCustomerException {
		return customerRepository.findByAadhaarNumber(aadhaarNumber)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public Customer searchCustomerByMobile(String mobile) throws NoSuchCustomerException {
		return customerRepository.findByMobileNumber(mobile)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public List<Customer> searchCustomerByName(String firstName) throws NoSuchCustomerException {
		try {
			List<Customer> byName = customerRepository.findByFirstName(firstName);
			return byName;
		} catch (Exception e) {
			throw new NoSuchCustomerException("Customer with name:" + firstName + "not present");
		}

	}

}
