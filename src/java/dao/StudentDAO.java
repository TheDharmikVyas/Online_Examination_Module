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
import java.util.*;

import util.DBConnectionPool;
import model.Student;

public class StudentDAO {

    public boolean addStudent(Student a) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "insert into online_exam_mgmt.student(name , email ,password) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, a.getName());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getPassword());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Student getStudent(int id) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "select * from online_exam_mgmt.student where id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "select * from online_exam_mgmt.student";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateStudent(Student a) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "update online_exam_mgmt.student set name=?, email=?, password=? where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, a.getName());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getPassword());
            ps.setInt(4, a.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteStudent(int id) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "delete from online_exam_mgmt.student where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Student login(String email, String password) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "select * from online_exam_mgmt.student where email= ? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
