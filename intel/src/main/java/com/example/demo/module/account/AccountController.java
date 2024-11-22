package com.example.demo.module.account;

import com.example.demo.module.account.form.AccountCreateForm;
import com.example.demo.module.account.form.AccountResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/api/common/account")
    public ResponseEntity<?> createAccount(@RequestBody AccountCreateForm accountCreateForm) {
        try {
            Account account = accountService.createAccount(accountCreateForm);

            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", String.valueOf(account.getId()));
            hashMap.put("username", account.getUsername());

            return ResponseEntity.ok(hashMap);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/api/member/account") //일반 유저는 접근할 수 없음 옵션?
    public ResponseEntity<?> getAccounts(){
        List<AccountResponseForm> responseForms = accountService.getAccounts();
        return ResponseEntity.ok(responseForms);
    }
}
