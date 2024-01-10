public class Main {

  public static void main(String[] args) throws InterruptedException {
    Database database = new Database();
    String john = "John";
    String jane = "Jane";
    database.createAccount(john);
    database.createAccount(jane);

    database.deposit(100, john);
    database.deposit(200, jane);
    database.deposit(300, john);

    database.withdraw(10, jane);
    database.withdraw(150, jane);
    database.withdraw(250, john);
  }
}