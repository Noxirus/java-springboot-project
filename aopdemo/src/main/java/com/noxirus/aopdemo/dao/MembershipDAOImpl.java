package com.noxirus.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addMember() {
        System.out.println("Adding Membership!");
    }

    @Override
    public int goToSleep() {
        System.out.println("Going to sleep for int amount of hours");

        return 0;
    }
}
