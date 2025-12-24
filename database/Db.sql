CREATE DATABASE bankdb;

USE bankdb;

CREATE TABLE account (
    acc_no INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    balance DOUBLE
);

CREATE TABLE transaction (
    tx_id INT PRIMARY KEY AUTO_INCREMENT,
    acc_no INT,
    type VARCHAR(20),
    amount DOUBLE,
    tx_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (acc_no) REFERENCES account(acc_no)
);
