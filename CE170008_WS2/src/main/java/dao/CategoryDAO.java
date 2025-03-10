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
import util.DBContext;

/**
 *
 * @author ngoth
 */
public class CategoryDAO extends DBContext {

    public CategoryDAO() {
        super();
    }

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();

        String sql = "SELECT * FROM category";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cat_id");
                String name = rs.getString("cat_name");
                String descript = rs.getString("cat_description");

                Category cat = new Category(id, name, descript);
                list.add(cat);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

//    public static void main(String[] args) {
//        CategoryDAO dao = new CategoryDAO();
//        List<Category> list = dao.getAll();
//
//        for (Category category : list) {
//            System.out.println(category);
//        }
//    }
}
