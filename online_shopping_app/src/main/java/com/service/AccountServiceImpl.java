package com.service;

import com.dao.AccountDAO;
import com.dao.AccountDAOImpl;
import com.exception.BusinessException;
import com.shop.model.Account;

public class AccountServiceImpl implements AccountService {
	AccountDAO accountDAO = new AccountDAOImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int createAccount(Account account) throws BusinessException {
		int accountUser = 0;
		accountUser = accountDAO.createAccount(account);

		return accountUser;
	}

	@Override
	public int updateAccount(int id, long contact) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		c=accountDAO.updateAccount(id, contact);
		return c;
	}

	@Override
	public int deleteAccount(int id) throws BusinessException {
		// TODO Auto-generated method stub
		int c=0;
		c=accountDAO.deleteAccount(id);
		return c;
	}

}
