<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Online Exam System</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:"Segoe UI", Arial, sans-serif;
}

body{
height:100vh;
display:flex;
}

/* LEFT IMAGE SECTION */

.left{
width:65%;
background:url("images/university.png") no-repeat center center;
background-size:cover;
}

/* RIGHT PANEL */

.right{
width:35%;
background:#f1f5f9;
display:flex;
flex-direction:column;
justify-content:center;
align-items:center;
padding:40px;
}

/* TITLE */

.title{
font-size:30px;
margin-bottom:40px;
color:#1e293b;
text-align:center;
line-height:1.3;
}

/* BUTTONS */

.btn{
display:block;
width:220px;
padding:14px;
margin:12px 0;
text-align:center;
text-decoration:none;
color:white;
font-size:16px;
border-radius:6px;
transition:0.25s;
}

/* LOGIN */

.login{
background:#2563eb;
}

.login:hover{
background:#1d4ed8;
}

/* REGISTER */

.register{
background:#16a34a;
}

.register:hover{
background:#15803d;
}

/* RESPONSIVE */

@media(max-width:900px){

body{
flex-direction:column;
}

.left{
width:100%;
height:40vh;
}

.right{
width:100%;
height:60vh;
}

}

</style>

</head>

<body>

<!-- LEFT IMAGE -->

<div class="left"></div>

<!-- RIGHT PANEL -->

<div class="right">

<h1 class="title">
Online Exam <br>
Management System
</h1>

<a class="btn login" href="login.jsp">
Login
</a>

<a class="btn register" href="register.jsp">
Register
</a>

</div>

</body>
</html>