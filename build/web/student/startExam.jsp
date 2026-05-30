<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Start Exam</title>

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
text-align:center;
}

/* QUESTION BLOCK */

.question{
margin-bottom:20px;
padding:15px;
background:#f8fafc;
border-radius:6px;
border:1px solid #e2e8f0;
}

.question p{
font-weight:600;
margin-bottom:10px;
}

/* OPTIONS */

.option{
display:block;
margin:6px 0;
font-size:14px;
}

/* SUBMIT BUTTON */

.submitBtn{
margin-top:20px;
padding:10px 18px;
background:#2563eb;
color:white;
border:none;
border-radius:6px;
cursor:pointer;
font-size:14px;
}

.submitBtn:hover{
background:#1d4ed8;
}

</style>

</head>

<body>

<div class="container">

<h2>Exam</h2>

<form action="<c:url value='/SubmitExamServlet'/>" method="post">

<input type="hidden" name="examId" value="${examId}">

<c:forEach var="q" items="${questionList}" varStatus="s">

<div class="question">

<p>Q${s.index + 1}. ${q.questionText}</p>

<label class="option">
<input type="radio" name="q${q.id}" value="1"> ${q.option1}
</label>

<label class="option">
<input type="radio" name="q${q.id}" value="2"> ${q.option2}
</label>

<label class="option">
<input type="radio" name="q${q.id}" value="3"> ${q.option3}
</label>

<label class="option">
<input type="radio" name="q${q.id}" value="4"> ${q.option4}
</label>

</div>

</c:forEach>

<input class="submitBtn" type="submit" value="Submit Exam">

</form>

</div>

</body>
</html>