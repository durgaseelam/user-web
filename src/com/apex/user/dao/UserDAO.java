package com.apex.user.dao;

import java.util.ArrayList;

import com.apex.user.vo.User;

public interface UserDAO {
	

	public void addUser(User user) throws Exception;
	public User getUser(int id);
	public void updateUser(User user);
	public void deleteUser(int id);
	public ArrayList<User> getAllUsers();
		


}
