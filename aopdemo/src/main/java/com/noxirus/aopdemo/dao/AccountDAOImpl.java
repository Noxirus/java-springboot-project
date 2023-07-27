package com.noxirus.aopdemo.dao;

import com.noxirus.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println("Adding Account");
    }
}
