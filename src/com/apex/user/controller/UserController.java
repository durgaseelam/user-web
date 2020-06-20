package com.apex.user.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.apex.user.bo.UserBO;
import com.apex.user.vo.User;

@Controller
public class UserController {
	@Autowired
	UserBO userBO;

	@RequestMapping(value = "/homepage.do")
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/entryadduser.do")
	public String entryAddUser(@ModelAttribute User user) {
		return "person";
	}

	@RequestMapping(value = "/processadduser.do")
	public String processAddUser(@ModelAttribute User user) {
		try {
			System.out.println("UserController:pocessAddUser():Start()");
			// step1
			System.out.println("The first name : " + user.getFirstName());

			// step2:
			userBO.addUser(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// step3
		System.out.println("UserController:pocessAddUser():End()");
		return "success";

	}

	@RequestMapping(value = "/entrydeleteuser.do")
	public String entryDeleteUser(@ModelAttribute User user) {
		return "delete";
	}

	@RequestMapping(value = "/processdeleteuser.do")
	public String processDeleteUser(@ModelAttribute User user) {
		try {
			System.out.println("UserController:processDeleteUserr():Start()");
			// step1
			System.out.println("Deleting userId : " + user.getUserId());

			// step2:
			userBO.deleteUser(user.getUserId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		// step3
		System.out.println("UserController:processDeleteUser():End()");
		return "deletesuccess";

	}

	@RequestMapping(value = "/entryupdateuser.do")
	public String entryUpdateUser(@ModelAttribute User user) {
		return "update";
	}

	@RequestMapping(value = "/processgetdtlsforupdateuser.do")
	public String processGetDtlsForUpdateUser(@ModelAttribute com.apex.user.service.vo.User user, ModelMap modelMap) {
		try {
			System.out.println("UserController:processUpdateUser():Start()");
			// step1
			System.out.println("Updating user : " + user.getUserId());

			// step2:
			user = userBO.getUser(user.getUserId());
			modelMap.addAttribute(user);
			System.out.println(" First name of user: " + user.getFirstName());

		} catch (Exception e) {
			e.printStackTrace();
		}
		// step3
		System.out.println("UserController:processUpdateUser:End()");

		return "userdtlsforupdate";
	}

	@RequestMapping(value = "/processupdateuser.do")
	public String processUpdateUser(@ModelAttribute User user) {
		try {
			System.out.println("UserController:processUpdateUser():Start()");
			// step1
			System.out.println("Updating LastName : " + user.getLastName());

			// step2:
			userBO.updateUser(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// step3
		System.out.println("UserController:processUpdateUser:End()");
		return "updatesuccess";

	}

	@RequestMapping(value = "/entrygetuser.do")
	public String entryGetUser(@ModelAttribute User user) {
		return "viewdetails";
	}

	@RequestMapping(value = "/processgetuser.do")
	public String processGetUser(@ModelAttribute com.apex.user.service.vo.User user, ModelMap modelMap) {
		try {
			System.out.println("UserController:processGetUser():Start()");
			// step1

			// step2:
			System.out.println("user.getuserid " + user.getUserId());
			user = userBO.getUser(user.getUserId());
			modelMap.addAttribute(user);
			System.out.println("first name from get method " + user.getFirstName());

		} catch (Exception e) {
			e.printStackTrace();
		}
		// step3
		System.out.println("UserController:processGetUser:End()");
		return "success";
	}

	/*
	 * @RequestMapping(value = "/entrygetallusers.do") public String
	 * entryGetAllUsers(@ModelAttribute User user) { return ""; }
	 */

	@RequestMapping(value = "/getallusers.do")
	public String getAllUsers( ModelMap modelMap) {
		try {
			System.out.println("UserController:processGetAllUsers:Start()");
			// step1

			// step2:
			
			ArrayList <User> userList = userBO.getAllUsers();
			modelMap.addAttribute("users",userList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// step3
		System.out.println("UserController:processGetAllUsers:End()");
		return "viewall";

	}

}