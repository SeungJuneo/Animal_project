package com.example.demo.module.account;

import com.example.demo.module.account.form.AccountResponseForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Insert("INSERT INTO account(username, password) " +
            "VALUES (#{username}, #{password});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createAccount(Account account);

    @Select("Select * FROM account;")
    List<AccountResponseForm> getAccounts();

    @Select("Select * FROM account where username = #{username}")
    Account getAccountByUsername(String username);
}
