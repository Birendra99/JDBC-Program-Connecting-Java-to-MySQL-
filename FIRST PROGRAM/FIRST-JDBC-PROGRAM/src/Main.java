
import java.sql.*;

public class Main{
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            // Here we are loading Driver
            Class.forName("com.mysql.jdbc.Driver");
            // To check weather the driver is loaded successfully or not we have to print the statment
//            System.out.println("Driver Successfully Loaded.");

        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        String url="jdbc:mysql://localhost:3306/students";
        String username="root";
        String password="Devil@1999";// here you have to put your own mysqli workbench password.

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            // To check the database is connected or not to print the statement.
//            System.out.println("Connected successfully");
            Statement stmt=con.createStatement();
            ResultSet rst=stmt.executeQuery("Select *from class1;");
            while (rst.next()){
                int id=rst.getInt("id");
                String name=rst.getString("name");
                String section=rst.getString("section");
                double marks=rst.getDouble("marks");
                System.out.println("Id: "+id);
                System.out.println("Name: "+name);
                System.out.println("Section: "+section);
                System.out.println("Marks: "+marks);

            }
            rst.close();
            stmt.close();
            con.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}