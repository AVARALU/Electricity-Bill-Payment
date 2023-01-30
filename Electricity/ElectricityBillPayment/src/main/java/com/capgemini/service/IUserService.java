package com.capgemini.service;
import com.capgemini.entity.User;
import com.capgemini.exception.DuplicateUserException;
import com.capgemini.exception.InvalidLoginCredentialException;
import com.capgemini.exception.NoSuchUserException;

public interface IUserService {

	
	public User registerUser(User user) throws DuplicateUserException;
	public User loginUser(User user) throws InvalidLoginCredentialException;
	public User changePassword(User user);
	public String forgotPassword(String username) throws Exception;

	public User searchUserByUsername(String username)throws NoSuchUserException;
	public User searchUserByUserId(int userId)throws NoSuchUserException;
}
