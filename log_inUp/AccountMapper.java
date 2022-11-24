package com.Woo3Kim.log_inUp;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper
{
  Account getAccountById(String id);
  void insertAccount(Account account);
}