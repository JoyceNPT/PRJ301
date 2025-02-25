/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.users;
import util.DBContext;

/**
 *
 * @author ngoth
 */
public class usersDAO extends DBContext {

    public usersDAO() {
        super();
    }

    public users verify(String user, String pass) {
        users acc = new users();

        String sql = "SELECT * FROM users WHERE username = ? AND [password] = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, hashMD5(pass));
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                acc.setId(rs.getInt("id"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setRole(rs.getInt("role"));
                return acc;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return acc;
    }

    public String hashMD5(String pass) {
        try {
            MessageDigest mes = MessageDigest.getInstance("MD5");
            byte[] mesMD5 = mes.digest(pass.getBytes());

            StringBuilder str = new StringBuilder();
            for (byte b : mesMD5) {
                String ch = String.format("%02x", b);

                str.append(ch);
            }
            
            return str.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "";
    }
    
    public static void main(String[] args) {
        users acc = new users();
        usersDAO dao = new usersDAO();
        String user = "admin";
        String pass = "123456";
        System.out.println(dao.hashMD5(pass));
        
        acc = dao.verify(user, pass);
        System.out.println(acc);
    }
}
