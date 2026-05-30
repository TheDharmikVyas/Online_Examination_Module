<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Exam Submitted</title>

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
padding:40px;
border-radius:10px;
box-shadow:0 4px 12px rgba(0,0,0,0.08);
max-width:500px;
margin:auto;
text-align:center;
}

/* TITLE */

h2{
color:#1e293b;
margin-bottom:10px;
}

/* MESSAGE */

.success{
color:#16a34a;
font-weight:600;
margin-bottom:15px;
}

p{
color:#475569;
margin-bottom:20px;
}

/* BACK LINK */

.back{
text-decoration:none;
color:#2563eb;
font-weight:500;
}

.back:hover{
text-decoration:underline;
}

</style>

</head>

<body>

<div class="container">

<h2>Exam Submitted Successfully</h2>

<div class="success">
Your Exam Has Been Submitted
</div>

<p>
Thank you for completing the exam.<br>
Your result will be available shortly.
</p>

<a class="back"
href="<c:url value='/student/studentDashboard.jsp'/>"
target="_parent">
Back to Dashboard
</a>

</div>

</body>
</html>