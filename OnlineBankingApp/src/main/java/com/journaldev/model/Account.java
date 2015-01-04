package com.journaldev.model;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @Column(name = "acc_number")
	private int accNumber;

    @Column(name = "branch_name")
	private String branchName;

    @Column(name = "balance")
	private int balance;
	
	
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
