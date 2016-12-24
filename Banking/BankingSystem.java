package Banking;

import java.util.Scanner;

class BankingSystem{
	private Scanner sc = new Scanner(System.in);
	private BankEmployee be = new BankEmployee();
	private AccountUser user;
	
	public static void main(String[] args){
		BankingSystem bs = new BankingSystem();
		bs.startSystem();
	}
	public void startSystem(){
		String option;
		int accountNumber, pinNumber;
		do{	
			System.out.println("Are you a User or Employee?");
			option = sc.nextLine().trim();
			if((option.toUpperCase()).equals("USER")){
				System.out.println("Type Account Number : ");
				accountNumber = Integer.parseInt(sc.nextLine().trim());
				System.out.println("Type pin Number : ");
				pinNumber = Integer.parseInt(sc.nextLine().trim());
				Accounts ac = this.be.checkAccountNumber(accountNumber, pinNumber);
				if(ac != null){
					this.user = new AccountUser(ac);
					this.user.menu();
					System.out.println("If you want to exit type yes. Type no if you don't want to exit");
					option = sc.nextLine().trim();
				}else{
					System.out.println("No Accounts created please check with your bank");
					System.out.println("If you want to exit type yes. Type no if you don't want to exit");
					option = sc.nextLine().trim();
				}
			}else if((option.toUpperCase()).equals("EMPLOYEE")){
				this.be.menu();
				System.out.println("If you want to exit type yes. Type no if you don't want to exit");
				option = sc.nextLine().trim();
			}else{
				System.out.println("Invalid option");
				System.out.println("If you want to exit type yes. Type no if you don't want to exit");
				option = sc.nextLine().trim();
			}
		}while(!((option.toUpperCase()).equals("YES")));
	}
}