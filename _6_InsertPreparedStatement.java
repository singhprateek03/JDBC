import java.sql.*;
import java.util.Scanner;

public class _6_InsertPreparedStatement {
        public static void main(String[] args) {
            // Variables
            String url = "jdbc:mysql://localhost:3306//mydatabase";
            String username = "root";
            String password = "prateek@8810";
            String query = "INSERT INTO employees(id, name, job_title, salary) VALUES (?,?,?,?)";  // ? -> Placeholder

            try{
                Class.forName("com.sql.jdbc.Driver");   // Loading Drivers for connecting database
                System.out.println("Drivers loaded successfully!");
            }
            catch(ClassNotFoundException e){    // forName() -> Yeah method Exception deta hai isi liye try-catch ka use kiya hai
                System.out.println(e.getMessage());
            }

            try{
                Connection con = DriverManager.getConnection(url, username, password);
                System.out.println("Connection established successfully!");
                Scanner sc = new Scanner(System.in);
                
                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter job title: ");
                String job_title = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                PreparedStatement preparedStatement = con.prepareStatement(query);   // prepareStatement() method -> yeah SQL ki prepared query ko run karwane ke liye use hota hai
                preparedStatement.setInt(1,id);  // setString() -> yeah database main VARCHAR datatype ko insert karta hai
                                                                  // 1 indicates position and "Henry" indicate to name
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,job_title);
                preparedStatement.setDouble(4, salary);

                int rowsAffected = preparedStatement.executeUpdate();   // executeUpdate() -> yeah hume batata hai ki kitne rows affect hue hai
                if (rowsAffected > 0){
                    System.out.println("Data Inserted successfully"+rowsAffected+"row(s) affected.");
                }
                else{
                    System.out.println("Data insertion failed!!");
                }

                // Security increase karne ke liye (instance / Object) ko close kiya hai
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
