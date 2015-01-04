-- Created by Vertabelo (http://vertabelo.com)
-- Script type: create
-- Scope: [tables, references, sequences, views, procedures]
-- Generated at Mon Dec 29 12:48:59 UTC 2014




-- tables
-- Table: Account
CREATE TABLE Account (
    acc_number int  NOT NULL,
    branch_name varchar(20)  NOT NULL,
    balance int  NOT NULL,
    CONSTRAINT Account_pk PRIMARY KEY (acc_number)
);



-- Table: Borrower
CREATE TABLE Borrower (
    customer_name varchar(35)  NOT NULL,
    loan_nr int  NOT NULL
);



-- Table: Branch
CREATE TABLE Branch (
    branch_name varchar(20)  NOT NULL,
    branch_city varchar(20)  NOT NULL,
    assets int  NOT NULL,
    CONSTRAINT branch_name UNIQUE (branch_name) NOT DEFERRABLE  INITIALLY IMMEDIATE ,
    CONSTRAINT Branch_pk PRIMARY KEY (branch_name,branch_city)
);



-- Table: Customer
CREATE TABLE Customer (
    customer_name varchar(35)  NOT NULL,
    customer_street varchar(60)  NOT NULL,
    customer_city varchar(20)  NOT NULL,
    customer_login varchar(20)  NOT NULL,
    customer_password varchar(20)  NOT NULL,
    client_email varchar(60)  NULL,
    CONSTRAINT customer_name UNIQUE (customer_name) NOT DEFERRABLE  INITIALLY IMMEDIATE ,
    CONSTRAINT Customer_pk PRIMARY KEY (customer_login)
);



-- Table: Depositor
CREATE TABLE Depositor (
    customer_name varchar(35)  NOT NULL,
    acc_number int  NOT NULL
);



-- Table: Employee
CREATE TABLE Employee (
    employee_name varchar(35)  NOT NULL,
    employee_email varchar(60)  NOT NULL,
    employee_login varchar(20)  NOT NULL,
    employee_password varchar(20)  NOT NULL,
    CONSTRAINT Employee_pk PRIMARY KEY (employee_login)
);



-- Table: Loan
CREATE TABLE Loan (
    loan_nr int  NOT NULL,
    branch_name varchar(20)  NOT NULL,
    amount int  NOT NULL,
    CONSTRAINT Loan_pk PRIMARY KEY (loan_nr)
);







-- foreign keys
-- Reference:  Account_Depositor (table: Depositor)


ALTER TABLE Depositor ADD CONSTRAINT Account_Depositor 
    FOREIGN KEY (acc_number)
    REFERENCES Account (acc_number)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  Branch_Account (table: Account)


ALTER TABLE Account ADD CONSTRAINT Branch_Account 
    FOREIGN KEY (branch_name)
    REFERENCES Branch (branch_name)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  Branch_Loan (table: Loan)


ALTER TABLE Loan ADD CONSTRAINT Branch_Loan 
    FOREIGN KEY (branch_name)
    REFERENCES Branch (branch_name)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  Customer_Borrower (table: Borrower)


ALTER TABLE Borrower ADD CONSTRAINT Customer_Borrower 
    FOREIGN KEY (customer_name)
    REFERENCES Customer (customer_name)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  Customer_Depositor (table: Depositor)


ALTER TABLE Depositor ADD CONSTRAINT Customer_Depositor 
    FOREIGN KEY (customer_name)
    REFERENCES Customer (customer_name)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;

-- Reference:  Loan_Borrower (table: Borrower)


ALTER TABLE Borrower ADD CONSTRAINT Loan_Borrower 
    FOREIGN KEY (loan_nr)
    REFERENCES Loan (loan_nr)
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE 
;






-- End of file.

