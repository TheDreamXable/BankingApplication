package bankingApplication.classes;

import java.util.Scanner;

import bankingApplication.interfaces.showMenu;

public class bankAccount implements showMenu {
	
	int balance;
	int previousTransactions;
	String customerId;
	String customerName;
	
	
	//Getting 2 values to display welcome message
	public bankAccount(String custName, String custId) {
		
		customerName = custName;
		customerId = custId;
		
	}

	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransactions = amount;
			System.out.println("Your Amount is: " + balance);		
			}
	}
	
	void withdraw (int amount) {
		
		if (amount != 0) {
			balance = balance - amount;
			previousTransactions = -amount;
		}
	}
	
	void getPreviousTransactions() {
		
		if (previousTransactions > 0) {
			System.out.println("Deposited: " + previousTransactions);
		} else if (previousTransactions < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransactions));
		} else {
			System.out.println("No transactions Occured");
		}
	}

	@Override
	public void showBankMenu() {
		
		char option = '0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome, " + customerName);
		System.out.println("Your Id: " + customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. previousTransactions");
		System.out.println("E. Exit");
		
		do {
			
			System.out.println("===========================================");
			System.out.println("Enter an Option");
			System.out.println("===========================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			case 'A':
				System.out.println("-----------------------------------------");
				System.out.println("Balance: " +balance);
				System.out.println("-----------------------------------------");
				System.out.println("\n");
				
			case 'B':
				System.out.println("-----------------------------------------");
				System.out.println("Enter an amount to deposit: ");
				System.out.println("-----------------------------------------");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("-----------------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("-----------------------------------------");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("-----------------------------------------");
				getPreviousTransactions();
 				System.out.println("-----------------------------------------");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("...Exiting");
				break;

				
			default:
				System.out.println("Invalid input, please try again.");
				break;

			}

		} 	while(option != 'E');
				System.out.println("Thank You For Using Our Services");

	}

}
