package com.main;

import java.util.Scanner;

import org.apache.log4j.Logger;
import com.exception.BusinessException;
import com.service.AccountService;
import com.service.AccountServiceImpl;
import com.shop.model.Account;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			
			AccountService accountService = new AccountServiceImpl();
			
			Account account =new Account(); 

			log.info("----------------------------");
			log.info("Welcome to the world of Online Shopping");
			log.info("==========================================");

			int ch = 0;
			do {
				log.info("======================================");
				log.info("please Login...............");
				log.info("-=====================================");
				log.info("1.Create Account");
				log.info("2.Employee Login");
				log.info("3.customer Login");
				log.info("4.Exit");
				log.info("=====================================");
				log.info("Enter your choice Between (1-4)");
				try {
					ch = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					

				}

				switch (ch) {
				case 1:
					try {

						log.info("create your Account");
						log.info("Name");
						String name = scanner.nextLine();
						if (name.length() != 0 && name.matches("[A-za-z]{1,30}")) {
							account.setName(name);
						} else {
							throw new BusinessException("Give proper FirstName");
						}
						log.info("Email");
						String email = scanner.nextLine();

						if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
						{
							account.setEmail(email);
						} 
						
						else {
							throw new BusinessException("please check and give your proper Email-Id");
						}
						log.info("Phone Number");
						String phoneNumber = scanner.nextLine();
						if (phoneNumber.matches("\\d{10}$")) {
							account.setPhoneNumber(phoneNumber);
						} else {
							throw new BusinessException("Give proper Phone Number");
						}
						log.info("Please Enter user type as CUST or EMP");
						String userType = scanner.nextLine();
						if (userType.equals("CUST") || userType.equals("EMP")) {
							account.setAccountType(userType);
						} else {
							throw new BusinessException("Please give proper User Type");
						}


						log.info("Set password");
						String password = scanner.nextLine();
						if (password.matches("[A-z]{1}[a-zA-Z0-9@_-]{7,20}")) {
							account.setPassword(password);
						} else {
							throw new BusinessException(" please check and give proper Password");
						}

						if (accountService.createAccount(account) == 1)

						{
							log.info("Account Created Successfully!!!");
							log.info("Please login again");
							log.info("Returning to Main menu.....");

						} else {
							log.info("Returning to Main Menu.....");
						}

					} catch (BusinessException e) {
						log.warn(e.getMessage());
					}
					break;
     
				case 4:
					log.info("Thank you for using this app & have a nice day :)");
					break;
				default:
					log.warn("Invalid Entry...");
					break;
				}

			} while (ch != 4);

		}


	
}
