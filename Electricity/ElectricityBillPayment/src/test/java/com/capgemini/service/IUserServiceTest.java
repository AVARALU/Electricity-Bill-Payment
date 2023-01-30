package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.capgemini.entity.User;
import com.capgemini.repository.UserRepository;

@SpringBootTest
class IUserServiceTest {

	@Autowired
	private IUserService iUserService;

	@Autowired
	private UserRepository repository;

	@Test
	@Order(1)
	void testRegisterUser() {
		User u = new User(245L, "Username", "Password");
		assertEquals(u, iUserService.registerUser(u));
		repository.delete(u);
	}
	
	
	@Test
	@Order(2)
	void testLoginUser() {
		User u = new User(245L, "Username", "Password");
		repository.save(u);
		assertEquals(u, iUserService.loginUser(u));
		repository.delete(u);
	}

	@Test
	@Order(3)
	void testChangePassword() {
		User u = new User(245L, "Username", "Password");
		repository.save(u);
		// password is changed
		User u1 = new User(245L, "Username", "123456");
		assertEquals(u1, iUserService.changePassword(u1));
		repository.delete(u1);
	}

	@Test
	@Order(4)
	void testSearchUserByUsername() {
		User u = new User(245L, "Username", "Password");
		repository.save(u);
		assertEquals(u, iUserService.searchUserByUsername(u.getUserName()));
		repository.delete(u);
	}

	@Test
	@Order(5)
	void testSearchUserByUserId() {
		User u = new User(245L, "Username", "Password");
		repository.save(u);
		assertEquals(u, iUserService.searchUserByUserId(245));
		repository.delete(u);
	}

}
