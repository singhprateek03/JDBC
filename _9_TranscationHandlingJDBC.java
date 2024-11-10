import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class _9_TranscationHandlingJDBC {
        public static void main(String[] args){

            // Variables
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "prateek@8810";
            String withdrawQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            String depositQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";


            try{
                Class.forName("com.sql.jdbc.Driver");   // Loading Drivers for connecting database
                System.out.println("Driver Loaded successfully!");
            }
            catch (ClassNotFoundException e){   // forName() -> Yeah method Exception deta hai isi liye try-catch ka use kiya hai
                System.out.println(e.getMessage());
            }

            try {
                Connection con = DriverManager.getConnection(url, username, password);  // Connecting Database
                System.out.println("Connection establish successfully!!!");
                con.setAutoCommit(false);    // setAutoCommit() -> Yah transaction ko by default true rakhta hai

                try {
                    PreparedStatement withdrawStatement = con.prepareStatement(withdrawQuery);
                    PreparedStatement depositStatement = con.prepareStatement(depositQuery);

                    withdrawStatement.setDouble(1, 500.00);
                    withdrawStatement.setString(2, "account123");

                    depositStatement.setDouble(1, 500.00);
                    depositStatement.setString(2, "account456");

                    int rowsAffectedWithdraw = withdrawStatement.executeUpdate();
                    int rowsAffectedDeposit = depositStatement.executeUpdate();
                    if (rowsAffectedWithdraw > 0 && rowsAffectedDeposit > 0) {  // dono main changes hoga toh commit ho jayega nhi toh rollback
                        con.commit();   // Transaction Handling
                        System.out.println("Transaction successful.");
                    }
                    else {
                        con.rollback();     // Agar transaction fail hue toh woo rollback ho jayegi
                        System.out.println("Transaction failed!");
                    }
                }
                catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
}
