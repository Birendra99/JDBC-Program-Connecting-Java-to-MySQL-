import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Main{
    public static void main(String[] args) throws ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/students";
        String username="root";
        String password="Devil@1999";
        String query="Delete from class1 where id=2";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con= DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            int noOfRows=stmt.executeUpdate(query);

            if(noOfRows>0){
                System.out.println("Delete Successfully "+noOfRows+"()s"+" row affected.");
            }
            else {
                System.out.println("Deletion Failed.");
            }
            stmt.close();
            con.close();;


        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}