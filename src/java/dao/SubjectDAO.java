/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Sahil
 */
import java.sql.*;
import util.DBConnectionPool;
import model.Subject;
import java.util.*;

public class SubjectDAO {

    public boolean addSubject(Subject a) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "insert into online_exam_mgmt.subject(subject_name) values(?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, a.getSubjectName());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Subject getSubject(int id) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "select * from online_exam_mgmt.subject where id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Subject(rs.getInt("id"),
                        rs.getString("subject_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Subject> getAllSubjects() {

        List<Subject> list = new ArrayList<>();
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "select * from online_exam_mgmt.subject";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Subject(
                        rs.getInt("id"),
                        rs.getString("subject_name")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateSubject(Subject a) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "update online_exam_mgmt.subject set subject_name = ? where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, a.getSubjectName());
            ps.setInt(2, a.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteSubject(int id) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "delete from online_exam_mgmt.subject where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
