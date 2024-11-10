import java.sql.*;

    public class _4_UpdateJDBC {
    public static void main(String[] args) throws ClassNotFoundException{

        // Variables
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prateek@8810";
        String query = "UPDATE employees SET job_title = 'ReactJs Developer', Salary = 50000 WHERE ID = 102;";

        try{
            Class.forName("com.sql.jdbc.Driver");   // Loading Drivers for connecting database
            System.out.println("Driver Loaded successfully!");
        }
        catch (ClassNotFoundException e){   // forName() -> Yeah method Exception deta hai isi liye try-catch ka use kiya hai
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, username, password);  // Connecting Database
            System.out.println("Connection establish successfully!!!");
            Statement stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);   // executeUpdate() -> Jab data Insert/Update/Delete karna hota hai tab yeah method use hota hai

            if (rowsAffected>0){
                System.out.println("Update Successfully. "+rowsAffected+" row(s) affected.");
            }
            else{
                System.out.println("Update failed!");
            }

            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed Successfully!!!");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}


