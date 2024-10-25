import javax.xml.transform.Result;
import java.sql.*;

public class PreparedStatementJDBC {
    public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306//mydatabase";
    String username = "root";
    String password = "prateek@8810";
    String query = "SELECT * FROM employees WHERE name = ? AND job_title = ?";

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Drivers loaded successfully!");
    }
    catch(ClassNotFoundException e){
        System.out.println(e.getMessage());
    }

    try{
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully!");
        Statement statement = con.createStatement();    // createStatement() method -> Yeah SQL ki simple query ko run karwane main help karta hai

        PreparedStatement preparedStatement = con.prepareStatement(query);   // prepareStatement() method -> yeah SQL ki prepared query ko run karwane ke liye use hota hai
        preparedStatement.setString(1,"Henry");
        preparedStatement.setString(2,"Java Developer");
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String job_title = resultSet.getString("job_title");
            double salary = resultSet.getDouble("salary");

            System.out.println("ID: "+id);
            System.out.println("Name: "+name);
            System.out.println("Job_title: "+job_title);
            System.out.println("salary: "+salary);
        }
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
