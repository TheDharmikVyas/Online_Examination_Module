package dao;

import java.sql.*;
import java.util.*;

import model.Exam;
import util.DBConnectionPool;

public class ExamDAO {

    
    public int addExam(Exam e) {

        String sql = "INSERT INTO online_exam_mgmt.exam(subject_id, exam_name, exam_date, duration) VALUES(?,?,?,?)";

        try (Connection con = DBConnectionPool.getConnection(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, e.getSubjectId());
            ps.setString(2, e.getExamName());
            ps.setDate(3, e.getExamDate());
            ps.setInt(4, e.getDuration());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); // return generated exam_id
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return -1;
    }


    public Exam getExam(int id) {

        String sql = "SELECT * FROM online_exam_mgmt.exam WHERE id=?";

        try (Connection con = DBConnectionPool.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Exam(
                        rs.getInt("id"),
                        rs.getInt("subject_id"),
                        rs.getString("exam_name"),
                        rs.getDate("exam_date"),
                        rs.getInt("duration")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Exam> getAllExams() {

        List<Exam> list = new ArrayList<>();
        String sql = "SELECT * FROM online_exam_mgmt.exam";

        try (Connection con = DBConnectionPool.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Exam e = new Exam(
                        rs.getInt("id"),
                        rs.getInt("subject_id"),
                        rs.getString("exam_name"),
                        rs.getDate("exam_date"),
                        rs.getInt("duration")
                );

                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean updateExam(Exam e) {

        String sql = "UPDATE online_exam_mgmt.exam SET subject_id=?, exam_name=?, exam_date=?, duration=? WHERE id=?";

        try (Connection con = DBConnectionPool.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getSubjectId());
            ps.setString(2, e.getExamName());
            ps.setDate(3, e.getExamDate());
            ps.setInt(4, e.getDuration());
            ps.setInt(5, e.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }


    public boolean deleteExam(int id) {

        String sql = "DELETE FROM online_exam_mgmt.exam WHERE id=?";

        try (Connection con = DBConnectionPool.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    
    public boolean addQuestionToExam(int examId, int questionId) {

        String sql = "INSERT INTO online_exam_mgmt.exam_question(exam_id, question_id) VALUES(?,?)";

        try (Connection con = DBConnectionPool.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, examId);
            ps.setInt(2, questionId);

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public List<Integer> getQuestionIdsByExam(int examId) {

        List<Integer> list = new ArrayList<>();
        String sql = "SELECT question_id FROM online_exam_mgmt.exam_question WHERE exam_id=?";

        try (Connection con = DBConnectionPool.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, examId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getInt("question_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean removeQuestionFromExam(int examId, int questionId) {

        String sql = "DELETE FROM online_exam_mgmt.exam_question WHERE exam_id=? AND question_id=?";

        try (Connection con = DBConnectionPool.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, examId);
            ps.setInt(2, questionId);

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public List<Exam> getAvailableExamsForStudent(int studentId) {

        List<Exam> list = new ArrayList<>();

        String sql = "SELECT * FROM exam e WHERE e.id NOT IN "
                + "(SELECT exam_id FROM result WHERE student_id=?)";

        try (Connection con = DBConnectionPool.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Exam e = new Exam(
                        rs.getInt("id"),
                        rs.getInt("subject_id"),
                        rs.getString("exam_name"),
                        rs.getDate("exam_date"),
                        rs.getInt("duration")
                );

                list.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }
}
