package ooga.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {

  Bank bank;

  @BeforeEach
  void setupBank() {
    bank = new BankAccount(50, 100);
  }

  @Test
  void getBalance() {
    int balance = bank.getBalance();
    assertEquals(50, balance);
  }

  @Test
  void increaseBalance() {
    assertEquals(50, bank.getBalance());
    bank.increaseBalance(50);
    assertEquals(100, bank.getBalance());
    bank.increaseBalance(-50);
    assertEquals(100, bank.getBalance());
  }

  @Test
  void decreaseBalance() {
    assertEquals(50, bank.getBalance());
    bank.decreaseBalance(20);
    assertEquals(30, bank.getBalance());
    bank.decreaseBalance(-50);
    assertEquals(30, bank.getBalance());
  }

  @Test
  void addEndOfRoundIncomeToBalance() {
    assertEquals(50, bank.getBalance());
    bank.addEndOfRoundIncomeToBalance();
    assertEquals(150, bank.getBalance());
  }
}