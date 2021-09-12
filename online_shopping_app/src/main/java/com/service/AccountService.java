package com.service;

import com.exception.BusinessException;
import com.shop.model.Account;

public interface AccountService {


	public int createAccount(Account account) throws BusinessException;
	public int updateAccount(int id,long contact)throws BusinessException;
	public int deleteAccount(int id)throws BusinessException;
}
