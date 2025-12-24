Bank Management System
Technology Used: Java, JDBC, MySQL, SQL, PreparedStatement, DAO Pattern
Features:
       Create new bank accounts with an initial deposit.
       Deposit and withdraw money securely.
       Check account balance anytime.
       Transaction logging ensuring data consistency.
       Secure database operations using PreparedStatement to prevent SQL injection.
       DAO pattern for clean separation of database operations and business logic.
Project Structure:
DBConnection.java – Manages database connection.
Account.java – Represents account entity with attributes and methods.
BankDAO.java – Interface defining bank operations.
BankDAOImpl.java – Implements DAO interface using JDBC queries.
MainApp.java – Main class providing console-based user interface.
Sample Output:
    Welcome to Bank Management System

1. Create Account
2. Deposit Amount
3. Withdraw Amount
4. Check Balance
5. Exit

Enter your choice: 1
Enter account holder name: Shathees
Enter initial deposit: 5000
Account created successfully with ID: 101

Enter your choice: 2
Enter account ID: 101
Enter amount to deposit: 2000
Amount deposited successfully. New balance: 7000

Enter your choice: 3
Enter account ID: 101
Enter amount to withdraw: 1500
Amount withdrawn successfully. New balance: 5500

Enter your choice: 4
Enter account ID: 101
Current balance: 5500

Enter your choice: 5
Thank you for using the Bank Management System!
