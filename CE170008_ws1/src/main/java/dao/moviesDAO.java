/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.movies;
import util.DBContext;

/**
 *
 * @author ngoth
 */
public class moviesDAO extends DBContext {

    public moviesDAO() {
        super();
    }
    
    public List<movies> getAll() {
        List<movies> list = new ArrayList<>();
        String sql = "SELECT * FROM movies";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String director = rs.getString("director");
                int release_year = rs.getInt("release_year");
                double rating = rs.getDouble("rating");
                boolean Is_rented = rs.getBoolean("Is_rented");
                
                movies mov = new movies(id, title, director, release_year, rating, Is_rented);
                list.add(mov);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public boolean create(String title, String director, int release_year, double rating, boolean Is_rented) {
        String maxId = "SELECT MAX(id) AS maxId FROM movies";
        try {
            PreparedStatement psMaxId = conn.prepareStatement(maxId);
            ResultSet rsMaxId = psMaxId.executeQuery();
            
            if(rsMaxId.next()) {
                int id = rsMaxId.getInt("maxId") + 1;
                
                String sql = "INSERT INTO movies (id, title, director, release_year, rating, Is_rented) VALUES (?, ?, ?, ?, ?, ?)";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.setString(2, title);
                    ps.setString(3, director);
                    ps.setInt(4, release_year);
                    ps.setDouble(5, rating);
                    ps.setBoolean(6, Is_rented);
                    
                    int result = ps.executeUpdate();
                    
                    if(result > 0) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public movies getById (int id) {
        String sql = "SELECT * FROM movies WHERE id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                String title = rs.getString("title");
                String director = rs.getString("director");
                int release_year = rs.getInt("release_year");
                double rating = rs.getDouble("rating");
                boolean Is_rented = rs.getBoolean("Is_rented");
                
                movies mov = new movies(id, title, director, release_year, rating, Is_rented);
                return mov;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public int update(int id, String title, String director, int release_year, double rating, boolean Is_rented) {
        String sql = "UPDATE movies SET title = ?, director = ?, release_year = ?, rating = ?, Is_rented = ? WHERE id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, director);
            ps.setInt(3, release_year);
            ps.setDouble(4, rating);
            ps.setBoolean(5, Is_rented);
            ps.setInt(6, id);
            
            int update = ps.executeUpdate();
            
            if(update > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM movies WHERE id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            int delete = ps.executeUpdate();
            
            if(delete > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static void main(String[] args) {
        moviesDAO dao = new moviesDAO();
//        List<movies> list = dao.getAll();
//        
//        if(list != null) {
//            for (movies movi : list) {
//                System.out.println(movi);
//            }
//        }

//        boolean insert = dao.create("Nha Gia Tien", "Huynh Lap", 2025, 9.9, true);
//        System.out.println(insert);

//        movies mov = dao.getById(5);
//        System.out.println(mov);

//        int update = dao.update(7, "Đảo Độc Đắc", "Phim Ma", 1999, 8.2, false);
//        System.out.println(update);

        boolean delete = dao.delete(6);
        System.out.println(delete);
    }
}
