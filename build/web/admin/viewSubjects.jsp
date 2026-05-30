<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Subjects</title>

        <style>

            *{
                margin:0;
                padding:0;
                box-sizing:border-box;
                font-family:Segoe UI, Arial, sans-serif;
            }

            body{
                background:#f1f5f9;
                padding:30px;
            }

            /* CONTAINER */

            .container{
                background:white;
                padding:30px;
                border-radius:10px;
                box-shadow:0 4px 12px rgba(0,0,0,0.08);
                max-width:800px;
                margin:auto;
            }

            /* TITLE */

            h2{
                margin-bottom:20px;
                color:#1e293b;
            }

            /* ADD BUTTON */

            .addBtn{
                display:inline-block;
                margin-bottom:20px;
                text-decoration:none;
                background:#2563eb;
                color:white;
                padding:8px 16px;
                border-radius:6px;
                font-size:14px;
                transition:0.3s;
            }

            .addBtn:hover{
                background:#1d4ed8;
            }

            /* TABLE */

            table{
                width:100%;
                border-collapse:collapse;
                margin-top:10px;
            }

            th{
                background:#1e293b;
                color:white;
                padding:12px;
                font-size:14px;
            }

            td{
                padding:12px;
                border-bottom:1px solid #e2e8f0;
                font-size:14px;
            }

            /* ROW HOVER */

            tr:hover{
                background:#f8fafc;
            }

            /* ACTION LINKS */

            .edit{
                color:#2563eb;
                text-decoration:none;
                margin-right:12px;
                font-weight:500;
            }

            .edit:hover{
                text-decoration:underline;
            }

            .delete{
                color:#ef4444;
                text-decoration:none;
                font-weight:500;
            }

            .delete:hover{
                text-decoration:underline;
            }

            /* BACK BUTTON */

            .back{
                display:inline-block;
                margin-top:20px;
                text-decoration:none;
                color:#475569;
                font-size:14px;
            }

            .back:hover{
                text-decoration:underline;
            }
        </style>

    </head>

    <body>

        <div class="container">

            <h2>Subjects</h2>

            <a class="addBtn" href="<c:url value='/SubjectServlet?action=addForm'/>">
                Add Subject
            </a>

            <table>

                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="s" items="${subjectList}">

                    <tr>

                        <td><c:out value="${s.id}"/></td>

                        <td><c:out value="${s.subjectName}"/></td>

                        <td>

                            <a class="edit"
                               href="<c:url value='/SubjectServlet'/>?action=edit&id=${s.id}">
                                Edit
                            </a>

                            <a class="delete"
                               href="<c:url value='/SubjectServlet'/>?action=delete&id=${s.id}">
                                Delete
                            </a>

                        </td>

                    </tr>

                </c:forEach>

            </table>

            <a class="back"
               href="<c:url value='/admin/adminDashboard.jsp'/>"
               target="_parent">
                Back to Dashboard
            </a>

        </div>

    </body>
</html>