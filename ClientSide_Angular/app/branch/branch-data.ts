import { Bank } from "../bank/bank-data";

export class Branch {
    branchId!: number;
    branchName!: string;
    branchAddress!: string;
    bank = new Bank();

    constructor() {}
}
