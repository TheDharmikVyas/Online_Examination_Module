<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Exam Results</title>

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

.marks{
font-weight:bold;
color:#16a34a;
}

/* BACK LINK */

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

<h2>Exam Results</h2>

<table>

<tr>
<th>ID</th>
<th>Student</th>
<th>Exam</th>
<th>Marks</th>
</tr>

<c:forEach var="r" items="${resultList}">

<tr>

<td>${r.id}</td>
<td>${r.studentName}</td>
<td>${r.examName}</td>
<td class="marks">${r.marks}</td>

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