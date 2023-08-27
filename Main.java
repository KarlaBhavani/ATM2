package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bk = new Bank();
        bk.createAccount("20201", 2000);
        bk.createAccount("77889", 1000);

        System.out.println("Welcome to ATM");
        System.out.println("Enter Account Number: ");
        String accountNumber = sc.next();
        if (bk.accountExist(accountNumber)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\nATM:");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter amount to withdraw:");
                        double withdrawAmount = sc.nextDouble();
                        if (withdrawAmount <= bk.checkBalance(accountNumber)) {
                            bk.withdraw(accountNumber, withdrawAmount);
                            System.out.println("Successfully withdrawn amount from your account..");
                        } else {
                            System.out.println("Insufficient Balance...");
                        }
                        break;
                    case 2:
                        System.out.println("enter account number: ");
                        double depositAmount = sc.nextDouble();
                        bk.deposit(accountNumber, depositAmount);
                        System.out.println("successfully amount deposited");
                        break;
                    case 3:
                        double balance = bk.checkBalance(accountNumber);
                        System.out.println("Your balance is: " + balance);
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using the ATM");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } else {
            System.out.println("Account not found");
        }
    }
}