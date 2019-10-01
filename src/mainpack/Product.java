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
}

