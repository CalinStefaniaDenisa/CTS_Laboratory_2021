package ro.ase.csie.cts.assignment;

import java.util.Calendar;
import java.util.Date;

import ro.ase.csie.cts.assignment.exception.InvalidLoanValueException;

public class Account {

	private double loanValue, interestRate;
	private int daysActive;
	private AccountType accountType;
	public static final float BROKER_FEE = 0.0125f;
	
	public double getLoanValue() {
		return loanValue;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public int getDaysActive() {
		return daysActive;
	}
	
	public void setLoanValue(double loanValue) throws InvalidLoanValueException {
		if(loanValue < 0) {			
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
	
	private static int getNumOfDaysInCurrentYear() {
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int numOfDays = cal.getActualMaximum(Calendar.DAY_OF_YEAR);

        return numOfDays;
	}

	private static float getNumberOfCompoundingPeriods(Account account) {
		int numOfDays = getNumOfDaysInCurrentYear();

		return account.daysActive / numOfDays;
	}
	
	public static double getCompoundInterestValue(Account account) {
		float noOfCompoundingPeriods = getNumberOfCompoundingPeriods(account);
		double compoundInterestValue = account.loanValue * (Math.pow( 1 + account.interestRate, noOfCompoundingPeriods) - 1);

		return compoundInterestValue;
	}

	public static double calculateTotalFee(Account account) {
		double totalFee = 0.0;

		if(account.accountType == AccountType.PREMIUM || account.accountType == AccountType.SUPER_PREMIUM) {
			totalFee = BROKER_FEE * getCompoundInterestValue(account);
		}

		return totalFee;
	}

	public Account(double loanValue, double rate, AccountType accountType, int daysActive) throws InvalidLoanValueException {
		setLoanValue(loanValue);
		this.interestRate = rate;
		this.accountType = accountType;
		this.daysActive = daysActive;
	}
	
	public String toString() {
		return "Loan: " + this.loanValue + "; rate: " + this.interestRate + "; days active:" + daysActive + "; Type: " + accountType + ";";
	}
	
	
}