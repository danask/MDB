package com.mis.service;

import java.util.List;

import com.mis.model.User;

public interface UserService {
	
	public void addUser(User user);

	public List<User> getAllUsers();

	public void deleteUser(Integer userId);

	public User getUser(int userid);

	public User getUserByEmailPwd(String email, String pwd);	
	
	public User updateUser(User user);
}
