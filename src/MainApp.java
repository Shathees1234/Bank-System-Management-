import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        BankDAO dao = new BankDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();
                    dao.createAccount(name, bal);
                    break;

                case 2:
                    System.out.print("Acc No: ");
                    int depAcc = sc.nextInt();
                    System.out.print("Amount to Deposit: ");
                    double depAmt = sc.nextDouble();
                    dao.deposit(depAcc, depAmt);
                    break;

                case 3:
                    System.out.print("Acc No: ");
                    int witAcc = sc.nextInt();
                    System.out.print("Amount to Withdraw: ");
                    double witAmt = sc.nextDouble();
                    dao.withdraw(witAcc, witAmt);
                    break;

                case 4:
                    System.out.print("Acc No: ");
                    int balAcc = sc.nextInt();
                    dao.checkBalance(balAcc);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
