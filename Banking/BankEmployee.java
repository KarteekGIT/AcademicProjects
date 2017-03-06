package Banking;

import java.util.Scanner;
import java.util.ArrayList;

public class BankEmployee{
	private ArrayList<Accounts> allAccounts = new ArrayList<Accounts>();
	private Scanner input = new Scanner(System.in);

	public void addAccount(){
		String name;
		String accountType;
		int accountNumber;
		int pinNumber;
		double initialAmount;
		Accounts newAccount = new Accounts();
		
		System.out.println("Enter name of the account holder : ");
		name = input.nextLine().trim();
		newAccount.setAccountName(name);
		
		System.out.println("Enter account number : ");
		accountNumber = Integer.parseInt(input.nextLine().trim());
		newAccount.setAccountNumber(accountNumber);
		
		System.out.println("Enter pin number : ");
		pinNumber = Integer.parseInt(input.nextLine().trim());
		newAccount.setPinNumber(pinNumber);
		
		System.out.println("Enter account type : ");
		accountType = input.nextLine().trim();
		newAccount.setAccountType(accountType);
		
		System.out.println("Enter initial amount : ");
		initialAmount = Double.parseDouble(input.nextLine().trim());
		newAccount.setTotalBalance(initialAmount);
		
		allAccounts.add(newAccount);
	}
	public void modifyAccount(int accountNumber){
		int choice;
		String newName;
		String newType;
		Accounts ac = checkAccountNumber(accountNumber);
		if(ac != null){
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
					break;
			}
		}else{
			System.out.println("Acount not in records");
		}
	}
	public void deposit(int accountNumber, double amount){
		Accounts ac = checkAccountNumber(accountNumber);
		if(ac != null){
			double totalBalance = ac.getTotalBalance();
			totalBalance += amount;
			ac.setTotalBalance(totalBalance);
			System.out.println("Amount deposited successfully");
		}else{
			System.out.println("Account not in records");
		}
	}
	public void withdraw(int accountNumber, double amount){
		Accounts ac = checkAccountNumber(accountNumber);
		if(ac != null){
			double totalBalance = ac.getTotalBalance();
			totalBalance -= amount;
			ac.setTotalBalance(totalBalance);
			System.out.println("Amount withdrawned successfully");
		}else{
			System.out.println("Account not in records");
		}
	}
	public void getAllAccounts(){
		System.out.println("|Name             |Account Number |Account Type |Balance    |");
		for(Accounts ac : this.allAccounts){
			System.out.println();
			System.out.print(ac.getAccountName()+"    ");
			System.out.print(ac.getAccountNumber()+"    ");
			System.out.print(ac.getAccountType()+"    ");
			System.out.print(ac.getTotalBalance()+"    ");
			System.out.println();
			System.out.println("--------------------------------------------------------------");
		}
		
	}
	public void removeAccount(int accountNumber){
			Accounts ac = checkAccountNumber(accountNumber);
			if(ac != null){
				allAccounts.remove(ac);
				System.out.println("Account removed successfully");
			}else{
				System.out.println("Account not in records");
			}
	}
	public void menu(){
			int choice;
			int accountNumber;
			double amount;
		do{
			System.out.println("*****Please choose from below menu*****");
			System.out.println("1 : Add Account");
			System.out.println("2 : Modify Account");
			System.out.println("3 : Deposit into Account");
			System.out.println("4 : Withdraw from Account");
			System.out.println("5 : Get All Account");
			System.out.println("6 : Delete Account");
			System.out.println("7 : Exit");
			choice = Integer.parseInt(input.nextLine().trim());
			
			switch(choice){
				case 1:
					addAccount();
					System.out.println("Account added successfully");
					break;
				case 2:
					System.out.println("Enter account number to modify");
					accountNumber = Integer.parseInt(input.nextLine().trim());
					modifyAccount(accountNumber);
					break;
				case 3:
					System.out.println("Enter account number to deposit");
					accountNumber = Integer.parseInt(input.nextLine().trim());
					System.out.println("Enter amount to deposit");
					amount = Double.parseDouble(input.nextLine().trim());
					deposit(accountNumber, amount);
					break;
				case 4:
					System.out.println("Enter account number to withdraw");
					accountNumber = Integer.parseInt(input.nextLine().trim());
					System.out.println("Enter amount to withdraw");
					amount = Double.parseDouble(input.nextLine().trim());
					withdraw(accountNumber, amount);
					break;
				case 5:
					getAllAccounts();
					break;
				case 6:
					System.out.println("Enter account number to remove");
					accountNumber = Integer.parseInt(input.nextLine().trim());
					removeAccount(accountNumber);
					break;
				case 7:
					System.out.println();
					break;
				default :
					System.out.println("Invalid option");
			}
		}while(choice != 7);	
	}
	public Accounts checkAccountNumber(int accountNumber){
		for(Accounts acs : this.allAccounts){
			if(acs.getAccountNumber() == accountNumber){
				return acs;
			}
		}
		return null;
	}
	public Accounts checkAccountNumber(int accountNumber, int pinNumber){
		for(Accounts acs : this.allAccounts){
			if(acs.getAccountNumber() == accountNumber && acs.getPinNumber() == pinNumber){
				return acs;
			}
		}
		return null;
	}
}
