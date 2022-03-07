package logic;

public class Accounts {
	
	private String accountNumber = "";
	private String pin = "";
	private String name = "";
	
	public Accounts(String accountNumber, String pin, String fullName) {
		this.setAccountNumber(accountNumber);
		this.setPin(pin);
		this.setName(fullName);
		
	}
	
	public void getTransactionHistory() {
		
	}
	
	public void withdrawMoney() {
		
	}
	
	public void addMoney() {
		
	}
	
	public void transferToNewAccount() {
		
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
