package com.shop.model;

public class Account {
  
	private int accountId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String accountType;
    
    public Account() {
    	
    }
	public int getAccountId() {
		return accountId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Account(int accountId, String name, String email, String password,String phoneNumber,
			String accountType) {
		super();
		this.accountId = accountId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber=phoneNumber;
		this.accountType=accountType;
		
	}
	@Override
	public String toString() {
		return "Account Created";
	}
	
    
}

