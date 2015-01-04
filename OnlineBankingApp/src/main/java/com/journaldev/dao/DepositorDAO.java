package com.journaldev.dao;

import com.journaldev.model.Depositor;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public interface DepositorDAO {

    public void save(Depositor account);

    public List<Depositor> list();
}
