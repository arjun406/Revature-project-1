package com.dao;

import com.exception.BusinessException;
import com.shop.model.Account;

public interface AccountDAO {
	public int createAccount(Account account) throws BusinessException;

	int updateAccount(int id, long contact) throws BusinessException;

	int deleteAccount(int id) throws BusinessException;
 }
