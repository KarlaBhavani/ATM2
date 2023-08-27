package org.example;
import java.util.HashMap;
import java.util.Map;

public class Bank {
 private Map<String, Double> accounts = new HashMap<>();
 public void createAccount(String accountNumber, double Balance) {
  accounts.put(accountNumber, Balance);
 }
 public boolean accountExist(String accountNumber){
  return accounts.containsKey(accountNumber);
 }
 public void withdraw(String accountNumber,double amount){
  double totalAmount = accounts.get(accountNumber);
  accounts.put(accountNumber, totalAmount - amount);
 }
 public void deposit(String accountNumber,double amount) {
  double currentBalance = accounts.get(accountNumber);
  accounts.put(accountNumber, currentBalance + amount);
 }
 public Double checkBalance(String accountNumber){
 return accounts.get(accountNumber);
 }

}
