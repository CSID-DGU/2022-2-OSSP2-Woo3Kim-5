package com.Woo3Kim.log_inUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ctrl
{
	
	@Autowired
	AccountServiceImpl accountService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String goLogin()
	{
		return "login";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String goJoin()
	{
		return "join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String login(Account account)
	{
		accountService.join(account);
		return "login";
	}
}