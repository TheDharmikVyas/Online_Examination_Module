<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Question</title>

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
max-width:600px;
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

/* INPUT */

input[type="text"]{
width:100%;
padding:10px;
border:1px solid #d1d5db;
border-radius:6px;
font-size:14px;
margin-bottom:15px;
}

/* SUBMIT BUTTON */

input[type="submit"]{
background:#2563eb;
color:white;
border:none;
padding:10px 18px;
border-radius:6px;
font-size:14px;
cursor:pointer;
transition:0.25s;
}

input[type="submit"]:hover{
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

<h2>Edit Question</h2>

<form action="<c:url value='/QuestionServlet'/>?action=update" method="post">

<input type="hidden" name="id" value="${question.id}">
<input type="hidden" name="subjectId" value="${question.subjectId}">

<label>Question</label>
<input type="text" name="questionText" value="${question.questionText}" required>

<label>Option 1</label>
<input type="text" name="option1" value="${question.option1}" required>

<label>Option 2</label>
<input type="text" name="option2" value="${question.option2}" required>

<label>Option 3</label>
<input type="text" name="option3" value="${question.option3}" required>

<label>Option 4</label>
<input type="text" name="option4" value="${question.option4}" required>

<label>Correct Answer</label>
<input type="text" name="correctAnswer" value="${question.correctAnswer}" required>

<input type="submit" value="Update Question">

</form>

<a class="back"
href="<c:url value='/QuestionServlet?action=list'/>"
target="contentFrame">
Back to Question Bank
</a>

</div>

</body>
</html>