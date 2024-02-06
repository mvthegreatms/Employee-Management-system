import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    public conn(){

    //How to connect mysql
    //1. Register the Driver class
    //2. Creating the connection string
    //3. Creating statement
    //4. Executing mysql queries
    //5. Closing the connections
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mvdb","root","MVmath100@1234");
            s=c.createStatement();

        } catch(Exception e){
          e.printStackTrace();    //in which line error occurs
        }

//        try{
//            String driver="com.mysql.cj.jdbc.Driver";
//
//            String dbUrl="jdbc:mysql://localhost:3306/mvdb";
//            String username="root";
//            String password="MVmath100@1234";
//            Class.forName(driver);
//            Connection conn= DriverManager.getConnection(dbUrl,username,password);
//            System.out.println("Database connected");
//            return conn;
//        }
//        catch(Exception e){
//            System.out.println("some error");
//        }
//        return null;
    }
    public static void main(String[] args) {
        new conn();

    }
}
