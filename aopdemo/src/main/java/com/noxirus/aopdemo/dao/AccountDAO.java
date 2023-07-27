package com.noxirus.aopdemo.dao;

import com.noxirus.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
