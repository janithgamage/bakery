
package Interface;
import Class.invoice.InvoiceData;
import Class.invoice.InvoiceDesign;
import Class.invoice.Items;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import mycode.DBconnect;
import javax.swing.table.DefaultTableModel;
import mycode.DbConnection;
import mycode.Validation;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Janith Chathuranga
 */
public class Invoice extends javax.swing.JInternalFrame {

        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rst=null;
        DefaultTableModel model;
        Validation v=new Validation();
        String errorMeassage="";
    /**
     * Creates new form Invoice
     */
    public Invoice() {
        initComponents();
         conn=DBconnect.connect();
       // table();
        showDate();
        fill_combo();
        combo();
        tbill.setText("0");
       loadinvoice();
       model= (DefaultTableModel) invoice_table.getModel();
//sum();
       //tbill.setText(Integer.toString(getSum()));
    }
    
   /* public void tabale()
    {
       String q="Select * from Invoice";
        try {
            pst=conn.prepareStatement(q);
            rst=pst.executeQuery();
            invoice_table.setModel(DbUtils.resultSetToTableModel(rst));
        } catch (Exception e) {
        }
    
    }*/
   
      public void fill_combo()
{
    try {
        String q="Select * from order_header where status='n'";
        pst=conn.prepareStatement(q);
         rst=pst.executeQuery();
         
         while(rst.next())
         {
           String id=rst.getString("order_no");
           ordern.addItem(id);
           
         }
    } catch (Exception e) {
    }

}
 
