package com.example.demo.module.auth;

import com.example.demo.module.account.Account;
import com.example.demo.module.account.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class AuthUserDetails implements UserDetailsService {
    private final AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountMapper.getAccountByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException("사용자 찾지 못함");
        }

        return new User(account.getUsername(), account.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_MEMBER")));
    }
}
