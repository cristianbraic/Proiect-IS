package com.journaldev.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Braic on 1/3/2015.
 */

@Embeddable
@Table(name = "Depositor")
public class Depositor {

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "acc_number")
    private int accNumber;
}
