package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entity.Customer;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.repository.CustomerRepository;

@SpringBootTest
class ICustomerServiceTest {

	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void testRegisterCustomer() {
		Customer c =new Customer();
		c.setAadhaarNumber(1232434L);
		c.setEmail("Akash@gmail.com");
		c.setFirstName("Akash");
		c.setGender("Male");
		c.setLastName("Sharma");
		c.setMiddleName("Kumar");
		c.setMobileNumber("990034234");
		c.setPassword("1234");
		c.setUserId(203L);
		c.setUserName("Akash123");
		assertEquals(c, customerService.registerCustomer(c));
		customerRepository.delete(c);
	}

	@Test
	void testViewCustomerProfile() throws NoSuchCustomerException {
		Customer c =new Customer();
		c.setAadhaarNumber(1232434L);
		c.setEmail("Akash@gmail.com");
		c.setFirstName("Akash");
		c.setGender("Male");
		c.setLastName("Sharma");
		c.setMiddleName("Kumar");
		c.setMobileNumber("990034234");
		c.setPassword("1234");
		c.setUserId(203L);
		c.setUserName("Akash123");
		customerRepository.save(c);
		assertNotNull(customerService.viewCustomerProfile(203));
		customerRepository.delete(c);
	}


	@Test
	void testSearchCustomerByCustomerId() throws NoSuchCustomerException {
		Customer c =new Customer();
		c.setAadhaarNumber(1232434L);
		c.setEmail("Akash@gmail.com");
		c.setFirstName("Akash");
		c.setGender("Male");
		c.setLastName("Sharma");
		c.setMiddleName("Kumar");
		c.setMobileNumber("990034234");
		c.setPassword("1234");
		c.setUserId(203L);
		c.setUserName("Akash123");
		customerRepository.save(c);
		assertNotNull(customerService.searchCustomerByCustomerId(203L));
		customerRepository.delete(c);
	}

	@Test
	void testSearchCustomerByEmail() throws NoSuchCustomerException {
		Customer c =new Customer();
		c.setAadhaarNumber(1232434L);
		c.setEmail("Akash@gmail.com");
		c.setFirstName("Akash");
		c.setGender("Male");
		c.setLastName("Sharma");
		c.setMiddleName("Kumar");
		c.setMobileNumber("990034234");
		c.setPassword("1234");
		c.setUserId(203L);
		c.setUserName("Akash123");
		customerRepository.save(c);
		assertNotNull(customerService.searchCustomerByEmail(c.getEmail()));
		customerRepository.delete(c);
	}

	@Test
	void testSearchCustomerByAadhaar() throws NoSuchCustomerException {
		Customer c =new Customer();
		c.setAadhaarNumber(1232434L);
		c.setEmail("Akash@gmail.com");
		c.setFirstName("Akash");
		c.setGender("Male");
		c.setLastName("Sharma");
		c.setMiddleName("Kumar");
		c.setMobileNumber("990034234");
		c.setPassword("1234");
		c.setUserId(203L);
		c.setUserName("Akash123");
		customerRepository.save(c);
		assertNotNull(customerService.searchCustomerByAadhaar(c.getAadhaarNumber()));
		customerRepository.delete(c);
	}

	@Test
	void testSearchCustomerByMobile() throws NoSuchCustomerException {
		Customer c =new Customer();
		c.setAadhaarNumber(1232434L);
		c.setEmail("Akash@gmail.com");
		c.setFirstName("Akash");
		c.setGender("Male");
		c.setLastName("Sharma");
		c.setMiddleName("Kumar");
		c.setMobileNumber("990034234");
		c.setPassword("1234");
		c.setUserId(203L);
		c.setUserName("Akash123");
		customerRepository.save(c);
		assertNotNull(customerService.searchCustomerByMobile(c.getMobileNumber()));
		customerRepository.delete(c);
	}

	@Test
	void testSearchCustomerByName() throws NoSuchCustomerException {
		Customer c =new Customer();
		c.setAadhaarNumber(1232434L);
		c.setEmail("Akash@gmail.com");
		c.setFirstName("Akash");
		c.setGender("Male");
		c.setLastName("Sharma");
		c.setMiddleName("Kumar");
		c.setMobileNumber("990034234");
		c.setPassword("1234");
		c.setUserId(203L);
		c.setUserName("Akash123");
		customerRepository.save(c);
		assertNotNull(customerService.searchCustomerByName(c.getFirstName()));
		customerRepository.delete(c);
	}
}
