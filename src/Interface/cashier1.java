
package Interface;

import Class.cashier;
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
public class cashier1 extends javax.swing.JInternalFrame {
 
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rst=null;
    Validation v=new Validation();
    String errorMeassage="";
    
    public cashier1() {
        initComponents();
        conn=DBconnect.connect();
        table();
    }
public void table()
    {
        try {
         String sql= "SELECT * FROM cashier";
         pst=conn.prepareStatement(sql);
         rst=pst.executeQuery();
         
         customer.setModel(DbUtils.resultSetToTableModel(rst));
         
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customer = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));
        setTitle("Cashier register");
        setPreferredSize(new java.awt.Dimension(845, 494));

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Id");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 50, 30, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 100, 50, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setText("Age");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 150, 40, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setText("Address");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 200, 60, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setText("Tel");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 250, 60, 30);
        jPanel1.add(t1);
        t1.setBounds(180, 40, 190, 30);
        jPanel1.add(t2);
        t2.setBounds(180, 90, 190, 30);

        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });
        jPanel1.add(t3);
        t3.setBounds(180, 140, 190, 30);
        jPanel1.add(t4);
        t4.setBounds(180, 190, 190, 30);
        jPanel1.add(t5);
        t5.setBounds(180, 240, 190, 30);

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/user-add-icon.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(60, 320, 160, 40);

        jButton2.setBackground(new java.awt.Color(255, 204, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/system-software-update-icon.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(270, 320, 180, 40);

        jButton3.setBackground(new java.awt.Color(255, 204, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/remove-icon.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(60, 380, 160, 40);

        jButton4.setBackground(new java.awt.Color(255, 204, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/-Close-icon.png"))); // NOI18N
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(270, 380, 180, 40);

        customer.setModel(new javax.swing.table.DefaultTableModel(
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
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customer);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(380, 40, 430, 230);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Go-back-icon.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(70, 10, 70, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/yellow_background_by_originalpsdcom-d6wbg8x.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 845, 494);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
        public boolean validateInputs()
    {
        errorMeassage="";
        if(!v.requiredFieldValidator(t1))
        {
           errorMeassage=errorMeassage+"\nId should not be empty";
        }
        if(!v.numericValidator(t1))
        {
        errorMeassage=errorMeassage+"\nId should be numeric";
        }
        if(!v.requiredFieldValidator(t2))
        {
           errorMeassage=errorMeassage+"\nName should not be empty";
        }
         if(!v.requiredFieldValidator(t3))
        {
           errorMeassage=errorMeassage+"\nAge should not be empty";
        }
          if(!v.numericValidator(t3))
        {
           errorMeassage=errorMeassage+"\nAge should  be numeric";
        }
           if(!v.rangeValider(t3,10,99))
        {
           errorMeassage=errorMeassage+"\nAge between 10-99";
        }if(!v.requiredFieldValidator(t4))
        {
           errorMeassage=errorMeassage+"\nAddress should not be empty";
        }
         if(!v.numericValidator(t5))
        {
           errorMeassage=errorMeassage+"\nTel should  be numeric";
        }
         if(!v.lengthValider(t5,10,10))
        {
           errorMeassage=errorMeassage+"\nTel between 1-10";
        }
         if(errorMeassage.equals(""))
         {return true;
         }
         else{return false;}
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int c=JOptionPane.showConfirmDialog(null, "Do you really want to Cancel");
        if(c==0)
        {
           this.dispose();
          
        }
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
      
        if(validateInputs()){

            String id = t1.getText();
            String name = t2.getText();
            String age =t3.getText();
            String add =t4.getText();
            String tel = t5.getText();

            try{
                String y="INSERT INTO cashier (id,name,age,address,tel) values ('"+ id +"', '"+ name +"','"+ age +"', '"+ add +"', '"+ tel +"')";
                pst = conn.prepareStatement(y);
                pst.execute();

                table();
                JOptionPane.showMessageDialog(null, "success");

            }catch(Exception e){}

        }else
        JOptionPane.showMessageDialog(this,errorMeassage,"InvalideDate",JOptionPane.ERROR_MESSAGE);
   
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int v=JOptionPane.showConfirmDialog(null, "Do you really want to Update");
        if(v==0){
             if(validateInputs()){
        String id = t1.getText();
        String name = t2.getText();
        String age =t3.getText();
        String add =t4.getText();
        String tel = t5.getText();
        
        JOptionPane.showMessageDialog(null,"updated ");
        try {
            String q="Update cashier set name = '"+ name +"', age = '"+ age +"', address = '"+ add +"', tel = '"+ tel +"' where id = '"+ id +"'";
            pst=conn.prepareStatement(q);
            pst.execute();
            table();
        } catch (Exception e) {
        } }else
         JOptionPane.showMessageDialog(this,errorMeassage,"InvalideDate",JOptionPane.ERROR_MESSAGE);  
        }
  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseClicked
        int y=customer.getSelectedRow();
        String id=customer.getValueAt(y, 0).toString();
        String name=customer.getValueAt(y, 1).toString();
        String age=customer.getValueAt(y, 2).toString();
        String add=customer.getValueAt(y, 3).toString();
        String tel=customer.getValueAt(y, 4).toString();
        
        t1.setText(id);
        t2.setText(name);
        t3.setText(age);
        t4.setText(add);
        t5.setText(tel);
    }//GEN-LAST:event_customerMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String id=t1.getText();
        int y=JOptionPane.showConfirmDialog(null, "Do you really want to Delete");
        if(y==0)
        {
            try {
                 String q="Delete from cashier where id = '"+ id +"'";
                 pst=conn.prepareStatement(q);
                 pst.execute();
                 table();
                 JOptionPane.showMessageDialog(null, "Success");
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.dispose();
        //Manager m=new Manager();
        //m.setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable customer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    // End of variables declaration//GEN-END:variables
}
