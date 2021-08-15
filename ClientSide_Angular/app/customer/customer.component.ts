import { Component, OnInit } from '@angular/core';
import { Customer } from './customer-data';
import { CustomerService } from './customer.service';

@Component({
	selector: 'app-customer',
	templateUrl: './customer.component.html',
	styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

	custName!: string;
	custPhone!: string;
	custAdd!: string;
	custEmail!: string;
	custAddProofType!: string;
	custAddProofNo!: string;
	custPancard!: string;

	customers: Customer[] = [];
	addressTypes = ["Aadhar Card", "Voter Id", "Rashan Card", "Electricity Bill", "Birth Certificate"];

	isShowForm = false;
	isShowList = true;

	constructor(private customerService: CustomerService) { 
	}
	
	ngOnInit(): void { 
		this.getCustomer();
	}
	
	getCustomer() {
		this.customerService.getCustomers().subscribe(data => this.customers = data);
		console.log("Customer Reterived");
	}

	addCustomer() {
		const customer = new Customer();
			customer.customerName = this.custName;
			customer.customerPhone = this.custPhone; 
			customer.customerAddress = this.custAdd;
			customer.customerEmail = this.custEmail;
			customer.addressProofIdType = this.custAddProofType;
			customer.addressProofIdNo = this.custAddProofNo;
			customer.pancard = this.custPancard;

		alert(JSON.stringify(customer));
		console.log(JSON.stringify(customer));
		if (
			customer.customerName != undefined ||
			customer.addressProofIdType != undefined ||
			customer.addressProofIdNo != undefined ||
			customer.customerPhone != undefined)
			this.customerService.addCustomer(customer).subscribe(
			  data => {
				console.log("response", data);
				this.ngOnInit();
			  }
			);
		  this.displayList();
	}

	updateCustomer(customer: Customer) {
		const index = this.customers.indexOf(customer);
		this.customers.splice(index, 1);
		console.log(JSON.stringify(customer));
	}

	displayForm() {
		this.isShowList = false;
		this.isShowForm = true;
	  }
	
	  displayList() {
		this.isShowForm = false;
		this.isShowList = true;
	  }
}
