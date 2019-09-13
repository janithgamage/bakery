/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import mycode.DBconnect;
import net.proteanit.sql.DbUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Janith Chathuranga
 */
public class purchase_order extends javax.swing.JInternalFrame {
Connection conn=null;
PreparedStatement pst=null;
ResultSet rst=null;
 int ono;
    ArrayList iNo;
    ArrayList qty;
   int sid;
   String date;
 DefaultTableModel model;
 Properties emailProperties;
Session mailSession;
MimeMessage emailMessage;
    /**
     * Creates new form purchase_order
     */
    public purchase_order() {
        initComponents();
         conn=DBconnect.connect();
       // table();
        showDate();
        fill_combo();
        combo();
        loadPurchaseOrderNumber();
         model = (DefaultTableModel) jTable1.getModel();
    }

   /* public void table()
    {
        try {
         String sql= "SELECT * FROM purchase_order";
         pst=conn.prepareStatement(sql);
         rst=pst.executeQuery();
         
         jTable1.setModel(DbUtils.resultSetToTableModel(rst));
         
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    
    }*/
    
    	public void setMailServerProperties() {

		String emailPort = "587";//gmail's smtp port

		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");

	}
        String x="asd";
        int y=5;

	public void createEmailMessage() throws AddressException,
			MessagingException {
            String email=Email.getText();
		String[] toEmails = {"jayakodimalith@gmail.com"};
		String emailSubject = "Purchase Order";
		String emailBody = "<H1>Hey man find the below image</H1><img src=\"C://Users//Malith//Pictures//Wallpapers//BB//bb.jpg\">";

		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");//for a html email
//		emailMessage.setText(emailBody);// for a text email

	}

	public void sendEmail() throws AddressException, MessagingException {

		String emailHost = "smtp.gmail.com";
		String fromUser = "teamnewroyalbakery@gmail.com";//just the id alone without @gmail.com
		String fromUserEmailPassword = "royalg07";

		Transport transport = mailSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		JOptionPane.showMessageDialog(null, "Email Send Successfully !!");
	}
   
