
package Class;

import java.sql.SQLException;
import mycode.DbConnection;

/**
 *
 * @author Janith Chathuranga
 */
public class suplier {
    String id;
    String name;
    String age;
    String add;
    String tel;

    public suplier(String id,String name, String age, String add, String tel) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.add=add;
        this.tel=tel;
       
    }

    public suplier(String id) {
       this.id=id;
    }
    
    
    public boolean addnewSupplier()
    {
        boolean status=false;
        try 
        {
            DbConnection con =new DbConnection();
            String query;
            query= "INSERT INTO supplier (id,name,age,address,tel) values ('"+ id +"','"+ name +"', '"+ age +"', '"+ add +"', '"+ tel +"')";
            status=con.insert(query);
        } catch (SQLException e) 
        {
        }
        return status;
    }
    
    public boolean updatesupplier()
    {
     boolean status=false;
        try 
        {
            DbConnection con =new DbConnection();
            String query;
            query= "update supplier set name = '"+ name +"' ,age = '"+ age +"' ,address = '"+ add +"' ,tel = '"+ tel +"' where id = '"+ id +"'";
            status=con.insert(query);
        } catch (SQLException e) 
        {
        }
        return status;
    
    
    }
    
     public boolean deletesupplier()
    {
     boolean status=false;
        try 
        {
            DbConnection con =new DbConnection();
            String query;
            query= "DELETE  FROM supplier Where id = '"+ id +"'";
            status=con.insert(query);
        } catch (SQLException e) 
        {
        }
        return status;
}
}