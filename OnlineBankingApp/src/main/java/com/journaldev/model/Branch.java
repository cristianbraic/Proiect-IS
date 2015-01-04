package com.journaldev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Branch")
public class Branch implements Serializable {

    @Id
    @Column(name = "branch_name")
	private String branchName;

    @Id
    @Column(name = "branch_city")
	private String branchCity;

    @Column(name = "assets")
	private int assets;
	
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchCity() {
		return branchCity;
	}
	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}
	public int getAssets() {
		return assets;
	}
	public void setAssets(int assets) {
		this.assets = assets;
	}

}
