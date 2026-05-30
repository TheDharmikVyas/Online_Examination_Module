package dao;

import java.sql.*;
import java.util.*;

import model.Question;
import util.DBConnectionPool;

public class QuestionDAO {

    public boolean addQuestion(Question q) {

        String sql = "INSERT INTO online_exam_mgmt.question "
                + "(subject_id, question_text, option1, option2, option3, option4, correct_answer) "
                + "VALUES(?,?,?,?,?,?,?)";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, q.getSubjectId());
            ps.setString(2, q.getQuestionText());
            ps.setString(3, q.getOption1());
            ps.setString(4, q.getOption2());
            ps.setString(5, q.getOption3());
            ps.setString(6, q.getOption4());
            ps.setString(7, q.getCorrectAnswer());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Question getQuestion(int id) {

        String sql = "SELECT * FROM online_exam_mgmt.question WHERE id=?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Question(
                        rs.getInt("id"),
                        rs.getInt("subject_id"),
                        rs.getString("question_text"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("correct_answer")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

 
    public List<Question> getAllQuestions() {

        List<Question> list = new ArrayList<>();

        String sql = "SELECT * FROM online_exam_mgmt.question";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Question q = new Question(
                        rs.getInt("id"),
                        rs.getInt("subject_id"),
                        rs.getString("question_text"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("correct_answer")
                );

                list.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

 
    public List<Question> getQuestionsBySubject(int subjectId) {

        List<Question> list = new ArrayList<>();

        String sql = "SELECT * FROM online_exam_mgmt.question WHERE subject_id=?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, subjectId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Question q = new Question(
                        rs.getInt("id"),
                        rs.getInt("subject_id"),
                        rs.getString("question_text"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("correct_answer")
                );

                list.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    public List<Question> getQuestionsByExam(int examId) {

        List<Question> list = new ArrayList<>();

        String sql = "SELECT q.* FROM online_exam_mgmt.question q "
                + "JOIN online_exam_mgmt.exam_question eq "
                + "ON q.id = eq.question_id "
                + "WHERE eq.exam_id = ?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, examId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Question q = new Question(
                        rs.getInt("id"),
                        rs.getInt("subject_id"),
                        rs.getString("question_text"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("correct_answer")
                );

                list.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

  

    public boolean updateQuestion(Question q) {

        String sql = "UPDATE online_exam_mgmt.question "
                + "SET subject_id=?, question_text=?, option1=?, option2=?, option3=?, option4=?, correct_answer=? "
                + "WHERE id=?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, q.getSubjectId());
            ps.setString(2, q.getQuestionText());
            ps.setString(3, q.getOption1());
            ps.setString(4, q.getOption2());
            ps.setString(5, q.getOption3());
            ps.setString(6, q.getOption4());
            ps.setString(7, q.getCorrectAnswer());
            ps.setInt(8, q.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    
    public boolean deleteQuestion(int id) {

        String sql = "DELETE FROM online_exam_mgmt.question WHERE id=?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}