import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class _8_RetrieveImageHandlingJDBC {
        public static void main(String[] args){

            // Variables
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "prateek@8810";
            String folder_path = "D:\\Java\\JDBC\\";
            String query = "SELECT image_data from image_table WHERE image_id=(?)";    // ? -> Placeholder

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
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, 1);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){  // next() -> Yeah jab tak data aata rahega tab tak true rahega
                    // Array
                    byte[] image_data = resultSet.getBytes("image_data");   // yeah image ko byte[] image_data se image_data main extract karega

                    // Yaha pe hum image ka naam set kar rahe hai folder ke ander dalne ke liye
                    String image_path = folder_path + "extracedImage.jpg";

                    OutputStream outputStream = new FileOutputStream(image_path);  // OutputStream -> yeah image ko bytes se image format main store karega
                    outputStream.write(image_data); // write() -> Yeah image_data se data ko nikal ke image_path main write karega
                    System.out.println("Image retrieving successfully");
                }
                else{
                    System.out.println("Image not found!");
                }
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
            catch (FileNotFoundException e){       // this is thrown by FileInputStream
                throw new RuntimeException(e);
            }
            catch (IOException e){          // this is aslo thrown by FileInputStream
                throw new RuntimeException(e);
            }
        }
}
