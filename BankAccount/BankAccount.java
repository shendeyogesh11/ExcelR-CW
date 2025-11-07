package com.dsa.app.assignments;

public class BankAccount {
	
	private int accountNumber;
	private String accountHolder;
	private double balance;
	private String accountType;
	private String ifsc;
	private String branchName;	
	
	
	
	public BankAccount(int accountNumber, String accountHolder, double balance, String accountType, String ifsc,
			String branchName) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.accountType = accountType;
		this.ifsc = ifsc;
		this.branchName = branchName;
	}
	
	
	public void deposit(double dAmt) {
		
		if(dAmt>0) {
			balance += dAmt;
			System.out.println("deposited with amount : " + dAmt);
		}
		else {
			System.out.println("enter valid deposit amount !! ");
		}
		
		
	}
	
   public void withdraw (double wAmt) {
		
		if(wAmt>0 && wAmt <= balance) {
			balance -= wAmt;
			System.out.println("withdrawl with amount : " + wAmt + " done.");
		}
		else {
			System.out.println("insufficient balance !! ");
		}
		
		
	}
   
   
   
   public double showBalance () {
		
	   System.out.println("balance is: " + balance);
	   
		return balance;	
		
	}
   
   
   
   public void Transfer (BankAccount ac, double tAmt) {
		
	   if(tAmt > 0) {
		   ac.balance += tAmt;
		   balance -= tAmt;
		   System.out.println("transferred " + tAmt + " to " + ac.accountHolder );
	   }else {
		   System.out.println("enter valid transfer amount! ");
	   }
	   
		
	}
	
	
	
	
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	@Override
	public String toString() {
		return "BankAccount Details: [accountNumber=" + accountNumber + ", accountHolder=" + accountHolder + ", balance="
				+ balance + ", accountType=" + accountType + ", ifsc=" + ifsc + ", branchName=" + branchName + "]";
	}
	
	
	
	

}
