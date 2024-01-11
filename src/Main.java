public class Main {

  public static void main(String[] args) throws InterruptedException {
    Database database = new Database();
    String john = "John";
    String michael = "Michael";
    String bob = "Bob";
    database.createAccount(john);
    database.createAccount(michael);
    database.createAccount(bob);

    database.deposit(100, john);
    database.deposit(200, michael);
    database.deposit(300, john);
    database.deposit(150, bob);

    database.withdraw(10, michael);
    database.withdraw(150, michael);
    database.withdraw(250, john);
    database.withdraw(50, bob);
    database.withdraw(100, bob);
  }
}