     public void loadPurchaseOrderNumber(){
       
        //java.lang.System.out.println("lol");
        try{
            String q="select pOrderNo from purchase_order_header order by pOrderNo desc;";
            pst=conn.prepareStatement(q);
            rst=pst.executeQuery();
            java.lang.System.out.println("l");
            if(rst.next()){
                java.lang.System.out.println("l");
                lbl_po.setText(String.valueOf(rst.getInt("pOrderNo")+1));
                java.lang.System.out.println("l");
            }
            else
                lbl_po.setText("1");
            
        }
        catch(SQLException ex){java.lang.System.out.println("l");
            
           
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
           pcombo.addItem(id);
           
         }
    } catch (Exception e) {
    }

}
    public void combo()
    {
        try {
            String q="Select * from supplier";
            pst=conn.prepareStatement(q);
            rst=pst.executeQuery();
            
            while(rst.next())
            {
             String sid=rst.getString("id");
             sup_id.addItem(sid);
            }
                
            
        } catch (Exception e) {
        }
    
    }
     
     void showDate()
            {
                Date d=new Date();
                SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
                lbl_date.setText(s.format(d));
                
            
            }
     
    public void setData(DefaultTableModel model){
       int rows=model.getRowCount();
       int counter=0;
       while(counter<rows){
         // String Ino= pcombo.getSelectedItem().toString();
           iNo.add(model.getValueAt(counter, 0));
           qty.add(model.getValueAt(counter, 2));
           counter++;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pcombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        i_name = new javax.swing.JTextField();
        i_quantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        na = new javax.swing.JTextField();
        sup_id = new javax.swing.JComboBox<>();
        lbl_po = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        btn_remove = new javax.swing.JButton();
        btn_generate = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setTitle("Purchase_Order");
        setPreferredSize(new java.awt.Dimension(845, 494));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Purchase_Id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Suplier_Id");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Date");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Item_no");

        pcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item_No" }));
        pcombo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                pcomboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        pcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcomboActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Item_Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Quantity");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item_NO", "Item_Name", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Suplier_Name");

        sup_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Suplier_ID" }));
        sup_id.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                sup_idPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        lbl_po.setText("jLabel8");

        lbl_date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_date.setText("jLabel8");

        btn_remove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_remove.setText("Remove");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        btn_generate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_generate.setText("Generate Order");
        btn_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generateActionPerformed(evt);
            }
        });

        jLabel8.setText("Email");

        Email.setText("jLabel9");

        jButton3.setText("Generate Email");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Email)
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(i_name, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(170, 170, 170)
                                        .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(i_quantity)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sup_id, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_po, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(na, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_po, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(na, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(i_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(i_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sup_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Email))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(pcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_generate, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pcomboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_pcomboPopupMenuWillBecomeInvisible
        String temp=(String)pcombo.getSelectedItem();
        String sql= "select * from item where id=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, temp);
            rst=pst.executeQuery();
            if(rst.next())
            {
             String add=rst.getString("name");
             i_name.setText(add);
             //String quan=rst.getString("quantity");
             //i_quantity.setText(quan);
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_pcomboPopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
            DefaultTableModel model;
            model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{pcombo.getSelectedItem().toString(), i_name.getText(), i_quantity.getText()});
            
            pcombo.addItem(null);
            i_name.setText(null);
            i_quantity.setText(null); 
           
           
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void sup_idPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_sup_idPopupMenuWillBecomeInvisible
        String temp=(String)sup_id.getSelectedItem();
        String sql= "select * from supplier where id=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, temp);
            rst=pst.executeQuery();
            if(rst.next())
            {
             String name=rst.getString("name");
             na.setText(name);
             String email=rst.getString("email");
             Email.setText(email);
             //String quan=rst.getString("quantity");
             //i_quantity.setText(quan);
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_sup_idPopupMenuWillBecomeInvisible

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed

        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        try
        {
            int row = jTable1.getSelectedRow();
            model.removeRow(row);
        }
        catch (Exception ex)
        {

        }

    }//GEN-LAST:event_btn_removeActionPerformed

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateActionPerformed
    try {
        String pno=lbl_po.getText();
        String dat=lbl_date.getText();
        String sid=sup_id.getSelectedItem().toString();
        
        String q="Insert into purchase_order_header (pOrderNo,placeddate,supplier_Id) values('"+ pno +"','"+ dat +"','"+ sid +"')";
        pst=conn.prepareStatement(q);
        pst.execute();
        
        int rows = jTable1.getRowCount();
        int counter=0;
        while(counter<rows){
            String iNo = jTable1.getValueAt(counter, 0).toString();
            String qty = jTable1.getValueAt(counter, 2).toString();
            
            q="Insert into purchase_order_detail (pOrderId,iNo,qty) values('"+ pno +"','"+ iNo +"','"+ qty +"')";
            pst=conn.prepareStatement(q);
            pst.execute();  
            counter++;
        }
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    JOptionPane.showMessageDialog(this, "success");
    }//GEN-LAST:event_btn_generateActionPerformed

    private void pcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcomboActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String temp=(String)sup_id.getSelectedItem();
        String sql= "select * from purchase_order_detail where pOrderId=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, temp);
            rst=pst.executeQuery();
            if(rst.next())
            {
             String name=rst.getString("name");
             na.setText(name);
             String email=rst.getString("email");
             Email.setText(email);
             //String quan=rst.getString("quantity");
             //i_quantity.setText(quan);
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(null,e);
        } 
        // TODO add your handling code here:
        purchase_order javaEmail = new purchase_order();
	javaEmail.setMailServerProperties();
    try {
        javaEmail.createEmailMessage();
    } catch (MessagingException ex) {
        Logger.getLogger(purchase_order.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        javaEmail.sendEmail();
    } catch (MessagingException ex) {
        Logger.getLogger(purchase_order.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JButton btn_generate;
    private javax.swing.JButton btn_remove;
    private javax.swing.JTextField i_name;
    private javax.swing.JTextField i_quantity;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_po;
    private javax.swing.JTextField na;
    private javax.swing.JComboBox<String> pcombo;
    private javax.swing.JComboBox<String> sup_id;
    // End of variables declaration//GEN-END:variables
}
