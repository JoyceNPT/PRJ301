/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;
import util.DBContext;

/**
 *
 * @author ngoth
 */
public class ProductDAO extends DBContext {

    public ProductDAO() {
        super();
    }

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();

        String sql = "SELECT\n"
                + "pro_id, pro_name, pro_price, pro_quantity, pro_description, category.cat_id, category.cat_name, category.cat_description\n"
                + "FROM [product]\n"
                + "JOIN category ON [product].cat_id = category.cat_id";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("pro_id");
                String name = rs.getString("pro_name");
                long price = rs.getLong("pro_price");
                int quantity = rs.getInt("pro_quantity");
                String descript = rs.getString("pro_description");

                int cId = rs.getInt("cat_id");
                String cName = rs.getString("cat_name");
                String cDescript = rs.getString("cat_description");

                Category cat = new Category(cId, cName, cDescript);

                Product pro = new Product(id, name, price, quantity, descript, cat);
                list.add(pro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public int create(String name, long price, int quantity, String descript, int cat_name) {
        String maxId = "SELECT MAX(pro_id) AS maxId FROM [product]";

        try {
            PreparedStatement psMaxId = conn.prepareStatement(maxId);
            ResultSet rsMaxId = psMaxId.executeQuery();

            if (rsMaxId.next()) {
                int id = rsMaxId.getInt("maxId") + 1;

                String sql = "INSERT INTO [product] (pro_id, pro_name, pro_price, pro_quantity, pro_description, cat_id) VALUES (?, ?, ?, ?, ?, ?)";

                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setLong(3, price);
                    ps.setInt(4, quantity);
                    ps.setString(5, descript);
                    ps.setInt(6, cat_name);

                    int result = ps.executeUpdate();

                    if (result > 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public Product getById(int id) {
        String sql = "SELECT P.pro_id, P.pro_name, P.pro_price, P.pro_quantity, P.pro_description, P.cat_id, C.cat_name, C.cat_description FROM [product] AS P\n"
                + "JOIN category AS C ON P.cat_id = C.cat_id\n"
                + "WHERE pro_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("pro_name");
                long price = rs.getLong("pro_price");
                int quantity = rs.getInt("pro_quantity");
                String descript = rs.getString("pro_description");
                int catId = rs.getInt("cat_id");
                String catName = rs.getString("cat_name");
                String catDescript = rs.getString("cat_description");

                Category cat = new Category(catId, catName, catDescript);
                Product pro = new Product(id, name, price, quantity, descript, cat);
                return pro;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int update(int id, String name, long price, int quantity, String descript, int cat) {
        String sql = "UPDATE [product]\n"
                + "SET pro_name = ?, pro_price = ?, pro_quantity = ?, pro_description = ?, cat_id = ?\n"
                + "WHERE pro_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setLong(2, price);
            ps.setInt(3, quantity);
            ps.setString(4, descript);
            ps.setInt(5, cat);
            ps.setInt(6, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int delete(int id) {
        String sql = "DELETE FROM [product] WHERE pro_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

//    public static void main(String[] args) {
//        List<Product> list = new ArrayList<>();
//        ProductDAO dao = new ProductDAO();
//
////        list = dao.getAll();
////        
////        for (Product product : list) {
////            System.out.println(product);
////        }
////        int result = dao.create("Phone", 10100100, 10, "China", 3);
////        System.out.println(result);
////        Product pro = dao.getById(2);
////        System.out.println(pro);
////        int update = dao.update(6, "Papa", 500, 1, "New Year", 3);
////        System.out.println(update);
//        int delete = dao.delete(10);
//        System.out.println(delete);
//    }
}
