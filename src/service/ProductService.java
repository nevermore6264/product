package service;

import model.*;
import connect.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService{

    public List<Product> getAll() throws Exception {
        Connection con = Connect.getConnection();

        List<Product> products = new ArrayList<>();
        PreparedStatement pre = null;
        pre = con.prepareStatement("select Product.id,code,Product.name,price,Category.name\n" +
                "from Product left join Category on Product.category_id = Category.id");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            Product pro = new Product();
            pro.setId(rs.getInt("id"));
            pro.setCode(rs.getString("code"));
            pro.setName(rs.getString("name"));
            pro.setPrice(rs.getFloat("price"));
            pro.setCategory(new Category(rs.getInt("id"),rs.getString("name")));
            products.add(pro);
        }
        return products;
    }

    public Product getProduct(int id){
        Connection con = null;
        PreparedStatement pre = null;
        Product pro = new Product();
        String sql = "select Product.id,code,Product.name,price,Category.id,Category.name\n" +
                "from Product left join Category on Product.category_id = Category.id\n" +
                "where Product.id = ?";
        try {
            con = Connect.getConnection();
            pre = con.prepareStatement(sql);
            pre.setInt(1,id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setCode(rs.getString("code"));
                pro.setName(rs.getString("name"));
                pro.setPrice(rs.getFloat("price"));
                pro.setCategory(new Category(rs.getInt("id"),rs.getString("name")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                pre.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pro;
    }
    public boolean delete(int id){
        Connection con = null;
        PreparedStatement pre = null;
        boolean result = false;
        try {
            con = Connect.getConnection();
            pre = con.prepareStatement("delete from Product where Product.id=?");
            pre.setInt(1,id);
            int line = pre.executeUpdate();
            if(line>0)result = true;
            result = false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public List<Category> getAllCategory() throws Exception {
        Connection con = Connect.getConnection();

        List<Category> categories = new ArrayList<>();
        PreparedStatement pre = null;
        pre = con.prepareStatement("select * from Category");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            categories.add(category);
        }
        return categories;
    }
}
