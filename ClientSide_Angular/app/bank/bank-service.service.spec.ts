import { TestBed } from '@angular/core/testing';

import { BankService } from './bank-service.service';

describe('BankServiceService', () => {
  let service: BankService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BankService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
