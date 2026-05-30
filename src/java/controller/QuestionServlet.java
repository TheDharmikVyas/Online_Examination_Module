package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import dao.QuestionDAO;
import dao.SubjectDAO;
import model.Question;
import model.Subject;

public class QuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        QuestionDAO qdao = new QuestionDAO();
        SubjectDAO sdao = new SubjectDAO();

        if (action == null) {
            action = "list";
        }

        switch (action) {

            case "list":
                List<Question> questionList = qdao.getAllQuestions();
                request.setAttribute("questionList", questionList);
                request.getRequestDispatcher("admin/viewQuestions.jsp")
                        .forward(request, response);
                break;

            case "addForm":
                List<Subject> subjects = sdao.getAllSubjects();
                request.setAttribute("subjectList", subjects);
                request.getRequestDispatcher("admin/addQuestion.jsp")
                        .forward(request, response);
                break;

            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                qdao.deleteQuestion(deleteId);
                response.sendRedirect("QuestionServlet?action=list");
                break;

            case "edit":
                int editId = Integer.parseInt(request.getParameter("id"));

                Question question = qdao.getQuestion(editId);
                List<Subject> subjectList = sdao.getAllSubjects();

                request.setAttribute("question", question);
                request.setAttribute("subjectList", subjectList);

                request.getRequestDispatcher("admin/editQuestion.jsp")
                        .forward(request, response);
                break;

            default:
                response.sendRedirect("QuestionServlet?action=list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        QuestionDAO dao = new QuestionDAO();

        if ("add".equals(action)) {

            int subjectId = Integer.parseInt(request.getParameter("subjectId"));

            String questionText = request.getParameter("questionText");

            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");

            String correctAnswer = request.getParameter("correctAnswer");

            Question q = new Question(
                    subjectId,
                    questionText,
                    option1,
                    option2,
                    option3,
                    option4,
                    correctAnswer
            );

            dao.addQuestion(q);

            response.sendRedirect("QuestionServlet?action=list");

        } else if ("update".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));

            int subjectId = Integer.parseInt(request.getParameter("subjectId"));

            String questionText = request.getParameter("questionText");

            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");

            String correctAnswer = request.getParameter("correctAnswer");

            Question q = new Question(
                    id,
                    subjectId,
                    questionText,
                    option1,
                    option2,
                    option3,
                    option4,
                    correctAnswer
            );

            dao.updateQuestion(q);

            response.sendRedirect("QuestionServlet?action=list");
        }
    }
}