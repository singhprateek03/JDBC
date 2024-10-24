import java.sql.*;

public class RetrieveJDBC {
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prateek@8810";
        String query = "Select * from employees";

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
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");

                System.out.println("=========================================");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Job_title: "+job_title);
                System.out.println("Salary: "+salary);
            }
            rs.close();
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
