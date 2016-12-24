package Banking;

class Accounts{
	private String name;
	private int accountNumber;
	private int pinNumber;
	private double totalBalance = 0;
	private String accountType;
	
	public void setAccountName(String name){
		this.name =  name;
	}
	public  String getAccountName(){
		String nameCopy = new String(this.name) ;
		return nameCopy;
	}
	
	public void setAccountNumber(int accountNumber){
		this.accountNumber = accountNumber;
	}
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public void setPinNumber(int pinNumber){
		this.pinNumber = pinNumber;
	}
	public int getPinNumber(){
		return pinNumber;
	}
	
	public void setTotalBalance(double totalBalance){
		this.totalBalance = totalBalance;
	}
	public double getTotalBalance(){
		return totalBalance;
	}
	
	public void setAccountType(String accountType){
		this.accountType = accountType;
	}
	public String getAccountType(){
		String accountTypeCopy = new String(this.accountType);
		return accountTypeCopy;
	}
}