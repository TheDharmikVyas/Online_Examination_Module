package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Sahil
 */
import java.sql.*;
import util.DBConnectionPool;
import model.Admin;

public class AdminDAO {

    public boolean addAdmin(Admin a) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "insert into online_exam_mgmt.admin(username,password) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Admin getAdmin(int id) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "select * from online_exam_mgmt.admin where id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Admin(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateAdmin(Admin a) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "update online_exam_mgmt.admin set username=?, password=? where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            ps.setInt(3, a.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteAdmin(int id) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "delete from online_exam_mgmt.admin where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean login(String username, String password) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "select * from online_exam_mgmt.admin where username= ? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
