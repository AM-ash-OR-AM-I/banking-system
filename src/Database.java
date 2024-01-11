import java.util.ArrayList;

enum TransactionType {
  DEPOSIT,
  WITHDRAW
}

public class Database {
  ArrayList<Account> accounts;

  Database() {
    accounts = new ArrayList<>();
  }

  void createAccount(String name) {
    Account account = new Account(name);
    accounts.add(account);
  }

  void deposit(int amount, String name) throws InterruptedException {
    for (Account account : accounts) {
      if (account.name.equals(name)) {
        // Create a new thread to deposit
        Util.log("Transaction type: %s, amount: %d, User: %s".formatted(TransactionType.DEPOSIT, amount, name));
        ThreadDeposit transaction = new ThreadDeposit(account, amount);
        transaction.start();
      }
    }
  }

  void withdraw(int amount, String name) throws InterruptedException {
    for (Account account : accounts) {
      if (account.name.equals(name)) {
        // Create a new thread to withdraw
        Util.log("Transaction type: %s, amount: %d, User: %s".formatted(TransactionType.WITHDRAW, amount, name));
        ThreadWithdraw transaction = new ThreadWithdraw(account, amount);
        transaction.start();
      }
    }
  }

}