      public void loadinvoice(){
       
        
        DbConnection con=new DbConnection();
          try {
              rst=con.select("select Invoice_No from invoice order by Invoice_No desc;");
              if(rst.next())
              {
                 invoice_no.setText(String.valueOf(rst.getInt("Invoice_No")+1));
              }
              else
              {
              invoice_no.setText("1");
              }
          } catch (Exception e) {
              con.close();
          }
    }
    
    
    public void combo()
    {
        try {
            String q="Select * from cashier";
            pst=conn.prepareStatement(q);
            rst=pst.executeQuery();
            
            while(rst.next())
            {
             String cid=rst.getString("id");
             cashier_no.addItem(cid);
             
            }
                
            
        } catch (Exception e) {
        }
    
    }
    
    
    
void showDate()
            {
                Date d=new Date();
                SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
                Invoice_date.setText(s.format(d));
                
            
            }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pro_name = new javax.swing.JTextField();
        qua = new javax.swing.JTextField();
        Invoice_date = new javax.swing.JTextField();
        cashier_name = new javax.swing.JTextField();
        ordern = new javax.swing.JComboBox<>();
        cashier_no = new javax.swing.JComboBox<>();
        tbill = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoice_table = new javax.swing.JTable();
        invoice_no = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setTitle("Create_Invoice");
        setPreferredSize(new java.awt.Dimension(845, 514));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Order_No");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Customer_NIC");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Order_Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Invoice_No");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Invoice_Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Cashier_Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Cashier_No");

        cashier_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashier_nameActionPerformed(evt);
            }
        });

        ordern.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Order_No" }));
        ordern.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ordernPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        ordern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordernActionPerformed(evt);
            }
        });

        cashier_no.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Cashier_No" }));
        cashier_no.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cashier_noPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        tbill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbillMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Total Bill_Amount");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Remove_Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setText("Print_Invoice");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        invoice_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_No", "Name", "Quantity", "Unit Price", "Total"
            }
        ));
        jScrollPane1.setViewportView(invoice_table);

        invoice_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        invoice_no.setText("jLabel8");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Create_Invoice");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ordern, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(invoice_no, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cashier_name, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                            .addComponent(cashier_no, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(pro_name, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(Invoice_date, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(qua, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 4, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbill, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel5)
                        .addComponent(cashier_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Invoice_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(invoice_no, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ordern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cashier_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pro_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tbill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(116, 116, 116))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean Validateinput()
    {
     errorMeassage="";
        if(!v.requiredFieldValidator(cashier_name))
        {
           errorMeassage=errorMeassage+"\ncashier Name should not be empty";
        }
     
         if(!v.lengthValider(pro_name,10,10))
        {
           errorMeassage=errorMeassage+"\nNIC between 1-10";
        }
         if(errorMeassage.equals(""))
         {return true;
         }
         else{return false;}
    
    
    
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ordernPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ordernPopupMenuWillBecomeInvisible
       
       
    }//GEN-LAST:event_ordernPopupMenuWillBecomeInvisible

    private void cashier_noPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cashier_noPopupMenuWillBecomeInvisible
        String temp=(String)cashier_no.getSelectedItem();
        String q="Select * from cashier where id=?";
        try {
            pst=conn.prepareStatement(q);
            pst.setString(1, temp);
            rst=pst.executeQuery();
            while(rst.next())
            {
             String pname=rst.getString("name");
             cashier_name.setText(pname);
             
            }
        } catch (Exception e) {JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_cashier_noPopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       DefaultTableModel model;
        model = (DefaultTableModel) invoice_table.getModel();
        try
        {
            int row = invoice_table.getSelectedRow();
            model.removeRow(row);
        }
        catch (Exception ex)
        {

        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbillMouseClicked
   
    }//GEN-LAST:event_tbillMouseClicked

    private void ordernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordernActionPerformed
        if(ordern.getSelectedIndex()!=0){
            ResultSet rst2;
            ResultSet rst3;
            double price=0;
            String name="";
            DefaultTableModel model;
            try {
                String q="select * from order_header where order_no='"+ordern.getSelectedItem().toString()+"';";
                pst=conn.prepareStatement(q);
                rst=pst.executeQuery();
                if(rst.next()){
                    pro_name.setText(rst.getString("customer_Nic"));
                    qua.setText(rst.getString("date"));
                    q="select * from order_details where orderno='"+ordern.getSelectedItem().toString()+"';";
                    pst=conn.prepareStatement(q);
                    rst2=pst.executeQuery();
                    while(rst2.next()){
                        //JOptionPane.showMessageDialog(rootPane, rst2.getString("productNo"));
                        model = (DefaultTableModel) invoice_table.getModel();
                        q="select price,name from product where id='"+rst2.getString("productNo")+"';";
                        pst=conn.prepareStatement(q);
                        rst3=pst.executeQuery();
                        if(rst3.next()){
                            price=rst3.getDouble("price");
                            name=rst3.getString("name");
                        }//calculation the toal bill
                        tbill.setText(String.valueOf(Double.parseDouble(tbill.getText())+price*Double.parseDouble(rst2.getString("quantity"))));
                        model.addRow(new Object[]{rst2.getString("productNo"),name, rst2.getString("quantity"),price, price*Double.parseDouble(rst2.getString("quantity"))});
                    }
                    
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "asdasdas");
        }
    }//GEN-LAST:event_ordernActionPerformed

    private void cashier_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashier_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashier_nameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int counter=0;
        //String invoic_no=invoice_no.getText();
       String order_no=ordern.getSelectedItem().toString();
       String cname=cashier_name.getText();
       String date=qua.getText();
       String tot=tbill.getText();
       JOptionPane.showMessageDialog(this, "Invoice Created");
        try {
             String q="insert into invoice (Order_No,Cashier_Name,Date,Total) values ('"+ order_no +"','"+ cname +"','"+ date +"','"+ tot +"')";
          // sending data to invoice table
            pst=conn.prepareStatement(q);
            pst.execute();
            while(counter<invoice_table.getRowCount())
            {
                q="update product set quantity=quantity-'"+invoice_table.getValueAt(counter, 2).toString()+"' where id='"+invoice_table.getValueAt(counter, 0).toString()+"'";
                 pst=conn.prepareStatement(q);
            //reducing from product quantiy
                 pst.execute();
                 counter++;
            }
                   //changing only the data where status to yes
                   String q1="update order_header set status='y' where order_no='"+ ordern.getSelectedItem().toString() +"'";
                   pst=conn.prepareStatement(q1);
                   pst.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());

        }
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        List<Items> items = new ArrayList<Items>();
//        InvoiceData invoiceData = new InvoiceData();
//        int counter=0;
//       
//        while(counter<invoice_table.getRowCount())
//            {
//                items.add(invoiceData.createItem(invoice_table.getValueAt(counter, 0).toString(),invoice_table.getValueAt(counter, 1).toString(), Integer.parseInt(invoice_table.getValueAt(counter, 2).toString()), new BigDecimal(Double.parseDouble(invoice_table.getValueAt(counter, 3).toString()))));
//                 counter++;
//            }
//        
//        invoiceData.setItems(items);
//        
//        invoiceData.setDate(Invoice_date.getText());
//        invoiceData.setiNo(Integer.parseInt(invoice_no.getText()));
//        invoiceData.setoNo(Integer.parseInt(ordern.getSelectedItem().toString()));
//        invoiceData.setItems(items);
//        invoiceData.createInvoice();
//        InvoiceDesign design = new InvoiceDesign(invoiceData);
//        design.design();  

try{
    JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("invoice.jrxml"));
    JRDesignQuery newQuery = new JRDesignQuery();
	newQuery.setText("SELECT order_details.quantity, product.name, product.price,order_details.quantity*product.price\n" +
"FROM order_details\n" +
"INNER JOIN product ON product.id=order_details.productNo WHERE order_details.orderno='"+ordern.getSelectedItem().toString()+"'");
        jd.setQuery(newQuery);
	JasperReport jr = JasperCompileManager.compileReport(jd);
	JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
	JasperViewer.viewReport(jp, false);	
}
catch(Exception e){
    System.out.println("Error in Jasper");
    System.out.println(e.getMessage());
    }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Invoice_date;
    private javax.swing.JTextField cashier_name;
    private javax.swing.JComboBox<String> cashier_no;
    private javax.swing.JLabel invoice_no;
    private javax.swing.JTable invoice_table;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> ordern;
    private javax.swing.JTextField pro_name;
    private javax.swing.JTextField qua;
    private javax.swing.JTextField tbill;
    // End of variables declaration//GEN-END:variables
}
