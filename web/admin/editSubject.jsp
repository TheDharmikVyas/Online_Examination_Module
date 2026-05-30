<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Edit Subject</title>

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

/* INPUT */

input[type="text"]{
width:100%;
padding:10px;
border:1px solid #d1d5db;
border-radius:6px;
font-size:14px;
margin-bottom:18px;
}

/* BUTTON */

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

<h2>Edit Subject</h2>

<form action="<c:url value='/SubjectServlet'/>?action=update" method="post">

<input type="hidden" name="id" value="${subject.id}">

<label>Subject Name</label>

<input type="text"
name="subjectName"
value="${subject.subjectName}"
required>

<input type="submit" value="Update Subject">

</form>

<a class="back"
href="<c:url value='/SubjectServlet'/>?action=list"
target="contentFrame">
Back to Subjects
</a>

</div>

</body>
</html>