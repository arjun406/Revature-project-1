package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.exception.BusinessException;
import com.shop.model.Account;

public class AccountDAOImpl implements AccountDAO {
	private static final Logger log =Logger.getLogger(AccountDAOImpl.class);
	@Override
	public int createAccount(Account account) throws BusinessException {
		int accountUser = 0;
		// TODO Auto-generated method stub
		try(Connection connection =MySQLConnection.getConnection()){
			String sql="insert into account (name,email,password,phoneNumber,accountType) values(?,?,?,?,? )";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, account.getName());
			preparedStatement.setString(2, account.getEmail());
			preparedStatement.setString(3, account.getPassword());
			preparedStatement.setString(4, account.getPhoneNumber());
			preparedStatement.setString(5, account.getAccountType());
			
			
			
			accountUser=preparedStatement.executeUpdate();
			if (accountUser!=1)
			{
				throw new BusinessException("user creation failed!!!!....Please try Again");
			}
		} catch (ClassNotFoundException | SQLException e) {
		   log.error(e);
		   throw new BusinessException("Internal Error Occured contact SysAdmin");
		}
		
			return accountUser;
	}@Override
	public int updateAccount(int id, long contact) throws BusinessException {
		int c=0;
		try(Connection connection=MySQLConnection.getConnection())
		{
			String sql="Update account SET contact=? Where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setLong(1,contact);
			preparedStatement.setInt(2,id);
			c=preparedStatement.executeUpdate();
			if(c!=1)
			{
				throw new BusinessException("Not updated properly...");
			}
	
	}catch (ClassNotFoundException | SQLException e) {
		 log.error(e);
		throw new BusinessException("Internal Error occured Please contact support");
	}
	return c;
	}
	@Override
	public int deleteAccount(int id) throws BusinessException {
		int c=0;
		try(Connection connection=MySQLConnection.getConnection())
		{
			String sql="Delete from account where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
		    c=preparedStatement.executeUpdate();
		    if(c!=1)
		    {
		    	throw new BusinessException("Deletion does not happens..");
		    }
	
	}
		catch (ClassNotFoundException | SQLException e) {
			log.error(e);;
			throw new BusinessException("Internal Error occured Please contact support");
		}
		return c;


	}

}
