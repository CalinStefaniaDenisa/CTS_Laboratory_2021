package ro.ase.csie.cts.g1092.week2;

import ro.ase.csie.cts.g1092.week2.exceptions.IllegalTransferException;
import ro.ase.csie.cts.g1092.week2.exceptions.InsufficientFundsException;

public class CurrentAccount extends BankAccount {
	
	public static final double MAX_CREDIT = 5000;

	public CurrentAccount(String iban) {
		super(CurrentAccount.MAX_CREDIT, iban);
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return super.getBalance();
	}

	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}

	@Override
	public void transfer(Account destination, double amount) throws InsufficientFundsException, IllegalTransferException {
		if( this == destination) 
			throw new IllegalTransferException();
		this.withdraw(amount);
		destination.deposit(amount);
	}

	@Override
	public void withdraw(double amount) throws InsufficientFundsException {
		if(amount > this.balance)
			throw new InsufficientFundsException("You don't have the amount.");
		else
			this.balance -= amount;
	}
	
	

}
