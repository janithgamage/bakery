
package Class;

import javax.swing.JOptionPane;
import mycode.DbConnection;

/**
 *
 * @author Janith
 */
public class Item {
    String id;
    String name;
    String quantity;
    String price;

    public Item(String no, String name, String qua, String pri) {
         this.id=no;
         this.name=name;
         this.quantity=qua;
         this.price=pri;
    }

    public Item(String no) {
          
        this.id=no;
    
    }
    
    
    public boolean additem()
     {
        boolean status=false;
         try {
             DbConnection con=new DbConnection();
             String q="INSERT INTO item (id,name,quantity,price) values ('"+ id +"', '"+ name +"', '"+ quantity +"', '"+ price +"')";
             status=con.insert(q);
         } catch (Exception e) {
         }
         return status;
     }
    
    
    
    public boolean updatitem()
    {
     boolean status=false;
        try {
            DbConnection con=new DbConnection();
            String q="Update item set name = '"+ name +"', quantity = '"+ quantity +"', price = '"+ price +"' where id = '"+ id +"'";
            status=con.insert(q);
  
        } catch (Exception e) {
        }   return status;
    }
    
    
    
    public boolean deletitem()
    {
      boolean status=false;
        try {
            DbConnection con=new DbConnection();
            String q="Delete from item where id = '"+ id +"'";
            status=con.insert(q);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
 
         
      return status;  
    }
    
}

