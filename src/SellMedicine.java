
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Calendar;
import java.util.Date;
import dao.PharmacyUtils;
import java.io.FileOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apurb
 */
public class SellMedicine extends javax.swing.JFrame {
     public String numberPattern="^[0-9]*$";
     private int finalTotalPrice=0;
     private String billId="";
      private String username="";
    /**
     * Creates new form SellMedicine
     */
    public SellMedicine() {
        initComponents();
    }
     public SellMedicine(String tempUsername) {
        initComponents();
        username=tempUsername;
        setLocationRelativeTo(null);
    }
     
     private void medicineName (String nameOrUniqueId){
       DefaultTableModel model=(DefaultTableModel) medicineTable.getModel();
       model.setRowCount(0);
       try{
         Connection con =ConnectionProvider.getCon();
         Statement st=con.createStatement();
         ResultSet rs=st.executeQuery("select *from medicine where name like'"+nameOrUniqueId+"%'or uniqueId like '"+nameOrUniqueId+"%'");
         while(rs.next()){
             model.addRow(new Object[]{rs.getString("uniqueId")+"- "+rs.getString("name")});
         }
       
       }
       catch(Exception e){
          JOptionPane.showMessageDialog(null,e);
       }
       
     
     
     }
     private void clearMedicineFields(){
         txtUniqueId.setText("");
         txtName.setText("");
         txtCompanyName.setText("");
         txtPricePerUnit.setText("");
         txtNoOfUnits.setText("");
         txtTotalPrice.setText("");
     }
     
