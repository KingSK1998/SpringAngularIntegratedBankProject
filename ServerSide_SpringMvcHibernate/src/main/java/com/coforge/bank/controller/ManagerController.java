package com.coforge.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.bank.model.BankEmployee;
import com.coforge.bank.model.Loan;
import com.coforge.bank.service.IAccountService;
import com.coforge.bank.service.IBankEmployeeService;
import com.coforge.bank.service.IBranchService;
import com.coforge.bank.service.ILoanService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private IBankEmployeeService employeeService;

	@Autowired
	private ILoanService loanService;

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IBranchService branchService;

	// Add Employee
	@PostMapping(path = "/employee/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addEmployee(@RequestBody BankEmployee employee) {
		employee.setEmployeeId(employee.getAddressProofIdNo());
		System.out.println("Employee JSON :: " + employee);

		employee.setEmployeeId(employee.getAddressProofIdNo());
		employee.setBranch(branchService.getBranchById(employee.getBranch().getBranchId()));
		employeeService.addBankEmployee(employee);

		return new ResponseEntity<BankEmployee>(employee, HttpStatus.CREATED);
	}

	// Get All Banks
	@GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BankEmployee>> employeeList() {
		List<BankEmployee> employees = employeeService.getBankEmployee();
		return new ResponseEntity<List<BankEmployee>>(employees, HttpStatus.OK);
	}

	// Get Employee by employeeId
	@GetMapping(path = "/bank/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BankEmployee> employeeById(@PathVariable("employeeId") String employeeId) {
		BankEmployee employee = employeeService.getBankEmployeeById(employeeId);
		return new ResponseEntity<BankEmployee>(employee, HttpStatus.OK);
	}

	// Update Employee by employeeId
	// @PutMapping(path = "/bank/{employeeId}", consumes = "application/json")
	// public ResponseEntity<String> updateBank(@PathVariable("employeeId") int
	// employeeId,
	// @RequestBody BankEmployee employee) {
	//
	// employeeService.updateBankEmployee(employeeId, employee);
	//
	// return ResponseEntity.ok().body("Employee has been updated with employeeId="
	// + employeeId);
	// }

	// -----------------------------------------------------------------------------------------------

	// Add Loan
	@PostMapping(path = "/loan/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addLoan(@RequestBody Loan loan) {
		System.out.println("Loan JSON :: " + loan);
		if (loan.getAccount() == null)
			return new ResponseEntity<String>("Account not found", HttpStatus.BAD_REQUEST);

		loan.setAccount(accountService.getAccountByNo(loan.getAccount().getAccountNo()));
		loan.getAccount().setBalance(loan.getLoanAmount() + loan.getAccount().getBalance());
		loanService.addLoan(loan);

		return new ResponseEntity<Loan>(loan, HttpStatus.CREATED);
	}

	// Get All loans
	@GetMapping(path = "/loan", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Loan>> loanList() {

		List<Loan> loans = loanService.getLoan();
		return new ResponseEntity<List<Loan>>(loans, HttpStatus.OK);
	}

	// Get Loan by loanId
	@GetMapping(path = "/loan/{loanId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Loan> loanById(@PathVariable("loanId") int loanId) {
		Loan loan = loanService.getLoanById(loanId);
		return new ResponseEntity<Loan>(loan, HttpStatus.OK);
	}

	// Update Branch by branchId
	// @PutMapping("/loan/{loanId}")
	// public ResponseEntity<Loan> updateLoan(@PathVariable("loanId") int loanId,
	// @RequestBody Loan loan) {
	//
	// Loan loan2 = loanService.getLoanById(loanId);
	// loan2.setLoanAmount(loan.getLoanAmount());
	// loanService.update
	//
	// return ResponseEntity.ok().body("Bank has been updated with branchId=" +
	// branchId);
	// }
}
