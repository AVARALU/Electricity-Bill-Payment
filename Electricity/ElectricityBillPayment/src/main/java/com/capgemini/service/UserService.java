package com.capgemini.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.User;
import com.capgemini.exception.DuplicateUserException;
import com.capgemini.exception.InvalidLoginCredentialException;
import com.capgemini.exception.NoSuchUserException;
import com.capgemini.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) throws DuplicateUserException {
		Optional<User> opt = userRepository.getUserByUserName(user.getUserName());
		if (opt.isPresent()) {
			throw new DuplicateUserException("User Already Exists!");
		} else {
			System.out.println("inside the register");
			return userRepository.save(user);
		}
	}

	@Override
	public User loginUser(User user) throws InvalidLoginCredentialException {

		
		return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword())
				.orElseThrow(() -> new InvalidLoginCredentialException("Invalid Credentials"));

	}

	@Override
	public User changePassword(User user) {
		Optional<User> opt = userRepository.findByUserName(user.getUserName());
		User existingUser = null;
		if (opt.isPresent()) {
			existingUser = opt.get();
			existingUser.setPassword(user.getPassword());
			userRepository.save(existingUser);
		} else {
			throw new NoSuchUserException("No User Exists!");
		}
		return existingUser;
	}

	@Override
	public User searchUserByUsername(String username) throws NoSuchUserException {
		
		return userRepository.findByUserName(username).orElseThrow(() -> new NoSuchUserException("No User Exists!"));
	}

	@Override
	public User searchUserByUserId(int userId) throws NoSuchUserException {
		return userRepository.findById((long) userId).orElseThrow(() -> new NoSuchUserException("No User Exists!"));
	}

	@Override
	public String forgotPassword(String username) throws Exception {
		User u = userRepository.findByUserName(username).orElseThrow(() -> new Exception("No User found"));
		return u.getPassword();
	}


}
