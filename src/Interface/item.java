
package Interface;

import Class.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import mycode.DBconnect;
import mycode.DbConnection;
import mycode.Validation;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Janith Chathuranga
 */
public class item extends javax.swing.JInternalFrame {
Connection conn=null;
PreparedStatement pst=null;
ResultSet rst=null;
Validation v=new Validation();
String errorMeassage="";
    /**
     * Creates new form item
     */
    public item() {
        initComponents();
        conn=DBconnect.connect();
        table();
    }
public void table()
    {
        try {
         String sql= "SELECT * FROM item";
         DbConnection con=new DbConnection();
         rst=con.select(sql);
         
         itable.setModel(DbUtils.resultSetToTableModel(rst));
         
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        I_no = new javax.swing.JTextField();
        I_quan = new javax.swing.JTextField();
        I_price = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itable = new javax.swing.JTable();
        I_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(845, 494));

        jPanel1.setPreferredSize(new java.awt.Dimension(845, 494));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Item_No");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 80, 90, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Item_Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 140, 100, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setText("Item_Quantity");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 200, 120, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setText("Item_Price");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 260, 80, 17);
        jPanel1.add(I_no);
        I_no.setBounds(200, 70, 180, 30);
        jPanel1.add(I_quan);
        I_quan.setBounds(200, 190, 180, 30);
        jPanel1.add(I_price);
        I_price.setBounds(200, 250, 180, 30);

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Add-item-icon.png"))); // NOI18N
        jButton1.setText("Add_to_Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(60, 320, 160, 50);

        jButton2.setBackground(new java.awt.Color(255, 204, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/system-software-update-icon.png"))); // NOI18N
        jButton2.setText("Update_Stock");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(250, 320, 160, 50);

        jButton3.setBackground(new java.awt.Color(255, 204, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Shopping-basket-remove-icon.png"))); // NOI18N
        jButton3.setText("Delete_Stock");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(60, 390, 160, 50);

        jButton4.setBackground(new java.awt.Color(255, 204, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/-Close-icon.png"))); // NOI18N
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(250, 390, 160, 50);

        itable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        itable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(390, 70, 452, 230);
        jPanel1.add(I_name);
        I_name.setBounds(200, 130, 180, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/yellow_background_by_originalpsdcom-d6wbg8x.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 845, 530);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     public boolean validateInputs()
    {
        errorMeassage="";
       
        if(!v.requiredFieldValidator(I_no))
        {
           errorMeassage=errorMeassage+"\nItem_No should not be empty";
        }
        if(!v.requiredFieldValidator(I_name))
       {
          errorMeassage=errorMeassage+"\nName should not be empty";
       }
         if(!v.requiredFieldValidator(I_quan))
        {
           errorMeassage=errorMeassage+"\nQuantity should not be empty";
        }
         if(!v.requiredFieldValidator(I_price))
        {
           errorMeassage=errorMeassage+"\nPrice should not be empty";
        }
        
         if(errorMeassage.equals(""))
         {return true;
         }
         else{return false;}
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               
         if(validateInputs()){
                String no=I_no.getText();
                String name=I_name.getText();
                String qua=I_quan.getText();
                String pri=I_price.getText();
            
               try{
        String y="INSERT INTO item (id,name,quantity,price) values ('"+ no +"','"+ name +"','"+ qua +"', '"+ pri +"')";
        pst = conn.prepareStatement(y);
        pst.execute();
        
        table();
        JOptionPane.showMessageDialog(null, "success");
        
        }catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }
        
         }else
         JOptionPane.showMessageDialog(this,errorMeassage,"InvalideDate",JOptionPane.ERROR_MESSAGE);    
       I_no.setText("");
       I_name.setText("");
       I_price.setText("");
       I_quan.setText("");
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      int v=JOptionPane.showConfirmDialog(null, "Do you really want to Update");
        if(v==0){
             if(validateInputs()){
               String no=I_no.getText();
                String name=I_name.getText();
                String qua=I_quan.getText();
                String pri=I_price.getText();
        
        JOptionPane.showMessageDialog(null,"updated ");
        try {
            String q="Update item set  name = '"+ name +"', quantity = '"+ qua +"', price = '"+ pri +"' where id = '"+ no +"'";
            pst=conn.prepareStatement(q);
            pst.execute();
            table();
        } catch (Exception e) {
        } }else
         JOptionPane.showMessageDialog(this,errorMeassage,"InvalideDate",JOptionPane.ERROR_MESSAGE);  
        }
       I_no.setText("");
       I_name.setText("");
       I_price.setText("");
       I_quan.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void itableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itableMouseClicked
        int y=itable.getSelectedRow();
        String no=itable.getValueAt(y, 0).toString();
        String name=itable.getValueAt(y, 1).toString();
        String quan=itable.getValueAt(y, 2).toString();
        String price=itable.getValueAt(y, 3).toString();
        
        I_no.setText(no);
      I_name.setText(name);
        I_quan.setText(quan);
        I_price.setText(price);
        
    }//GEN-LAST:event_itableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       // String no=I_no.getText();
       
         String no=I_no.getText();
        int y=JOptionPane.showConfirmDialog(null, "Do you really want to Delete");
        if(y==0)
        {
            try {
                 String q="Delete from item where id = '"+ no +"'";
                 pst=conn.prepareStatement(q);
                 pst.execute();
                 table();
                 JOptionPane.showMessageDialog(null, "Success");
            } catch (Exception e) {
            }
        }
       I_no.setText("");
    //   I_name.setText("");
       I_price.setText("");
       I_quan.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int y= JOptionPane.showConfirmDialog(null, "Do you really want to Cancel");
        if(y==0)
        {this.dispose();}
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField I_name;
    private javax.swing.JTextField I_no;
    private javax.swing.JTextField I_price;
    private javax.swing.JTextField I_quan;
    private javax.swing.JTable itable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
