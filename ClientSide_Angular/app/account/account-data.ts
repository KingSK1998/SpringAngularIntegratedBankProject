import { Branch } from "../branch/branch-data";
import { Customer } from "../customer/customer-data";

export class Account {
    accountNo!: number;
    accountType!: string;
    balance!: number;
    branch = new Branch();
    customers = new Customer();
}
