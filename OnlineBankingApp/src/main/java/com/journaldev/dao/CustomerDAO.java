package com.journaldev.dao;

import com.journaldev.model.Customer;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public interface CustomerDAO {

    public void save(Customer account);

    public List<Customer> list();
}
