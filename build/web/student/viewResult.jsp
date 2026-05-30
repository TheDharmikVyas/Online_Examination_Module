<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<c:if test="${empty sessionScope.student}">
    <c:redirect url="/login.jsp"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<title>My Results</title>

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

/* MARKS */

td:last-child{
font-weight:bold;
color:#16a34a;
text-align:center;
}

/* MESSAGE */

.msg{
margin-top:15px;
color:#475569;
}

/* BACK */

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

<div class="container">

<h2>My Results</h2>

<c:choose>

<c:when test="${not empty resultList}">

<table>

<tr>
<th>Subject</th>
<th>Exam</th>
<th>Marks</th>
</tr>

<c:forEach var="r" items="${resultList}">

<tr>

<td>${r.subjectName}</td>
<td>${r.examName}</td>
<td>${r.marks}</td>

</tr>

</c:forEach>

</table>

</c:when>

<c:otherwise>

<p class="msg">No results available</p>

</c:otherwise>

</c:choose>

<a class="back"
href="<c:url value='/student/studentDashboard.jsp'/>"
target="_parent">
Back to Dashboard
</a>

</div>

</body>
</html>