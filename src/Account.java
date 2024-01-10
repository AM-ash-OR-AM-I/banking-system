public class Account implements AccountInterface {
  int balance;
  String name;

  final int SLEEP_TIME = 1200;

  Account(String name) {
    this.balance = 0;
    this.name = name;
    System.out.println("Account created for %s".formatted(name));
  }

  @Override
  synchronized public void deposit(int amount) {
    balance += amount;
    sleep(); // Simulate processing time
    displayTransactionDetails(balance, amount, TransactionType.DEPOSIT);
  }

  @Override
  synchronized public int withdraw(int amount) {
    if (balance >= amount) {
      balance -= amount;
    } else {
      return -1;
    }
    sleep(); // Simulate processing time
    displayTransactionDetails(balance, amount, TransactionType.DEPOSIT);
    return 0;
  }

  private void displayTransactionDetails(int balance, int amount, TransactionType type) {
    System.out.println("%s %s = %d, Balance = %d\n".formatted(name, type, amount, balance));
  }

  private void sleep() {
    try {
      Thread.sleep(SLEEP_TIME);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

// Creates a thread to withdraw money from the bank
class ThreadWithdraw extends Thread {
  Account account;
  int amount;

  ThreadWithdraw(Account account, int amount) {
    this.account = account;
    this.amount = amount;
  }

  public void run() {
    account.withdraw(amount);
  }

}

// Creates a thread to deposit money into the bank
class ThreadDeposit extends Thread {
  Account account;
  int amount;

  ThreadDeposit(Account account, int amount) {
    this.account = account;
    this.amount = amount;
  }

  public void run() {
    account.deposit(amount);
  }
}