package com.journaldev.main;

import java.util.List;

import com.journaldev.dao.*;
import com.journaldev.model.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//PersonDAO personDAO = context.getBean(PersonDAO.class);
        BranchDAO branchDAO = context.getBean(BranchDAO.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
        EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);

        Branch branch = new Branch();
        branch.setBranchName("Barcelona");
        branch.setAssets(500000);
        branch.setBranchCity("Madrid");

        Account account = new Account();
        account.setAccNumber(1205);
        account.setBalance(500);
        account.setBranchName("Barcelona");

        Customer customer = new Customer();
        customer.setCustomerCity("Madrid");
        customer.setCustomerEmail("cev@ceva.com");
        customer.setCustomerLogin("madalin");
        customer.setCustomerPassword("trala");
        customer.setCustomerName("madalin maruta");

        Employee employee = new Employee();
        employee.setEmployeeLogin("admin");
        employee.setEmployeePassword("admin");
        employee.setEmployeeEmail("caca@caca.com");
        employee.setEmployeeName("caca");

        branchDAO.save(branch);
        accountDAO.save(account);
        customerDAO.save(customer);
        employeeDAO.save(employee);
		//personDAO.save(person);
		
		context.close();
		
	}

}
