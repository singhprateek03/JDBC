import java.sql.*;

public class _5_RetrievePreparedStatementJDBC {
    public static void main(String[] args) {
        // Variables
    String url = "jdbc:mysql://localhost:3306//mydatabase";
    String username = "root";
    String password = "prateek@8810";
    String query = "SELECT * FROM employees WHERE name = ? AND job_title = ?";  // ? -> Placeholder

        try{
            Class.forName("com.sql.jdbc.Driver");   // Loading Drivers for connecting database
            System.out.println("Driver Loaded successfully!");
        }
        catch (ClassNotFoundException e){   // forName() -> Yeah method Exception deta hai isi liye try-catch ka use kiya hai
            System.out.println(e.getMessage());
        }

    try{
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully!");
        Statement statement = con.createStatement();    // createStatement() method -> Yeah SQL query ko run karwane main help karta hai

        PreparedStatement preparedStatement = con.prepareStatement(query);   // prepareStatement() method -> yeah SQL ki prepared query ko run karwane ke liye use hota hai
        preparedStatement.setString(1,"Henry");  // setString() -> yeah database main VARCHAR datatype ko insert karta hai
                                                                 // 1 indicates position and "Henry" indicate to name
        preparedStatement.setString(2,"Java Developer");
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){  // resultSet.next() -> Yeah conditon ko true rakhega jab tak data rahega jese hee data khatam hoga yeah false ho jayega
            int id/* local variable */ = resultSet.getInt("id"/* Database field name */);    // getInt() -> isse hum id nikalange
            String name = resultSet.getString("name");  // getString() -> isse hum name nikalange
            String job_title = resultSet.getString("job_title");    // getString() -> isse hum job_title nikalange
            double salary = resultSet.getDouble("salary");  // getDouble() -> isse hum salary nikalange

            System.out.println("ID: "+id);
            System.out.println("Name: "+name);
            System.out.println("Job_title: "+job_title);
            System.out.println("salary: "+salary);
        }

        // Security increase karne ke liye (instance / Object) ko close kiya hai
        resultSet.close();
        preparedStatement.close();
        con.close();
        System.out.println();
        System.out.println("Connection closed successfully!");
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
    }

    }
}
