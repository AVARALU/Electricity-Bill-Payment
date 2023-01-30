package com.capgemini.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Optional<Customer> findByEmail(String email);

	public Optional<Customer> findByAadhaarNumber(Long aadhaarNumber);

	public Optional<Customer> findByMobileNumber(String mobileNumber);

	public List<Customer> findByFirstName(String firstName);

}
