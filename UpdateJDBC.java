import java.sql.*;

    public class UpdateJDBC {
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prateek@8810";
        String query = "UPDATE employees SET job_title = 'ReactJs Developer', Salary = 50000 WHERE ID = 102;";

        try{
            Class.forName("com.sql.jdbc.Driver");
            System.out.println("Driver Loaded successfully!");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection establish successfully!!!");
            Statement stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

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


