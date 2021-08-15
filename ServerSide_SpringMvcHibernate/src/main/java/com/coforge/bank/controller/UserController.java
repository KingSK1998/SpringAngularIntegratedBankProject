package com.coforge.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.bank.model.BankEmployee;
import com.coforge.bank.service.IBankEmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class UserController {

	@Autowired
	private IBankEmployeeService employeeService;

	private User loggedUser;

	@PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUser(@RequestBody User user) {
		System.out.println("User: " + user);
		User found = new User();
		BankEmployee employee = null;

		if (user.userEmail != null) {
			employee = employeeService.getBankEmployeeByEmail(user.userEmail);
		} else if (user.userId != null) {
			employee = employeeService.getBankEmployeeById(user.userId);
		} else
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);

		found.userId = employee.getEmployeeId();
		found.userEmail = employee.getEmployeeEmail();
		found.userPassword = "";
		found.userRole = employee.getEmployeeRole();

		loggedUser = found;
		return new ResponseEntity<User>(found, HttpStatus.OK);
	}

	@GetMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> setUser() {
		return new ResponseEntity<User>(loggedUser, HttpStatus.OK);
	}

}

class User {
	public String userId;
	public String userEmail;
	public String userPassword;
	public String userRole;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userRole="
				+ userRole + "]";
	}
}
