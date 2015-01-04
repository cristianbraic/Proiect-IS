package com.journaldev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    @Column(name = "noan_nr")
	private int loanNr;

    @Column(name = "branch_name")
	private String branchName;

    @Column(name = "amount")
	private int amount;
	
	
	public int getLoanNr() {
		return loanNr;
	}
	public void setLoanNr(int loanNr) {
		this.loanNr = loanNr;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
