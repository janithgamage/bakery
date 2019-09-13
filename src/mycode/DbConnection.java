/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycode;

import com.mysql.jdbc.CommunicationsException;
//import com.mysql.jdbc.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;


/**
 *
 * @author Janith Chathuranga
 */
public class DbConnection {
    
   private Connection con;
   private Statement st;
   private ResultSet rs;
   
   public DbConnection()
   {try
   {
   Class.forName("com.mysql.jdbc.Driver");
   con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/bakery","root","");
   st=con.createStatement();
   
   }catch(CommunicationsException ex){
            System.out.println("Check Your Internet Connection");
            JOptionPane.showMessageDialog(null,"Please Check Your Connection !!","Connection Error",ERROR_MESSAGE);
            
        }catch(SQLException | ClassNotFoundException ex){
            
        }
   }
     public void close(){
        try {
            con.close();
        } catch (SQLException ex)
        {

        }
    }
    public boolean insert(String query) throws SQLException {
        st.executeUpdate(query);
        return true;
    }
    public boolean delete(String query) throws SQLException{
        st.executeUpdate(query);
        return true;
    }
    public boolean update(String query) throws SQLException{
        st.executeUpdate(query);
        return true;
    }
    public ResultSet select(String query) throws SQLException {
        rs=st.executeQuery(query);
        return rs;
    }

   
    
}

   
   
   
   
   
    

