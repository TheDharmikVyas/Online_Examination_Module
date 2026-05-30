package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ExamDAO;
import dao.QuestionDAO;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpSession;

import model.Exam;
import model.Question;
import model.Student;
import model.Subject;

public class ExamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        ExamDAO examDAO = new ExamDAO();
        SubjectDAO subjectDAO = new SubjectDAO();
        QuestionDAO questionDAO = new QuestionDAO();

        if (action == null) {
            action = "list";
        }

        switch (action) {

            case "list":

                List<Exam> exams = examDAO.getAllExams();

                request.setAttribute("examList", exams);

                request.getRequestDispatcher("admin/viewExams.jsp")
                        .forward(request, response);

                break;

            case "createForm":

                List<Subject> subjects
                        = subjectDAO.getAllSubjects();

                request.setAttribute("subjectList", subjects);

                request.getRequestDispatcher("admin/createExam.jsp")
                        .forward(request, response);

                break;

            case "addQuestions":

                int subjectId
                        = Integer.parseInt(request.getParameter("subjectId"));

                int examId
                        = Integer.parseInt(request.getParameter("examId"));

                List<Question> questions
                        = questionDAO.getQuestionsBySubject(subjectId);

                List<Integer> addedQuestionIds
                        = examDAO.getQuestionIdsByExam(examId);

                request.setAttribute("questionList", questions);
                request.setAttribute("addedQuestionIds", addedQuestionIds);
                request.setAttribute("examId", examId);

                request.getRequestDispatcher("admin/addExamQuestions.jsp")
                        .forward(request, response);

                break;

            case "delete":

                int id
                        = Integer.parseInt(request.getParameter("id"));

                examDAO.deleteExam(id);

                response.sendRedirect("ExamServlet?action=list");

                break;

            case "studentList":

                HttpSession session = request.getSession(false);

                if (session == null || session.getAttribute("student") == null) {
                    response.sendRedirect("login.jsp");
                    return;
                }

                List<Exam> examList = examDAO.getAllExams();

                request.setAttribute("examList", examList);

                request.getRequestDispatcher("student/availableExams.jsp")
                        .forward(request, response);

                break;

            case "startExam":
                HttpSession session2 = request.getSession(false);

                if (session2 == null || session2.getAttribute("student") == null) {
                    response.sendRedirect("login.jsp");
                    return;
                }

                int examIdStart
                        = Integer.parseInt(request.getParameter("id"));

                List<Question> examQuestions
                        = questionDAO.getQuestionsByExam(examIdStart);

                if (examQuestions == null || examQuestions.isEmpty()) {
                    response.sendRedirect("student/availableExams.jsp");
                    return;
                }

                request.setAttribute("questionList", examQuestions);
                request.setAttribute("examId", examIdStart);

                request.getRequestDispatcher("student/startExam.jsp")
                        .forward(request, response);

                break;

            default:
                response.sendRedirect("ExamServlet?action=list");
                break;
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        ExamDAO examDAO = new ExamDAO();

        if ("create".equals(action)) {

            int subjectId
                    = Integer.parseInt(request.getParameter("subjectId"));

            String examName
                    = request.getParameter("examName");

            Date examDate
                    = Date.valueOf(request.getParameter("examDate"));

            int duration
                    = Integer.parseInt(request.getParameter("duration"));

            Exam exam
                    = new Exam(subjectId, examName, examDate, duration);

            int examId
                    = examDAO.addExam(exam);

            response.sendRedirect(
                    "ExamServlet?action=addQuestions&examId="
                    + examId
                    + "&subjectId=" + subjectId);
        } else if ("addQuestions".equals(action)) {

            int examId
                    = Integer.parseInt(request.getParameter("examId"));

            String[] questionIds
                    = request.getParameterValues("questionIds");

            if (questionIds != null) {

                for (String qid : questionIds) {

                    examDAO.addQuestionToExam(
                            examId,
                            Integer.parseInt(qid));
                }
            }

            response.sendRedirect("ExamServlet?action=list");
        }
    }
}
