/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import mycode.DBconnect;
import mycode.Validation;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Janith Chathuranga
 */
public class get_item extends javax.swing.JInternalFrame {
Connection conn=null;
PreparedStatement pst=null;
ResultSet rst=null;
Validation v=new Validation();
String errorMeassage="";
    /**
     * Creates new form get_item
     */
    public get_item() {
        initComponents();
        conn=DBconnect.connect();
        table();
        fill_combo();
    }
public void table()
    {
        try {
         String sql= "SELECT * FROM get_item";
         pst=conn.prepareStatement(sql);
         rst=pst.executeQuery();
         
         get_item.setModel(DbUtils.resultSetToTableModel(rst));
         
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
public void fill_combo()
{
    try {
        String q="Select * from item";
        pst=conn.prepareStatement(q);
         rst=pst.executeQuery();
         
         while(rst.next())
         {
           String id=rst.getString("id");
           c1.addItem(id);
           
         }
    } catch (Exception e) {
    }

}
 public boolean validateInputs()
    {
        errorMeassage="";
       
     
        if(!v.requiredFieldValidator(i1))
       {
          errorMeassage=errorMeassage+"\n Item Name should not be empty";
       }
        
         if(!v.requiredFieldValidator(i2))
        {
           errorMeassage=errorMeassage+"\n Item quantity should not be empty";
        }
        
         if(errorMeassage.equals(""))
         {return true;
         }
         else{return false;}
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
        c1 = new javax.swing.JComboBox<>();
        i1 = new javax.swing.JTextField();
        i2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        get_item = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Get_Item");
        setPreferredSize(new java.awt.Dimension(845, 494));

        jPanel1.setPreferredSize(new java.awt.Dimension(845, 494));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Item_No");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 60, 70, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Item_Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 130, 90, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setText("Item_Quantity");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 200, 110, 17);

        c1.setBackground(new java.awt.Color(255, 204, 51));
        c1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        c1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item" }));
        c1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                c1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });
        jPanel1.add(c1);
        c1.setBounds(170, 50, 180, 30);
        jPanel1.add(i1);
        i1.setBounds(170, 120, 180, 30);
        jPanel1.add(i2);
        i2.setBounds(170, 190, 180, 30);

        get_item.setModel(new javax.swing.table.DefaultTableModel(
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
        get_item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                get_itemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(get_item);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(370, 50, 452, 230);

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Add-item-icon.png"))); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 330, 160, 40);

        jButton2.setBackground(new java.awt.Color(255, 204, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/-Close-icon.png"))); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(110, 400, 160, 40);

        jButton4.setBackground(new java.awt.Color(255, 204, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Shopping-basket-remove-icon.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(220, 330, 160, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/yellow_background_by_originalpsdcom-d6wbg8x.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 845, 494);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_c1PopupMenuWillBecomeInvisible
        String temp=(String)c1.getSelectedItem();
        String sql= "select * from item where id=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, temp);
            rst=pst.executeQuery();
            if(rst.next())
            {
             String add=rst.getString("name");
             i1.setText(add);
             
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_c1PopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        if(validateInputs()){
            
            if(c1.getSelectedIndex()==0){
            
         JOptionPane.showMessageDialog(null, "Please Selcet a Item Number");
      
            }else{
       String id=c1.getSelectedItem().toString();
       String name=i1.getText();
       String quan=i2.getText();
       String quano="";
        int tot=0;        
     
        try {
         
             String q = "INSERT INTO get_item (item_no,item_name,item_quantity) values ('"+ id +"','"+ name +"','"+ quan +"')";
             pst=conn.prepareStatement(q);
             pst.execute();
            
          //JOptionPane.showMessageDialog(this, "1 queery run");//200
           
             String q2="Select * from item";
             pst=conn.prepareStatement(q2);
             rst=pst.executeQuery(q2);
              while(rst.next())
             {
                quano=rst.getString("quantity");  //5000
          
            } 
              //JOptionPane.showMessageDialog(this, "2 queery run");
            int y=Integer.parseInt(quano); 
            int x=Integer.parseInt(quan);
            
            
            if(x>y)
            {
                JOptionPane.showMessageDialog(null, "quantity is not available");
            }
            else{
                    
                       int to=Integer.parseInt(quano)-Integer.parseInt(quan);
                        tot=to;
             String q3="update item set quantity = '"+ tot +"' where id = '"+ id +"'";
             pst=conn.prepareStatement(q3);
             pst.executeUpdate();
             //JOptionPane.showMessageDialog(this, "3 queery run");
                    }
             table();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
           
            }
        } else
         JOptionPane.showMessageDialog(this,errorMeassage,"InvalideDate",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         int c=JOptionPane.showConfirmDialog(null, "Do you really want to Cancel");
        if(c==0)
        {
           this.dispose();
          
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int q=JOptionPane.showConfirmDialog(null, "Do you really wants to Delete");
       if(q==0){
           String id=c1.getSelectedItem().toString();
           try {
               String s="Delete from get_item where item_no = '"+ id +"'";
               pst=conn.prepareStatement(s);
               pst.execute();
               table();
           } catch (Exception e) {
           }
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void get_itemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_get_itemMouseClicked
        int y=get_item.getSelectedRow();
        String no=get_item.getValueAt(y, 0).toString();
        String name=get_item.getValueAt(y, 1).toString();
        String quan=get_item.getValueAt(y, 2).toString();
       
        
        c1.setSelectedItem(no);
        i1.setText(name);
        i2.setText(quan);
       
    }//GEN-LAST:event_get_itemMouseClicked

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> c1;
    private javax.swing.JTable get_item;
    private javax.swing.JTextField i1;
    private javax.swing.JTextField i2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
