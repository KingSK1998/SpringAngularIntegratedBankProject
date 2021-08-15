import { Account } from "../account/account-data";

export class Deposit {
    depositId!: number;
    customerName!: string;
    dateOfDeposit!: string;
    depositAmount!: number;
    account = new Account();

    constructor() {}
}