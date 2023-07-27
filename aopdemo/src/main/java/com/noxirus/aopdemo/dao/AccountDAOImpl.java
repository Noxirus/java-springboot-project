package com.noxirus.aopdemo.dao;

import com.noxirus.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;


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
