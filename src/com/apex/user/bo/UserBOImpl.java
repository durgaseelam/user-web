package com.apex.user.bo;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.apex.user.dao.UserDAO;
import com.apex.user.service.UserServiceProxy;
import com.apex.user.vo.User;
//import com.apex.user.service.vo.User;
@Service
public class UserBOImpl implements UserBO {
	@Autowired
	UserDAO userDAO;
	UserServiceProxy proxy =new UserServiceProxy();
	

	public void addUser(User user) throws Exception{
		System.out.println("UserBOImpl:addUser:Start()");		
		userDAO.addUser(user);
		System.out.println("UserBOImpl:addUser:End()");
	}

	public com.apex.user.service.vo.User getUser(int id) throws RemoteException {
		System.out.println("UserBOImpl:getUser:Start()");		
		com.apex.user.service.vo.User user=proxy.getUser(id);
		System.out.println("UserBOImpl:getUser:End()");
		return user;
	}

	public void updateUser(User user) {
		System.out.println("UserBOImpl:updateUser:Start()");		
		userDAO.updateUser(user);
		System.out.println("UserBOImpl:updateUser:End()");

	}

	public void deleteUser(int id) {
		System.out.println("UserBOImpl:deleteUser:Start()");		
		userDAO.deleteUser(id);
		System.out.println("UserBOImpl:deleteUser:End()");
		
	}
	public ArrayList<User> getAllUsers(){
		System.out.println("UserBOImpl:getAllUsers:Start()");		
		ArrayList<User> user=userDAO.getAllUsers();
		System.out.println("UserBOImpl:getAllUsers:End()");
		return user;
	}

}
