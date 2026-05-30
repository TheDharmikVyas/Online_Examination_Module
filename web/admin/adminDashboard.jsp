<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:"Segoe UI", Arial, sans-serif;
}

body{
background:#eef2f7;
height:100vh;
display:flex;
flex-direction:column;
}

/* HEADER */

.topbar{
height:60px;
background:#1f2937;
display:flex;
align-items:center;
justify-content:space-between;
padding:0 30px;
}

.logo{
color:white;
font-size:20px;
font-weight:600;
}

/* LOGOUT */

.menu a{
color:white;
text-decoration:none;
padding:8px 16px;
border-radius:6px;
background:#ef4444;
font-size:14px;
}

.menu a:hover{
background:#dc2626;
}

/* MAIN */

.main{
flex:1;
padding:30px;
display:flex;
flex-direction:column;
}

/* WELCOME */

.welcome{
font-size:22px;
font-weight:600;
color:#1f2937;
margin-bottom:25px;
}

/* DASHBOARD CARDS */

.cards{
display:grid;
grid-template-columns:repeat(auto-fit,minmax(200px,1fr));
gap:20px;
margin-bottom:25px;
}

.cardLink{
text-decoration:none;
color:inherit;
}

.card{
background:white;
padding:25px;
border-radius:10px;
box-shadow:0 3px 10px rgba(0,0,0,0.08);
text-align:center;
cursor:pointer;
transition:0.25s;
}

.card h3{
color:#2563eb;
margin-bottom:8px;
}

.card p{
font-size:14px;
color:#666;
}

.card:hover{
transform:translateY(-5px);
box-shadow:0 6px 16px rgba(0,0,0,0.12);
}

/* CONTENT AREA */

.frameContainer{
flex:1;
background:white;
padding:10px;
border-radius:10px;
box-shadow:0 3px 10px rgba(0,0,0,0.08);
}

iframe{
width:100%;
height:100%;
border:none;
}

</style>

</head>

<body>

<!-- HEADER -->

<div class="topbar">

<div class="logo">
Admin Dashboard
</div>

<div class="menu">
<a href="../login.jsp">Logout</a>
</div>

</div>

<!-- MAIN -->

<div class="main">

<div class="welcome">
Welcome, ${sessionScope.username} 👋
</div>

<!-- CARDS -->

<div class="cards">

<a href="../SubjectServlet?action=list" target="contentFrame" class="cardLink">
<div class="card">
<h3>Subjects</h3>
<p>Manage exam subjects</p>
</div>
</a>

<a href="../QuestionServlet?action=list" target="contentFrame" class="cardLink">
<div class="card">
<h3>Questions</h3>
<p>Manage question bank</p>
</div>
</a>

<a href="../ExamServlet?action=list" target="contentFrame" class="cardLink">
<div class="card">
<h3>Exams</h3>
<p>Create and manage exams</p>
</div>
</a>

<a href="../ResultServlet?action=list" target="contentFrame" class="cardLink">
<div class="card">
<h3>Results</h3>
<p>View student results</p>
</div>
</a>

</div>

<!-- CONTENT AREA -->

<div class="frameContainer">

<iframe name="contentFrame"></iframe>

</div>

</div>

</body>
</html>