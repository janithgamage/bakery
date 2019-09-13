/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashs;

import Interface.Login;

/**
 *
 * @author kavin
 */
public class Splashs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        screen obr = new screen();
        obr.setVisible(true);
        
        try{
        
        for(int i = 0; i<=100; i++)
        {
           Thread.sleep(35);
        obr.Loadlbl.setText(Integer.toString(i)+"%");
        obr.Loading.setValue(i);
        
        if(i==100){
        obr.setVisible(false);
        Login l1 = new Login();
        l1.setVisible(true);
        
        }
        
        }
        
           }catch (Exception e){
                              
                               }
        
        
        
        
        
    }
    
}
