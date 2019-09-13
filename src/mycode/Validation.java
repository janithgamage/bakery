
package mycode;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Janith Chathuranga
 */
public class Validation {

  public boolean requiredFieldValidator(JTextField component)// empty textbox
  {
      if(component.getText().equals(""))
      {
        return false;
      
      }
      else
          return true;
  
  }
  
 /** public boolean SelectedIndex(JTextField component)
  {
      if(component.getText().equals(""))
      {
        return false;
      
      }
      else
          return true;
  
  }*/
  
  public boolean lengthValider(JTextField component, int min,int max)//max min check
  {
      if(component.getText().length()>=min&&component.getText().length()<=max)
      {
          return true;
      }
   else 
          return false;
}
  
 
  
 public boolean rangeValider(JTextField component, int min,int max)//range(age 10-100);;
  { try {
          
      if(Integer.parseInt(component.getText())>=min&&Integer.parseInt(component.getText())<=max)
      {
          return true;
      }
   else 
          return false;
      } catch (NumberFormatException e)
      {
          return false;
          
      }
  }
 
 
 
 public boolean numericValidator(JTextField component)//only numbers
 {
     try {
         if(Integer.parseInt(component.getText())>=0)
         {
             return true;
         }
         else
             return false;
         
     } catch (NumberFormatException e) 
     {
         //JOptionPane.showMessageDialog(null, e);
        return false; 
     }
     
 }
 
 
}

