package com.example.demo.module.account;

import com.example.demo.module.account.form.AccountCreateForm;
import com.example.demo.module.account.form.AccountResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class AccountService {
    private final AccountMapper accountMapper;
    private final PasswordEncoder passwordEncoder;

    public Account createAccount(AccountCreateForm accountCreateForm) {
        Account foundAccount = accountMapper.getAccountByUsername(accountCreateForm.getUsername());
        if (foundAccount != null) {
            throw new IllegalArgumentException("중복된 아이디가 있습니다.");
        }
        if (accountCreateForm.getPassword().isEmpty()){
            throw new IllegalArgumentException("패스워드를 입력하세요");
        }

        Account sendAccount = Account.builder()
                .username(accountCreateForm.getUsername())
                .password(passwordEncoder.encode(accountCreateForm.getPassword()))
                .build();
        accountMapper.createAccount(sendAccount);
        return sendAccount;
    }

    public List<AccountResponseForm> getAccounts(){
        return accountMapper.getAccounts();
    }
}

