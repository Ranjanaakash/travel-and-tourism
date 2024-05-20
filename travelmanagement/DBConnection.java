 
package travelmanagement;

import java.sql.*;

 
public class DBConnection {
    Connection conn;
    Statement stmt;
    DBConnection(){
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
       conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Akash");
       stmt= conn.createStatement();
           // System.out.println("Connection established Successfully");
        }catch(Exception e){
            e.printStackTrace();
    }
    }
    public static void main(String[] args) {
        
    }
}
