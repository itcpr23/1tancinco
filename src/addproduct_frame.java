import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class addproduct_frame {
    conn conn = new conn();
    
    public int addproduct(String prodname, int prodqty, int prodprice){
        int x = 0;
        String sql = "insert into product values (null,?,?,?)";
        try{
            Class.forName(conn.driver);
            Connection con = DriverManager.getConnection(conn.url,conn.username,conn.password);
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, prodname);
            pstmt.setInt(2, prodqty);
            pstmt.setInt(3, prodprice);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
    }return x;

    
}
         
public void deleteprod(int id){
    try{
        Class.forName(conn.driver);
        Connection con = DriverManager.getConnection(conn.url,conn.username,conn.password);
        PreparedStatement pstmt = con.prepareStatement("Delete from product where id =?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  public int editproduct(int id, String prodname, float price){
        int f=0;
       
       String sql= "Update product set product_name =?, price = ? where id = ?";
         
         try{
             
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection(conn.url,conn.username,conn.password);
            PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(sql);
            
            pstmt.setString(1, prodname);
            pstmt.setFloat(2, price);
            pstmt.setInt(3, id);
            
          f = pstmt.executeUpdate();
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
        }
 return f;
}
  
  public int editQty(int id, int quantity){
     int x =0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(conn.url,conn.username,conn.password);
            PreparedStatement ps = con.prepareStatement("update product set qty = (qty+?) where id = ?");
            ps.setInt(1, quantity);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     
     return x;
  }
}
