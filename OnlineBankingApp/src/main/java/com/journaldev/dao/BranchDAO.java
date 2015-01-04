package com.journaldev.dao;

import com.journaldev.model.Branch;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public interface BranchDAO {

    public void save(Branch account);

    public List<Branch> list();
}
