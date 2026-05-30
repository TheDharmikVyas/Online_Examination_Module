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

import model.Result;
import util.DBConnectionPool;

public class ResultDAO {

    public boolean addResult(Result a) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "insert into online_exam_mgmt.result(student_id, exam_id, marks) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, a.getStudentId());
            ps.setInt(2, a.getExamId());
            ps.setInt(3, a.getMarks());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Result getResult(int id) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "select * from online_exam_mgmt.result where id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Result(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("exam_id"),
                        rs.getInt("marks"),
                        rs.getTimestamp("exam_date")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Result> getAllResults() {

        List<Result> list = new ArrayList<>();

        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = """
        SELECT r.id,
               r.student_id,
               r.exam_id,
               r.marks,
               r.exam_date,
               s.name AS student_name,
               e.exam_name
        FROM online_exam_mgmt.result r
        JOIN online_exam_mgmt.student s ON r.student_id = s.id
        JOIN online_exam_mgmt.exam e ON r.exam_id = e.id
        """;

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Result r = new Result(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getString("exam_name"),
                        rs.getInt("exam_id"),
                        rs.getInt("marks"),
                        rs.getTimestamp("exam_date")
                );

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean updateResult(Result a) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "update online_exam_mgmt.result set student_id=?, exam_id=?, marks=? where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, a.getStudentId());
            ps.setInt(2, a.getExamId());
            ps.setInt(3, a.getMarks());
            ps.setInt(4, a.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteResult(int id) {
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "delete from online_exam_mgmt.result where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Result> getResultsByStudent(int studentId) {
        List<Result> list = new ArrayList<>();
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = """
SELECT r.id,
       r.student_id,
       r.exam_id,
       r.marks,
       r.exam_date,
       e.exam_name,
       s.subject_name
FROM online_exam_mgmt.result r
JOIN online_exam_mgmt.exam e ON r.exam_id = e.id
JOIN online_exam_mgmt.subject s ON e.subject_id = s.id
WHERE r.student_id = ?
""";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Result r = new Result();

                r.setId(rs.getInt("id"));
                r.setStudentId(rs.getInt("student_id"));
                r.setSubjectName(rs.getString("subject_name"));
                r.setExamName(rs.getString("exam_name"));
                r.setExamId(rs.getInt("exam_id"));
                r.setMarks(rs.getInt("marks"));
                r.setExamDate(rs.getTimestamp("exam_date"));

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Result> getResultsByExam(int examId) {
        List<Result> list = new ArrayList<>();
        try {
            Connection con = DBConnectionPool.getConnection();

            String sql = "select * from online_exam_mgmt.result where exam_id=? ";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, examId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Result r = new Result(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("exam_id"),
                        rs.getInt("marks"),
                        rs.getTimestamp("exam_date")
                );
                list.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean hasStudentAttempted(int studentId, int examId) {

        String sql = "SELECT id FROM result WHERE student_id=? AND exam_id=?";

        try (Connection con = DBConnectionPool.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, examId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
