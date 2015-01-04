package com.journaldev.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Braic on 1/3/2015.
 */

@Embeddable
@Table(name = "Borrower")
public class Borrower {

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "loan_nr")
    private int loanNr;
}
