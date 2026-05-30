/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;
import dao.ResultDAO;
import jakarta.servlet.http.HttpSession;
import model.Result;
import model.Student;

/**
 *
 * @author Sahil
 */
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        ResultDAO dao = new ResultDAO();

        if (action == null) {
            action = "list";
        }

        switch (action) {

            case "list":
                List<Result> resultList = dao.getAllResults();
                request.setAttribute("resultList", resultList);
                request.getRequestDispatcher("admin/viewResults.jsp")
                        .forward(request, response);
                break;

            case "studentResult":

                HttpSession session = request.getSession();
                Student student = (Student) session.getAttribute("student");

                if (student != null) {
                    List<Result> studentResults
                            = dao.getResultsByStudent(student.getId());

                    request.setAttribute("resultList", studentResults);
                    request.getRequestDispatcher("student/viewResult.jsp")
                            .forward(request, response);
                }
                break;

            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteResult(id);
                response.sendRedirect("ResultServlet?action=list");
                break;

            default:
                response.sendRedirect("ResultServlet?action=list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        ResultDAO dao = new ResultDAO();

        if ("add".equals(action)) {

            int studentId
                    = Integer.parseInt(request.getParameter("studentId"));

            int examId
                    = Integer.parseInt(request.getParameter("examId"));

            int marks
                    = Integer.parseInt(request.getParameter("marks"));

            Result result = new Result(studentId, examId, marks);

            dao.addResult(result);

            response.sendRedirect("ResultServlet?action=list");
        } else if ("update".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            int studentId
                    = Integer.parseInt(request.getParameter("studentId"));
            int examId
                    = Integer.parseInt(request.getParameter("examId"));
            int marks
                    = Integer.parseInt(request.getParameter("marks"));

            Result result
                    = new Result(id, studentId, examId, marks, null);

            dao.updateResult(result);

            response.sendRedirect("ResultServlet?action=list");
        }
    }
}
