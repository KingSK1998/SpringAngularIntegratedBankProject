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

import com.coforge.bank.model.Bank;
import com.coforge.bank.model.Branch;
import com.coforge.bank.service.IBankService;
import com.coforge.bank.service.IBranchService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IBankService bankService;

	@Autowired
	private IBranchService branchService;

	// Add Bank
	@PostMapping(path = "/bank/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bank> addBank(@RequestBody Bank bank) {
		bankService.addBank(bank);
		return new ResponseEntity<Bank>(bank, HttpStatus.CREATED);
	}

	// Add branch
	@PostMapping(path = "/branch/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Branch> addBranch(@RequestBody Branch branch) {
		Bank bank = bankService.getBankByCode(branch.getBank().getBankCode());
		branch.setBank(bank);
		branchService.addBranch(branch);
		return new ResponseEntity<Branch>(branch, HttpStatus.CREATED);
	}

	// Get All Banks
	@GetMapping(path = "/bank", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Bank>> bankList() {
		List<Bank> banks = bankService.getBank();
		return new ResponseEntity<List<Bank>>(banks, HttpStatus.OK);
	}

	// Get All branches
	@GetMapping(path = "/branch", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Branch>> branchList() {
		List<Branch> branchs = branchService.getBranch();
		return new ResponseEntity<List<Branch>>(branchs, HttpStatus.OK);
	}

	// Get Bank by bankCode
	@GetMapping(path = "/bank/{bankCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bank> bankByCode(@PathVariable("bankCode") int bankCode) {
		Bank bank = bankService.getBankByCode(bankCode);
		return new ResponseEntity<Bank>(bank, HttpStatus.OK);
	}

	// Get Branch by branchId
	@GetMapping(path = "/branch/{branchId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Branch> branchById(@PathVariable("branchId") int branchId) {
		Branch branch = branchService.getBranchById(branchId);
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}

	// Update Bank by bankCode
	@PutMapping(path = "/bank/{bankCode}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bank> updateBank(@PathVariable("bankCode") int bankCode, @RequestBody Bank bank) {

		bankService.updateBank(bankCode, bank);

		return new ResponseEntity<Bank>(bank, HttpStatus.OK);
	}

	// Update Branch by branchId
	@PutMapping(path = "/branch/{branchId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Branch> updateBranch(@PathVariable("branchId") int branchId, @RequestBody Branch branch) {

		branchService.updateBranch(branchId, branch);

		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}
}
