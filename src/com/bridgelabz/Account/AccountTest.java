package com.bridgelabz.Account;

import java.util.Scanner;
class AccountTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        Accounts account = new Accounts(balance);
        System.out.print("Enter debit amount: ");
        double debitAmount = sc.nextDouble();
        account.debit(debitAmount);
        System.out.println("Current balance: " + account.getBalance());
        sc.close();
    }
}

