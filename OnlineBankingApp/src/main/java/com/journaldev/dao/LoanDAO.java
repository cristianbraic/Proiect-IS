package com.journaldev.dao;

import com.journaldev.model.Loan;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public interface LoanDAO {

    public void save(Loan account);

    public List<Loan> list();
}
