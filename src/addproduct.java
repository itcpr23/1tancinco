
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aiibii
 */
public class addproduct extends javax.swing.JFrame {int act =0;
public void clearFields(){
    prod.setText(""); qty.setValue(1); price.setText("");
}
    /**
     * Creates new form addproduct
     */
    public addproduct() {
        initComponents();
        showdataintables();
    }
    conn cn = new conn();
    addproduct_frame aprod = new addproduct_frame();
    int id = 0;

public void showdataintables(){
    try{
        DefaultTableModel md = (DefaultTableModel) prodtable.getModel();
        md.setRowCount(0);
       Class.forName(cn.driver);
       Connection con = DriverManager.getConnection(cn.url,cn.username,cn.password);
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery("select * from product");
       while(rs.next()){
          md.addRow(new Object[]{rs.getString("id"),rs.getString("product_name"),rs.getString("qty"),rs.getString("price")});
            }
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(addproduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addproduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
public void searchbox(String prodname){
        String sql="Select * from product where id like ? or product_name like ?;";
         DefaultTableModel mod = (DefaultTableModel) prodtable.getModel();
         mod.setRowCount(0);
         try{
             Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(cn.url, cn.username, cn.password);
    PreparedStatement pstmt=con.prepareStatement(sql);
    
    pstmt.setString(1,"%"+prodname+"%");
    pstmt.setString(2,"%"+prodname+"%");
    
    
    ResultSet rs=pstmt.executeQuery();
    
     while(rs.next()){
        mod.addRow(new Object[]{rs.getString("id"),rs.getString("product_name"),rs.getString("qty"),rs.getString("price")});
    }
         } catch (ClassNotFoundException ex) {
        Logger.getLogger(addproduct.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(addproduct.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adding = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        prod = new javax.swing.JTextField();
        qty = new javax.swing.JSpinner();
        price = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        addbutton = new javax.swing.JButton();
        editbutton = new javax.swing.JButton();
        curqty = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prodtable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        search_tf = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        adding.setMinimumSize(new java.awt.Dimension(341, 253));
        adding.setUndecorated(true);

        jLabel1.setText("Product Name:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Quantity:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Price:");

        qty.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        price.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jButton3.setText("CANCEL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        addbutton.setText("ADD");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        editbutton.setText("SAVE");
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout addingLayout = new javax.swing.GroupLayout(adding.getContentPane());
        adding.getContentPane().setLayout(addingLayout);
        addingLayout.setHorizontalGroup(
            addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addingLayout.createSequentialGroup()
                            .addGroup(addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(prod)
                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingLayout.createSequentialGroup()
                                    .addComponent(curqty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(addingLayout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addGap(32, 32, 32)
                            .addComponent(addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(editbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        addingLayout.setVerticalGroup(
            addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(curqty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(addbutton)
                    .addComponent(editbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        prodtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCT", "QUANTITY", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(prodtable);
        if (prodtable.getColumnModel().getColumnCount() > 0) {
            prodtable.getColumnModel().getColumn(0).setResizable(false);
            prodtable.getColumnModel().getColumn(1).setResizable(false);
            prodtable.getColumnModel().getColumn(2).setResizable(false);
            prodtable.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        search_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_tfActionPerformed(evt);
            }
        });
        search_tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_tfKeyReleased(evt);
            }
        });

        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("Edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Edit Quantity");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(search_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(52, 52, 52)
                        .addComponent(jButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearFields();
     adding.setVisible(true); adding.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int tbl = prodtable.getSelectedRow();
        if (tbl == -1){
            JOptionPane.showMessageDialog(rootPane, "Please Select Product To Be Deleted", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        }else{
            String t = prodtable.getValueAt(tbl, 0).toString();
            String t1 = prodtable.getValueAt(tbl, 1).toString();
            int a = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete " +t1+"?\nClick 'OK' to continue","CONFIRMATION", JOptionPane.OK_CANCEL_OPTION);
            if( a == JOptionPane.OK_OPTION);
            int x = JOptionPane.showConfirmDialog(rootPane, "Do you really want to delete "+t1 , "CONFIRMATION", JOptionPane.YES_NO_OPTION);
            if( x == JOptionPane.YES_OPTION){
                    int sus = Integer.parseInt(prodtable.getValueAt(tbl, 0).toString());
                    aprod.deleteprod(sus);
                    showdataintables();
                }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
String product = prod.getText();
int qty1 = Integer.parseInt(qty.getValue().toString());
int price1 = Integer.parseInt(price.getValue().toString());

addproduct_frame addIt = new addproduct_frame();
addIt.addproduct(product, qty1, price1);

adding.setVisible(false);
showdataintables();



// TODO add your handling code here:
    }//GEN-LAST:event_addbuttonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
adding.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void search_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_tfActionPerformed

    private void search_tfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_tfKeyReleased
        String prodname = search_tf.getText();
        this.searchbox(prodname);

        // TODO add your handling code here:
    }//GEN-LAST:event_search_tfKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String prodname = search_tf.getText();
        this.searchbox(prodname);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        int a=prodtable.getSelectedRow();

        if(a==-1){
            JOptionPane.showMessageDialog(rootPane, "Please Select Row to Edit");
        }
        else{act=0;
            adding.setVisible(true);
            adding.setLocationRelativeTo(this);
            
            qty.setEnabled(false);
           
            addbutton.setEnabled(false);

            id =Integer.parseInt(prodtable.getValueAt(a, 0).toString());

            String pname=prodtable.getValueAt(a,1).toString();
            String pprice=prodtable.getValueAt(a, 3).toString();
            int pqty =Integer.parseInt( prodtable.getValueAt(a, 2).toString());

            prod.setText(pname);
            qty.setValue(pqty);
            price.setText(pprice);
            if(act==0){
                prod.setEnabled(true);
                qty.setEnabled(false);
                price.setEnabled(true);
            }
            else{
                prod.setEnabled(false);
                qty.setEnabled(true);
                price.setEnabled(false);
            }

        }

        // TODO add your handling code here cute c mamai;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed
if(act==0){
        String newprodname = prod.getText();
        float newprice =Float.parseFloat(price.getValue().toString());

        int f = aprod.editproduct(id, newprodname, newprice);

        if(f==1){
            JOptionPane.showMessageDialog(adding,"Product Edit Successfully!");
            adding.setVisible(false);
            this.showdataintables();
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(adding, "There Was a Problem Editing Product","ERROR",JOptionPane.ERROR_MESSAGE);

        }
}
else{
aprod.editQty(id, Integer.parseInt(qty.getValue().toString()));

    this.showdataintables();
    JOptionPane.showMessageDialog(adding, "Product Quantity Updated");
    adding.setVisible(false);
    
}

        // TODO add your handling code here:
    }//GEN-LAST:event_editbuttonActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      int a=prodtable.getSelectedRow();

        if(a==-1){
            JOptionPane.showMessageDialog(rootPane, "Please Select Row to Edit");
        }
        else{act=1;
            adding.setVisible(true);
            adding.setLocationRelativeTo(this);
            
            qty.setEnabled(false);
           
            addbutton.setEnabled(false);

            id =Integer.parseInt(prodtable.getValueAt(a, 0).toString());

            String pname=prodtable.getValueAt(a,1).toString();
            String pprice=prodtable.getValueAt(a, 3).toString();
            int pqty =Integer.parseInt( prodtable.getValueAt(a, 2).toString());
            curqty.setText(pqty+"");
            prod.setText(pname);
            qty.setValue(0);
            price.setText(pprice);
            
            if(act==0){
                prod.setEnabled(true);
                qty.setEnabled(false);
                price.setEnabled(true);
            }
            else{
                prod.setEnabled(false);
                qty.setEnabled(true);
                price.setEnabled(false);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(addproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addproduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private javax.swing.JFrame adding;
    private javax.swing.JLabel curqty;
    private javax.swing.JButton editbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField price;
    private javax.swing.JTextField prod;
    private javax.swing.JTable prodtable;
    private javax.swing.JSpinner qty;
    private javax.swing.JTextField search_tf;
    // End of variables declaration//GEN-END:variables
}
