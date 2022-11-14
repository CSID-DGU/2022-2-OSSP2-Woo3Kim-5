package com.Woo3Kim.log_inUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public void join(Account account)
	{
		accountMapper.insertAccount(account);
	}
}