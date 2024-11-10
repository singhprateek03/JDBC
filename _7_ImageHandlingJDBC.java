import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class _7_ImageHandlingJDBC {
    public static void main(String[] args){

        // Variables
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prateek@8810";
        String image_path = "D:\\HTML\\images\\Calendar.jpeg";
        String query = "INSERT INTO image_table(image_data) VALUES(?);";    // ? -> Placeholder

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
            FileInputStream  fileInputStream = new FileInputStream(image_path);   // FileInputStream -> Yeah image file ko binary file main convert kar deti hai
            // Array -> Yeah image convert hone ke baad ke data ko store karega
            byte[] imageData = new byte[fileInputStream.available()]; // fileInputStream.available() -> Yeah array ke max size batayega
            fileInputStream.read(imageData); // read() -> Yeah imageData ko store karega
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setBytes(1,imageData);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0){
                System.out.println("Image Insertion successful "+affectedRows+" row(s) affected.");
            }
            else{
                System.out.println("Image Insertion failed!");
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