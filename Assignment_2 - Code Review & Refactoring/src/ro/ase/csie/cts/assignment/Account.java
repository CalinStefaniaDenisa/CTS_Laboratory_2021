package ro.ase.csie.cts.assignment;

import java.util.Calendar;
import java.util.Date;

import ro.ase.csie.cts.assignment.exception.InvalidLoanValueException;

public class Account {

	private double loanValue, interestRate;
	private AccountType accountType;
	private int daysActive;
	private static final double BROKER_FEE = 0.0125;
	private static final double INITIAL_FEE = 0.0;
	
	public Account(double loanValue, double rate, AccountType accountType, int daysActive) throws InvalidLoanValueException {
		this.setLoanValue(loanValue);
		this.interestRate = rate;
		this.accountType = accountType;
		this.daysActive = daysActive;
	}

	public double getLoanValue() {
		return this.loanValue;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public int getDaysActive() {
		return this.daysActive;
	}
	
	public void setLoanValue(double loanValue) throws InvalidLoanValueException {
		if(loanValue <= 0) {
			throw new InvalidLoanValueException();
		} else {
			this.loanValue = loanValue;
		}
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void setDaysActive(int daysActive) {
		this.daysActive = daysActive;
	}


	public double getYearlyInterestValue() {
		return this.loanValue * this.interestRate;
	}
	
	private int getNumOfDaysInCurrentYear() {
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
	}

	private float getNumberOfCompoundingPeriods() {
		return this.daysActive / this.getNumOfDaysInCurrentYear();
	}
	
	public double getCompoundInterestValue() {
		return this.loanValue * (Math.pow( 1 + this.interestRate, this.getNumberOfCompoundingPeriods()) - 1);
	}

	public double calculateTotalFee() {
		return (this.accountType == AccountType.PREMIUM || this.accountType == AccountType.SUPER_PREMIUM) 
					? BROKER_FEE * this.getCompoundInterestValue() 
					: INITIAL_FEE;
	}

	@Override
	public String toString() {
		return "Account [loanValue=" + loanValue + ", interestRate=" + interestRate + ", daysActive=" + daysActive
				+ ", accountType=" + accountType + "]";
	}
	
}