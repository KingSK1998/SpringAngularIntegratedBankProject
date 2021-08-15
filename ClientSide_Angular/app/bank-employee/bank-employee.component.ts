import { Component, OnInit } from '@angular/core';
import { Employee } from './employee-data';
import { EmployeeService } from './employee.service';

@Component({
	selector: 'app-bank-employee',
	templateUrl: './bank-employee.component.html',
	styleUrls: ['./bank-employee.component.css']
})
export class BankEmployeeComponent implements OnInit {

	employeeName!: string;
	employeePhone!: string;
	employeeAdd!: string;
	employeeEmail!: string;
	employeeAddProofType!: string;
	employeeAddProofNo!: string;
	employeePancard!: string;
	employeeRole!: string;
	branchId!: number;

	employees: Employee[] = [];
	addressTypes = ["Aadhar Card", "Voter Id", "Rashan Card", "Electricity Bill", "Birth Certificate"];
	assignRole = ["admin", "manager", "clerk", "customer"];

	isShowForm = false;
	isShowList = true;

	constructor(private employeeService: EmployeeService) {
	}

	ngOnInit(): void {
		this.getEmployees();
	}

	getEmployees() {
		this.employeeService.getEmployees().subscribe(data => this.employees = data);
		console.log("Employee Reterived");
	}

	addEmployee() {
		const employee = new Employee();
		employee.employeeName = this.employeeName;
		employee.employeePhone = this.employeePhone;
		employee.employeeEmail = this.employeeEmail;
		employee.employeeRole = this.employeeRole;
		employee.addressProofIdType = this.employeeAddProofType;
		employee.addressProofIdNo = this.employeeAddProofNo;
		employee.branch.branchId = this.branchId;

		alert(JSON.stringify(employee));
		console.log(JSON.stringify(employee));
		if (
			employee.employeeName != undefined ||
			employee.addressProofIdType != undefined ||
			employee.addressProofIdNo != undefined ||
			employee.employeePhone != undefined)
			this.employeeService.addEmployee(employee).subscribe(
				data => {
					console.log("response", data);
					this.ngOnInit();
				}
			);
		this.displayList();
	}

	updateEmployee(employee: Employee) {
		const index = this.employees.indexOf(employee);
		this.employees.splice(index, 1);
		console.log(JSON.stringify(employee));
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
