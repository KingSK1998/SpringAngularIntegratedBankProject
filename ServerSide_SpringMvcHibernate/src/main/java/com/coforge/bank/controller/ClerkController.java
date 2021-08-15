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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.bank.model.Account;
import com.coforge.bank.model.Customer;
import com.coforge.bank.model.Deposit;
import com.coforge.bank.service.IAccountService;
import com.coforge.bank.service.IBranchService;
import com.coforge.bank.service.ICustomerService;
import com.coforge.bank.service.IDepositService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/clerk")
public class ClerkController {

	@Autowired
	private IAccountService accountService;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IDepositService depositService;

	@Autowired
	private IBranchService branchService;

	// ------------ Account - add, get all, get 1 ------------

	// Add Account
	@PostMapping(path = "/account/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAccount(@RequestBody Account account) {
		System.out.println("Account JSON :: " + account);
		if (account.getBranch() == null)
			return new ResponseEntity<String>("Branch not found", HttpStatus.BAD_REQUEST);
		if (account.getCustomers() == null)
			return new ResponseEntity<String>("Customer not found", HttpStatus.BAD_REQUEST);

		account.setBranch(branchService.getBranchById(account.getBranch().getBranchId()));
		System.out.println(account.getBranch());
		account.setCustomers(customerService.getCustomerById(account.getCustomers().getCustomerId()));
		System.out.println(account.getCustomers());
		accountService.addAccount(account);
		System.out.println(account);
		return new ResponseEntity<Account>(account, HttpStatus.CREATED);
	}

	// Get All Accounts
	@GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> accountList() {
		List<Account> accounts = accountService.getAccount();
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}

	// Get Account by accountNo
	@GetMapping(path = "/account/{accountNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> accountByNo(@PathVariable("accountNo") int accountNo) {
		Account account = accountService.getAccountByNo(accountNo);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	// -------------- Customer - add, get all, get 1 --------------

	// Add Customer
	@PostMapping(path = "/customer/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		System.out.println("Customer JSON :: " + customer);
		customer.setCustomerId(customer.getAddressProofIdNo());
		customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}

	// Get All Customers
	@GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> customerList() {
		List<Customer> customers = customerService.getCustomer();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	// Get Customer by customerId
	@GetMapping(path = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> customerById(@PathVariable("customerId") String customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	// Update Customer by customerId
	@PutMapping(path = "/customer/{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateBranch(@PathVariable("customerId") String customerId,
			@RequestBody Customer customer) {

		customerService.updateCustomer(customerId, customer);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	// --------------- Deposit - add, get all, get 1 ----------------

	// Add Deposit
	@PostMapping(path = "/deposit/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addDeposit(@RequestBody Deposit deposit) {
		System.out.println("Deposit JSON :: " + deposit);

		deposit.setAccount(accountService.getAccountByNo(deposit.getAccount().getAccountNo()));
		deposit.getAccount().setBalance(deposit.getDepositAmount() + deposit.getAccount().getBalance());
		depositService.addDeposit(deposit);

		return new ResponseEntity<Deposit>(deposit, HttpStatus.CREATED);
	}

	// Get All Deposits
	@GetMapping(path = "/deposit", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Deposit>> depositList() {
		List<Deposit> deposits = depositService.getDeposit();
		return new ResponseEntity<List<Deposit>>(deposits, HttpStatus.OK);
	}

	// Get Deposit by depositId
	@GetMapping(path = "/deposit/{depositId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Deposit> depositById(@PathVariable("depositId") int depositId) {
		Deposit deposit = depositService.getDepositById(depositId);
		return new ResponseEntity<Deposit>(deposit, HttpStatus.OK);
	}
}
