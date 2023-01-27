package com.bridgelabz.Account;

public class Accounts {
    private double balance;

    public Accounts(double balance) {
        this.balance = balance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}