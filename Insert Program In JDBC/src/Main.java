import  java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/students";
        String username="root";
        String password="Devil@1999";
        String query="Insert into class1(id,name,section,marks)values(3,'Rita','A',66.66)";
        try{
            Class.forName("com.mysql.jdbc.driver");

        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            Statement stmt=con.createStatement();
            int noOfRow=stmt.executeUpdate(query);
            if(noOfRow>0){
                System.out.println("Inserted Successfully "+noOfRow+" row(s) affected.");
            }
            else {
                System.out.println("Insertion Failed.");
            }
            stmt.close();
            con.close();

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}