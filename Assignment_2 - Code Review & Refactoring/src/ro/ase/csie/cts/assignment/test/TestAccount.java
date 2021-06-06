package ro.ase.csie.cts.assignment.test;

import ro.ase.csie.cts.assignment.Account;
import ro.ase.csie.cts.assignment.AccountType;
import ro.ase.csie.cts.assignment.exception.InvalidLoanValueException;

public class TestAccount {

	public static void main(String[] args) throws InvalidLoanValueException {
		
		Account account1 = new Account(1000, 0.15, AccountType.SUPER_PREMIUM, 375);
		account1.getLoanValue();
		account1.getInterestRate();
		System.out.println(account1.getYearlyInterestValue());
		System.out.println(account1.getCompoundInterestValue());
		System.out.println(account1.toString());
		
		System.out.println(account1.calculateTotalFee());

	}

}
