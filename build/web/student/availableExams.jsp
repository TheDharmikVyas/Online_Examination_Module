<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Available Exams</title>

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
max-width:800px;
margin:auto;
}

/* TITLE */

h2{
margin-bottom:20px;
color:#1e293b;
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

/* START LINK */

.start{
text-decoration:none;
color:#2563eb;
font-weight:500;
}

.start:hover{
text-decoration:underline;
}

/* MESSAGE */

.msg{
margin-top:15px;
color:#555;
}

/* BACK LINK */
.back{
display:inline-block;
margin-top:20px;
text-decoration:none;
color:#2563eb;
font-size:14px;
}

.back:hover{
text-decoration:underline;
}

</style>

</head>

<body>

<c:choose>

<c:when test="${not empty sessionScope.student}">

<div class="container">

<h2>Available Exams</h2>

<c:choose>

<c:when test="${not empty examList}">

<table>

<tr>
<th>Exam</th>
<th>Date</th>
<th>Duration</th>
<th>Action</th>
</tr>

<c:forEach var="e" items="${examList}">

<tr>

<td><c:out value="${e.examName}" /></td>
<td>${e.examDate}</td>
<td>${e.duration} min</td>

<td>

<a class="start"
href="<c:url value='/ExamServlet'/>?action=startExam&id=${e.id}"
target="contentFrame">
Start Exam
</a>

</td>

</tr>

</c:forEach>

</table>

</c:when>

<c:otherwise>
<p class="msg">No exams available</p>
</c:otherwise>

</c:choose>

<a class="back"
href="<c:url value='/student/studentDashboard.jsp'/>"
target="_parent">
Back to Dashboard
</a>

</div>

</c:when>

<c:otherwise>
<c:redirect url="/login.jsp"/>
</c:otherwise>

</c:choose>

</body>
</html>