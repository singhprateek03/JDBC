import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
    public static void main(String[] args){
        // Database URL
        String url = "jdbc:mysql://localhost:3306/student";

        //Database credential
        String username = "root";
        String password = "prateek@8810";

        // Establish the connection
        try(Connection connection = DriverManager.getConnection(url,username, password)){
            System.out.println("Database connected successfully.");

            // yeah connection ID batayega
            System.out.println(connection);

            // perform database opertion here
        }
        catch(SQLException e){
            System.out.println("Connection failed: "+e.getMessage());
        }
    }
}