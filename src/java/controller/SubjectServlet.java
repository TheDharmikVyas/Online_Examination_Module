package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

import dao.SubjectDAO;
import model.Subject;

public class SubjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        SubjectDAO dao = new SubjectDAO();

        if (action == null || action.trim().equals("")) {
            action = "list";
        }

        switch (action) {

            case "list":

                List<Subject> list = dao.getAllSubjects();
                request.setAttribute("subjectList", list);

                request.getRequestDispatcher("admin/viewSubjects.jsp")
                        .forward(request, response);

                break;

            case "addForm":

                request.getRequestDispatcher("admin/addSubject.jsp")
                        .forward(request, response);

                break;

            case "delete":

                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteSubject(id);

                response.sendRedirect("SubjectServlet?action=list");

                break;

            case "edit":

                int editId = Integer.parseInt(request.getParameter("id"));

                Subject subject = dao.getSubject(editId);

                request.setAttribute("subject", subject);

                request.getRequestDispatcher("admin/editSubject.jsp")
                        .forward(request, response);

                break;

            default:

                response.sendRedirect("SubjectServlet?action=list");

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        SubjectDAO dao = new SubjectDAO();

        if ("add".equals(action)) {

            String subjectName = request.getParameter("subjectName");

            Subject subject = new Subject(subjectName);

            boolean added = dao.addSubject(subject);

            if (added) {
                response.sendRedirect("SubjectServlet?action=list");
            } else {
                request.setAttribute("error", "Failed to add subject");
                request.getRequestDispatcher("admin/addSubject.jsp")
                        .forward(request, response);
            }

        } else if ("update".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String subjectName = request.getParameter("subjectName");

            Subject subject = new Subject(id, subjectName);

            dao.updateSubject(subject);

            response.sendRedirect("SubjectServlet?action=list");
        }
    }
}
