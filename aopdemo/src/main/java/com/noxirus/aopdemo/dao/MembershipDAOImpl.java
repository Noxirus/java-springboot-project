package com.noxirus.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {
        System.out.println("Adding Membership!");
    }
}
