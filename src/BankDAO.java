public interface BankDAO {
    void createAccount(String name, double balance);
    void deposit(int accNo, double amount);
    void withdraw(int accNo, double amount);
    void checkBalance(int accNo);
}
