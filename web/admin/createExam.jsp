<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Create Exam</title>

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
max-width:500px;
margin:auto;
}

/* TITLE */

h2{
margin-bottom:20px;
color:#1e293b;
}

/* LABEL */

label{
display:block;
margin-bottom:6px;
font-size:14px;
color:#334155;
}

/* INPUTS */

input,select{
width:100%;
padding:10px;
border:1px solid #d1d5db;
border-radius:6px;
font-size:14px;
margin-bottom:15px;
}

/* BUTTON */

button{
background:#2563eb;
color:white;
border:none;
padding:10px 18px;
border-radius:6px;
font-size:14px;
cursor:pointer;
transition:0.25s;
}

button:hover{
background:#1d4ed8;
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

<h2>Create Exam</h2>

<form action="<c:url value='/ExamServlet'/>?action=create" method="post">

<label>Exam Name</label>
<input type="text" name="examName" required>

<label>Subject</label>

<select name="subjectId" required>

<option value="">Select Subject</option>

<c:forEach var="s" items="${subjectList}">
<option value="${s.id}">
<c:out value="${s.subjectName}"/>
</option>
</c:forEach>

</select>

<label>Exam Date</label>
<input type="date" name="examDate" required>

<label>Duration (minutes)</label>
<input type="number" name="duration" required>

<button type="submit">Create Exam</button>

</form>

<a class="back"
href="<c:url value='/ExamServlet?action=list'/>"
target="contentFrame">
Back to Exams
</a>

</div>

</body>
</html>