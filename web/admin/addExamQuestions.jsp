<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Add Questions to Exam</title>

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

.container{
background:white;
padding:30px;
border-radius:10px;
box-shadow:0 4px 12px rgba(0,0,0,0.08);
max-width:800px;
margin:auto;
}

h2{
margin-bottom:20px;
color:#1e293b;
}

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

button{
margin-top:15px;
padding:10px 18px;
background:#2563eb;
color:white;
border:none;
border-radius:6px;
cursor:pointer;
}

button:hover{
background:#1d4ed8;
}

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

.message{
text-align:center;
padding:20px;
color:#888;
}

</style>
</head>

<body>

<div class="container">

<h2>Select Questions for Exam</h2>

<form action="<c:url value='/ExamServlet'/>" method="post">

<input type="hidden" name="action" value="addQuestions">
<input type="hidden" name="examId" value="${examId}">

<table>

<tr>
<th>Select</th>
<th>ID</th>
<th>Question</th>
</tr>

<c:if test="${not empty questionList}">

<c:forEach var="q" items="${questionList}">

<tr>

<td>

<input type="checkbox"
name="questionIds"
value="${q.id}"

<c:forEach var="id" items="${addedQuestionIds}">
<c:if test="${id == q.id}">
checked
</c:if>
</c:forEach>

>

</td>

<td>${q.id}</td>

<td>${q.questionText}</td>

</tr>

</c:forEach>

</c:if>

<c:if test="${empty questionList}">

<tr>
<td colspan="3" class="message">
No questions available for this subject
</td>
</tr>

</c:if>

</table>

<button type="submit">
Save Questions
</button>

</form>

<a class="back"
href="<c:url value='/ExamServlet?action=list'/>"
target="contentFrame">
Back to Exams
</a>

</div>

</body>
</html>