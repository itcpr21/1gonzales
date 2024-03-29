/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpack;




import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myconnector.connectors;
import static myconnector.connectors.conUrl;


/**
 *
 * @author Acer-User
 */
public class Product {
    //connectors connection = new connectors();
    
    public int addProduct(String brand, String model,String unit,int quantity, float newprice){
       int r = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection(conUrl);
            
            String sql = "insert into product values(null,?,?,?,?,?);";
            PreparedStatement p = con.prepareStatement(sql);
            
       
            
            p.setString(1, brand);
            p.setString(2, model);
            p.setString(3, unit);
            p.setInt(4, quantity);
            p.setFloat(5, newprice);
            
            r = p.executeUpdate();
            //System.out.println(pstmt);
            
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
   }
    
     public int deleteProduct(Object id){
        int r = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
              Connection con =DriverManager.getConnection(conUrl);
            
            String sql = "DELETE FROM product WHERE id = ?;";
            PreparedStatement p = con.prepareStatement(sql);
           
            
            int newid = Integer.parseInt(id.toString());
            
            p.setInt(1, newid);
            
            r = p.executeUpdate();
            //System.out.println(pstmt);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
     
     public int editProduct(Object id, String brand, Object price){
        int r = 0;
        try{
           Class.forName("com.mysql.jdbc.Driver");
              Connection con =DriverManager.getConnection(conUrl);
            
            String sql = "UPDATE product SET product_name = ?, price = ? WHERE id = ?;";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            
            pstmt.setString(1, brand);
            float newprice = Float.parseFloat(price.toString());
            pstmt.setFloat(2, newprice);
            String newid = id.toString();
            pstmt.setString(3, newid);
            
            r = pstmt.executeUpdate();
            //System.out.println(pstmt);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
     
     
  public int addQuantity(Object id, Object quantity){
        int r = 0;
        try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con =DriverManager.getConnection(conUrl);
            
            String sql = "UPDATE product SET quantity = quantity + ? WHERE id = ?;";
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            
            int newqty = Integer.parseInt(quantity.toString());
            pstmt.setInt(1, newqty);
            pstmt.setString(2, id.toString());
            
            r = pstmt.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }    
     
}

        
