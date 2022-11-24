package com.Woo3Kim.log_inUp;

public class SecurityAccountService implements UserDetailsService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    	SecurityAccount account = new SecurityAccount(accountMapper.getAccountById(id));
    	return account;
    }
}