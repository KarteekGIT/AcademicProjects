package Banking;

import java.util.Scanner;

class AccountUser{
	private Accounts ac;
	private Scanner input = new Scanner(System.in);
	private String newName, newType;
	
	AccountUser(Accounts accountDetails){
		this.ac = 	accountDetails;
	}
	public void deposit(double amount){
		double totalBalance = ac.getTotalBalance();
		totalBalance += amount;
		ac.setTotalBalance(totalBalance);
		System.out.println("Amount Deposited Successfully");
	}
	public void withdraw(double amount){
		double totalBalance = ac.getTotalBalance();
		totalBalance -= amount;
		ac.setTotalBalance(totalBalance);
		System.out.println("Amount Withdrawed Successfully...Please get amount from cashier using this reciept");
	}
	public void balanceEnquiry(){
		System.out.println("Name of the Account Holder : "+ac.getAccountName());
		System.out.println("Account Holder Account Number : "+ac.getAccountNumber());
		System.out.println("Account Holder Account Type: "+ac.getAccountType());
		System.out.println("Total Balance : "+ac.getTotalBalance());
	}
	public void modifyAccountInformation(){
		int choice;
		System.out.println("*****Please choose from below sub menu*****");
		System.out.println("Press 1 to change Account Name");
		System.out.println("Press 2 to change Account Type");
		choice = Integer.parseInt(input.nextLine().trim());
		switch(choice){
			case 1:
				System.out.println("Old Account Name : "+ac.getAccountName());
				System.out.println("Enter New Name : ");
				newName = input.nextLine().trim();
				ac.setAccountName(newName);
				System.out.println("Account Name Changed Successfully");
				break;
			case 2:
				System.out.println("Old Account Type : "+ac.getAccountType());
				System.out.println("Enter New Account Type : ");
				newType = input.nextLine().trim();
				ac.setAccountType(newType);
				System.out.println("Account Type changed successfully");
		}
		
	}
	public void resetPinNumber(){
		int pinNumber;
		System.out.println("Please type old pin number");
		pinNumber = Integer.parseInt(input.nextLine().trim());
		if(ac.getPinNumber() == pinNumber){
			System.out.println("Please type New pin number");
			pinNumber = Integer.parseInt(input.nextLine().trim());
			ac.setPinNumber(pinNumber);
			System.out.println("Pin Number Changed Successfully");
		}
	}
	public void menu(){
		int choice;
		double amount;
		do{
			System.out.println("*****Please choose from menu*****");
			System.out.println("1 : Balance Inquery");
			System.out.println("2 : Modify Account Information");
			System.out.println("3 : Deposit into Account");
			System.out.println("4 : Withdraw from Account");
			System.out.println("5 : Reset Pin Number");
			System.out.println("6 : Exit");
			choice = Integer.parseInt(input.nextLine().trim());
			switch(choice){
				case 1:
					balanceEnquiry();
					break;
				case 2:
					modifyAccountInformation();
					break;
				case 3:
					System.out.println("Please enter amount to deposit : ");
					amount = Double.parseDouble(input.nextLine().trim());
					deposit(amount);
					break;
				case 4:
					System.out.println("Please enter amount to withdraw : ");
					amount = Double.parseDouble(input.nextLine().trim());
					withdraw(amount);
					break;
				case 5:
					resetPinNumber();
				case 6:
					System.out.println();
					break;
				default:
					System.out.println("Invalid option");
			}
		}while(choice != 6);
	}
}