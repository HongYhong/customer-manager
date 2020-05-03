package com.hongfox.bean;

public class Account {
	private double balance;
	private double annualInterestRate;
	
	public Account(double balance, double annualInterestRate) {
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("成功存钱。");
	}
	
	public boolean withDraw(double amount) {
		if (this.balance < amount) {
			return false;
		}else {
			balance -= amount;
			return true;
		}
	}
	
	
}
