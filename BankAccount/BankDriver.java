package com.dsa.app.assignments;

public class BankDriver {
	public static void main(String[] args) {
		
		BankAccount hdfc = new BankAccount(745465451,"YOGESH SHENDE", 20000, "savings", "2000947", "baner,pune");
		BankAccount sbi = new BankAccount(984565428,"YOGESH SHENDE", 20000, "savings", "6000876", "baner,pune");
		BankAccount kotak = new BankAccount(988264454,"YOGESH SHENDE", 20000, "savings", "8000557", "baner,pune");
		BankAccount axis = new BankAccount(567893449,"YOGESH SHENDE", 20000, "savings", "8930439", "baner,pune");
		
		
		System.out.println(hdfc.getAccountHolder());
		
		hdfc.showBalance();
		
		hdfc.deposit(7000);
		
		hdfc.showBalance();
		
		hdfc.deposit(-110000);
		
		hdfc.withdraw(5000);
		
		hdfc.Transfer(axis, 10000);
		
		axis.showBalance();
		
		hdfc.Transfer(axis, -5400);
		
		
		hdfc.showBalance();
		
		
	}

}
