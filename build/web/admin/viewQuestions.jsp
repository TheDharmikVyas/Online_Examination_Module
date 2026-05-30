<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Question Bank</title>

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
max-width:900px;
margin:auto;
}

/* HEADER */

.header{
display:flex;
justify-content:space-between;
align-items:center;
margin-bottom:20px;
}

h2{
color:#1e293b;
}

/* ADD LINK */

.addBtn{
text-decoration:none;
background:#2563eb;
color:white;
padding:8px 16px;
border-radius:6px;
font-size:14px;
}

.addBtn:hover{
background:#1d4ed8;
}

/* TABLE */

table{
width:100%;
border-collapse:collapse;
}

th{
background:#1e293b;
color:white;
padding:12px;
text-align:left;
font-size:14px;
}

td{
padding:12px;
border-bottom:1px solid #e2e8f0;
font-size:14px;
}

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

/* BACK */

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

<div class="header">
<h2>Question Bank</h2>

<a class="addBtn"
href="<c:url value='/QuestionServlet?action=addForm'/>"
target="contentFrame">
Add Question
</a>

</div>

<table>

<tr>
<th>ID</th>
<th>Question</th>
<th>Action</th>
</tr>

<c:forEach var="q" items="${questionList}">

<tr>

<td><c:out value="${q.id}"/></td>

<td><c:out value="${q.questionText}"/></td>

<td>

<a class="edit"
href="<c:url value='/QuestionServlet?action=edit&id=${q.id}'/>"
target="contentFrame">
Edit
</a>

<a class="delete"
href="<c:url value='/QuestionServlet?action=delete&id=${q.id}'/>"
target="contentFrame">
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