
Bank Management System
Technology Used: Java, JDBC, MySQL, SQL, PreparedStatement, DAO Pattern
Features
Create new bank accounts with an initial deposit.
Deposit and withdraw money securely.
Check account balance anytime.
Transaction logging ensuring data consistency.
Secure database operations using PreparedStatement to prevent SQL injection.
DAO pattern for clean separation of database operations and business logic.
Project Structure
DBConnection.java – Manages database connection.
Account.java – Represents account entity with attributes and methods.
BankDAO.java – Interface defining bank operations.
BankDAOImpl.java – Implements DAO interface using JDBC queries.
MainApp.java – Main class providing console-based user interface.
