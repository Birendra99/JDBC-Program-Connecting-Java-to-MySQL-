import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/students";
        String username="root";
        String password="Devil@1999";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        String query="UPDATE class1 set section='A' WHERE id=1";
//        String query="INSERT INTO class1(id,name,section,marks)values(1,'Birendra','F',88.9)";

        try{
            Connection con=DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            int noOfRows=stmt.executeUpdate(query);
            if(noOfRows>0){
                System.out.println("Updation Successfully "+noOfRows+"row(s) affected.");
            }
            else {
                System.out.println("Updation Failed");
            }
            stmt.close();
            con.close();


        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}