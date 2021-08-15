import { Account } from "../account/account-data";

export class Loan {
    loanId!: number;
    loanType!: string;
    loanAmount!: number;
    account = new Account();

    constructor() {}
}
