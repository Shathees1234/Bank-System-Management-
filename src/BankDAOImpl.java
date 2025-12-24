import java.sql.*;

public class BankDAOImpl implements BankDAO {

    @Override
    public void createAccount(String name, double balance) {
        String sql = "INSERT INTO account(name,balance) VALUES(?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setDouble(2, balance);
            ps.executeUpdate();
            System.out.println("Account created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(int accNo, double amount) {
        String update = "UPDATE account SET balance = balance + ? WHERE acc_no = ?";
        String insertTx = "INSERT INTO transaction(acc_no,type,amount) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps1 = con.prepareStatement(update);
                 PreparedStatement ps2 = con.prepareStatement(insertTx)) {

                ps1.setDouble(1, amount);
                ps1.setInt(2, accNo);
                ps1.executeUpdate();

                ps2.setInt(1, accNo);
                ps2.setString(2, "DEPOSIT");
                ps2.setDouble(3, amount);
                ps2.executeUpdate();

                con.commit();
                System.out.println("Deposit successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdraw(int accNo, double amount) {
        String check = "SELECT balance FROM account WHERE acc_no=?";
        String update = "UPDATE account SET balance = balance - ? WHERE acc_no=?";
        String insertTx = "INSERT INTO transaction(acc_no,type,amount) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            PreparedStatement psCheck = con.prepareStatement(check);
            psCheck.setInt(1, accNo);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next() && rs.getDouble("balance") >= amount) {

                PreparedStatement ps1 = con.prepareStatement(update);
                ps1.setDouble(1, amount);
                ps1.setInt(2, accNo);
                ps1.executeUpdate();

                PreparedStatement ps2 = con.prepareStatement(insertTx);
                ps2.setInt(1, accNo);
                ps2.setString(2, "WITHDRAW");
                ps2.setDouble(3, amount);
                ps2.executeUpdate();

                con.commit();
                System.out.println("Withdrawal successful");
            } else {
                System.out.println("Insufficient balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkBalance(int accNo) {
        String sql = "SELECT balance FROM account WHERE acc_no=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Balance: " + rs.getDouble("balance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
