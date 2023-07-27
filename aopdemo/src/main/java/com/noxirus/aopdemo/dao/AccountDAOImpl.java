package com.noxirus.aopdemo.dao;

import com.noxirus.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;


    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        myAccounts.add(new Account("Fred", "Level 2"));
        myAccounts.add(new Account("Samly", "Level 1"));
        myAccounts.add(new Account("Aletia", "Level 34"));

        return myAccounts;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println("Adding Account\n");
    }

    @Override
    public boolean doWork() {
        System.out.println("Doing work");

        return false;
    }

    public String getName() {
        System.out.println("Getting Name: " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("Setting Name");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("Getting Service Code: " + serviceCode);
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("Setting Service Code");
        this.serviceCode = serviceCode;
    }
}
