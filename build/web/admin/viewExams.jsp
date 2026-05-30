<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Exam Management</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:"Segoe UI", Arial, sans-serif;
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

/* TITLE */

h2{
margin-bottom:20px;
color:#1e293b;
}

/* ADD LINK */

.addBtn{
display:inline-block;
margin-bottom:20px;
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

.actionLink{
text-decoration:none;
margin-right:12px;
font-weight:500;
font-size:14px;
}

.addQ{
color:#2563eb;
}

.addQ:hover{
text-decoration:underline;
}

.delete{
color:#ef4444;
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

<h2>Exam Management</h2>

<a class="addBtn"
href="<c:url value='/ExamServlet?action=createForm'/>"
target="contentFrame">
Create Exam
</a>

<table>

<tr>
<th>ID</th>
<th>Exam Name</th>
<th>Date</th>
<th>Duration</th>
<th>Action</th>
</tr>

<c:forEach var="e" items="${examList}">

<tr>

<td>${e.id}</td>
<td>${e.examName}</td>
<td>${e.examDate}</td>
<td>${e.duration} min</td>

<td>

<a class="actionLink addQ"
href="<c:url value='/ExamServlet?action=addQuestions&examId=${e.id}&subjectId=${e.subjectId}'/>"
target="contentFrame">
Add Questions
</a>

<a class="actionLink delete"
href="<c:url value='/ExamServlet?action=delete&id=${e.id}'/>"
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