     public String getUniqueId(String prefix){
         return prefix + System.nanoTime();
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicineTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtUniqueId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPricePerUnit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        txtNoOfUnits = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("SELL  MEDICINE");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(392, 392, 392)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(119, 119, 119))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Search");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 36, -1, -1));

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 77, 329, 42));

        medicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Medicine"
            }
        ));
        medicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicineTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medicineTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 147, 490, 320));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Medicine ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 36, -1, -1));

        txtUniqueId.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jPanel2.add(txtUniqueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 77, 309, 42));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 198, -1, -1));

        txtName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 233, 309, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Company Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 342, -1, -1));

        txtCompanyName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jPanel2.add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 309, 38));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Price Per Unit");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, -1, -1));

        txtPricePerUnit.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtPricePerUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPricePerUnitActionPerformed(evt);
            }
        });
        jPanel2.add(txtPricePerUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(999, 240, 280, 38));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("No. of Units");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Total Price");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 350, -1, -1));

        txtTotalPrice.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jPanel2.add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 400, 260, 40));

        btnAddToCart.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAddToCart.setForeground(new java.awt.Color(204, 0, 0));
        btnAddToCart.setText("Add to cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 460, -1, -1));

        cartTable.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Name", "Company Name", "Price Per Unit", "No. of Quantity", "Total Price"
            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cartTable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 832, 160));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("RS:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 710, -1, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblFinalTotalPrice.setText("00");
        jPanel2.add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 710, 130, -1));

        txtNoOfUnits.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtNoOfUnits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoOfUnitsActionPerformed(evt);
            }
        });
        txtNoOfUnits.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoOfUnitsKeyReleased(evt);
            }
        });
        jPanel2.add(txtNoOfUnits, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 270, 40));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 0, 0));
        jButton2.setText("Purchase & Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 710, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPricePerUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPricePerUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPricePerUnitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    setVisible(false);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    medicineName("");
         txtUniqueId.setEditable(false);
         txtName.setEditable(false);
         txtCompanyName.setEditable(false);
         txtPricePerUnit.setEditable(false);
        // txtNoOfUnits.setEditable(true);
         txtTotalPrice.setEditable(false);
    
    // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
       String search=txtSearch.getText();
       medicineName(search);
       
       // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyReleased

    private void medicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicineTableMouseClicked
     int index=medicineTable.getSelectedRow();
     TableModel model=medicineTable.getModel();
     String nameOrUniqueId=model.getValueAt(index,0).toString();
     
     String uniqueId[]= nameOrUniqueId.split("-",0);
     try{
       Connection con=ConnectionProvider.getCon();
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select *from medicine where  uniqueId ="+uniqueId[0]+"");
       while (rs.next()){
           txtUniqueId.setText(uniqueId[0]);
           txtName.setText(rs.getString("name"));
           txtCompanyName.setText(rs.getString("companyName"));
           txtPricePerUnit.setText(rs.getString("price"));
           txtNoOfUnits.setText("");
           txtTotalPrice.setText("");
       }
       
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
     }
     
     
// TODO add your handling code here:
    }//GEN-LAST:event_medicineTableMouseClicked

    private void txtNoOfUnitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoOfUnitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoOfUnitsActionPerformed

    private void txtNoOfUnitsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoOfUnitsKeyReleased
        // TODO add your handling code here:\
        String noOfUnits=txtNoOfUnits.getText();
        if(!noOfUnits.equals("")){
            String price=txtPricePerUnit.getText();
         if(!noOfUnits.matches(numberPattern)){
           JOptionPane.showMessageDialog(null,"Number of units field is inavlid");  
         }
         int totalPrice=Integer.parseInt(noOfUnits) *Integer.parseInt(price);
         txtTotalPrice.setText(String.valueOf(totalPrice));
        }
        else{
            txtTotalPrice.setText("");
        }
        
    }//GEN-LAST:event_txtNoOfUnitsKeyReleased

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
     String noOfUnits=txtNoOfUnits.getText();
     String uniqueId=txtUniqueId.getText();

     if(!noOfUnits.equals("") && !uniqueId.equals("")){
      String name=txtName.getText();
      String companyName=txtCompanyName.getText();
      String totalPrice=txtTotalPrice.getText();
      String pricePerUnit=txtPricePerUnit.getText();
      int checkStock=0;
      int checkMedicineAlreadyExistInCart=0;
      try{
         Connection con=ConnectionProvider.getCon();
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("select *from medicine where  uniqueId ="+uniqueId+"");
       while (rs.next()){
           if(rs.getInt("quantity")>= Integer.parseInt(noOfUnits)){
               checkStock=1;
           }else{
             JOptionPane.showMessageDialog(null,"Medicine is out of stock.Only"+rs.getInt("quantity")+"Left");
           }
           
       }
      
      }
      catch(Exception e){
         JOptionPane.showMessageDialog(null,e); 
      }
     // TODO add your handling code here:
     if(checkStock==1){
         DefaultTableModel dtm=(DefaultTableModel) cartTable.getModel();
         if(cartTable.getRowCount()!=0){
             for(int i=0;i<cartTable.getRowCount();i++){
                 if(Integer.parseInt(dtm.getValueAt(i,0).toString())==Integer.parseInt(uniqueId)){
                   checkMedicineAlreadyExistInCart=1;
                   JOptionPane.showMessageDialog(null,"Medicine already exists in cart");
                 }
         }
     }
     if(checkMedicineAlreadyExistInCart==0){
         dtm.addRow(new Object[]{uniqueId,name,companyName,pricePerUnit,noOfUnits,totalPrice});
         finalTotalPrice=finalTotalPrice+Integer.parseInt(totalPrice);
         lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
         JOptionPane.showMessageDialog(null,"Added Successfully");
     }
     clearMedicineFields();
     }
     
     }else{
         JOptionPane.showMessageDialog(null,"No of units and Medicine ID field is required");
     }
     
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked
      int index=cartTable.getSelectedRow();
      int a=JOptionPane.showConfirmDialog(null,"Do you want to remove this medicine","Select",JOptionPane.YES_NO_OPTION);
      if (a==0){
        TableModel model=cartTable.getModel();
        String total = model.getValueAt(index,5).toString();
         finalTotalPrice=finalTotalPrice-Integer.parseInt(total);
        lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
        ((DefaultTableModel) cartTable.getModel()).removeRow(index);
// TODO add your handling code here:
    }//GEN-LAST:event_cartTableMouseClicked
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(finalTotalPrice!=0){
            billId=getUniqueId("Bill-");
            DefaultTableModel dtm=(DefaultTableModel)cartTable.getModel();
            if(cartTable.getRowCount()!=0){
                for  (int i =0;i<cartTable.getRowCount();i++){
                    try{
                      Connection con=ConnectionProvider.getCon();
                      Statement st=con.createStatement();
                      st.executeUpdate("update medicine set quantity=quantity-"+Integer.parseInt(dtm.getValueAt(i, 4).toString())+" where uniqueId="+Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                    
                    
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,e);
                    }
                    
                }
               
            
            }
            try{
            SimpleDateFormat myFormat=new SimpleDateFormat("dd-MM-yyy");
            Calendar cal=Calendar.getInstance();
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("insert into bill(billId,billDate,totalPaid,generatedBy)values(?,?,?,?)");
            ps.setString(1,billId);
            ps.setString(2,myFormat.format(cal.getTime()));
            ps.setInt(3,finalTotalPrice);
            ps.setString(4,username);
            ps.executeUpdate();
            
            
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            com.itextpdf.text.Document doc =new com.itextpdf.text.Document();
            try{
             PdfWriter.getInstance(doc,new FileOutputStream(PharmacyUtils.billPath+""+billId+".pdf"));
            doc.open();
            Paragraph pharmacyName=new Paragraph("                                     Pharmacy Management System\n");
            doc.add(pharmacyName);
            Paragraph starLine=new Paragraph("*********************************************************************");
            doc.add(starLine);
            Paragraph details=new Paragraph("\tBill ID: "+billId+"\nDate: "+new Date()+"\nTotal Paid: "+finalTotalPrice);
            doc.add(details);
            doc.add(starLine);
            PdfPTable tb1=new PdfPTable(6);
            tb1.addCell("Medicine Id");
            tb1.addCell("Name");
            tb1.addCell("Company Name");
            tb1.addCell("Price Per Unit");
            tb1.addCell("No of Units");
            tb1.addCell("Sub Total Price");
            for  (int i =0;i<cartTable.getRowCount();i++){
                String a=cartTable.getValueAt(i,0).toString();
                String b=cartTable.getValueAt(i,1).toString();
                String c=cartTable.getValueAt(i,2).toString();
                String d=cartTable.getValueAt(i,3).toString();
                String e=cartTable.getValueAt(i,4).toString();
                String f=cartTable.getValueAt(i,5).toString();
                tb1.addCell(a);
                tb1.addCell(b);
                tb1.addCell(c);
                tb1.addCell(d);
                tb1.addCell(e);
                tb1.addCell(f);
            }
            doc.add(tb1);
            doc.add(starLine);
            Paragraph thanksMsg=new Paragraph("Thank you ,Pls visit Again. ");
            doc.add(thanksMsg);
            OpenPdf.openById(String.valueOf(billId));
            
            
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e); 
            }
            doc.close();
            setVisible(false);
            new SellMedicine(username).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Please add some medicine to cart"); 
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable medicineTable;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNoOfUnits;
    private javax.swing.JTextField txtPricePerUnit;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUniqueId;
    // End of variables declaration//GEN-END:variables
}
