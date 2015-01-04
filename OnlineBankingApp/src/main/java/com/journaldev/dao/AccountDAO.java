package com.journaldev.dao;

import com.journaldev.model.Account;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public interface AccountDAO {

    public void save(Account account);

    public List<Account> list();
}
