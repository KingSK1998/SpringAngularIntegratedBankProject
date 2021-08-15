import { Branch } from "../branch/branch-data";

export class Employee {
    employeeId!: string;
    employeeName!: string;
    employeePhone!: string;
    employeeEmail!: string;
    addressProofIdType!: string;
    addressProofIdNo!: string;
    employeeRole!: string;
    branch = new Branch();

    constructor() {}
}