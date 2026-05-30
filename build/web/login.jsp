<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>

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

/* LEFT IMAGE */

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

/* HEADING */

h2{
margin-bottom:25px;
color:#1e293b;
}

/* ROLE SELECT */

.role{
margin-bottom:15px;
font-size:14px;
color:#475569;
}

/* INPUTS */

input[type="text"],
input[type="password"]{

width:260px;
padding:10px;
margin:8px 0;
border:1px solid #d1d5db;
border-radius:6px;
font-size:14px;

}

/* LOGIN BUTTON */

input[type="submit"]{

width:260px;
padding:12px;
margin-top:15px;
background:#2563eb;
color:white;
border:none;
border-radius:6px;
font-size:15px;
cursor:pointer;
transition:0.25s;

}

input[type="submit"]:hover{

background:#1d4ed8;

}

</style>

<script>

function changeAction(role){

let form=document.getElementById("loginForm");
let userField=document.getElementById("userField");

if(role==="admin"){

form.action="AdminLoginServlet";
userField.name="username";
userField.placeholder="Admin Username";

}else{

form.action="StudentLoginServlet";
userField.name="email";
userField.placeholder="Student Email";

}

}

</script>

</head>

<body>

<div class="left"></div>

<div class="right">

<h2>Login</h2>

<form id="loginForm" method="post" action="StudentLoginServlet">

<div class="role">

<label>
<input type="radio" name="role" value="student" checked onclick="changeAction('student')">
Student
</label>

<label style="margin-left:15px;">
<input type="radio" name="role" value="admin" onclick="changeAction('admin')">
Admin
</label>

</div>

<input id="userField" type="text" name="email" placeholder="Student Email" required>

<input type="password" name="password" placeholder="Password" required>

<input type="submit" value="Login">

</form>

</div>

</body>
</html>