package com.journaldev.dao;

import com.journaldev.model.Employee;

import java.util.List;

/**
 * Created by Braic on 1/3/2015.
 */
public interface EmployeeDAO {

    public void save(Employee account);

    public List<Employee> list();
}
