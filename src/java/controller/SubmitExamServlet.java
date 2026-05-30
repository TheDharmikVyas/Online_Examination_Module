package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import dao.QuestionDAO;
import dao.ResultDAO;

import model.Question;
import model.Result;
import model.Student;

public class SubmitExamServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        Student student = (Student) session.getAttribute("student");

        if (student == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int studentId = student.getId();
        int examId = Integer.parseInt(request.getParameter("examId"));

        ResultDAO rdao = new ResultDAO();

        if (rdao.hasStudentAttempted(studentId, examId)) {
            response.sendRedirect("student/alreadyAttempted.jsp");
            return;
        }

        QuestionDAO qdao = new QuestionDAO();
        List<Question> questions = qdao.getQuestionsByExam(examId);

        int marks = 0;

        for (Question q : questions) {

            String answer = request.getParameter("q" + q.getId());

            if (answer != null && answer.equals(q.getCorrectAnswer())) {
                marks++;
            }
        }

        Result result = new Result(studentId, examId, marks);

        
        rdao.addResult(result);

        response.sendRedirect("student/submitExam.jsp");
    }
}
