
package mycode;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Janith Chathuranga
 */
public class DBconnect {
    public static Connection connect()
    {
         Connection conn=null;
         try
         {
              Class.forName("com.mysql.jdbc.Driver");
              conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery","root","");
         }
         catch(Exception e)
         {
             System.out.print(e);
         }
         
         
         return conn;
    }
}
