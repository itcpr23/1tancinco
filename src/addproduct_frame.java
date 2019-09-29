import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
}
