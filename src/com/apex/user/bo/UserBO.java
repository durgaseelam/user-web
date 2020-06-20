package com.apex.user.bo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.apex.user.vo.User;

public interface UserBO {
	
	public void addUser(User user) throws Exception;
	public com.apex.user.service.vo.User getUser(int id) throws RemoteException;
	public void updateUser(User user);
	public void deleteUser(int id);
	public ArrayList<User> getAllUsers();

}
