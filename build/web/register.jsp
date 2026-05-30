<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Register</title>

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
font-weight:600;
}

/* FORM */

form{
display:flex;
flex-direction:column;
align-items:center;
}

/* INPUT FIELDS */

input[type="text"],
input[type="email"],
input[type="password"]{

width:260px;
padding:11px;
margin:8px 0;
border:1px solid #d1d5db;
border-radius:6px;
font-size:14px;
outline:none;
transition:0.2s;

}

input:focus{
border-color:#2563eb;
box-shadow:0 0 0 2px rgba(37,99,235,0.1);
}

/* REGISTER BUTTON */

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

background:#2564eb;
transform:translateY(-1px);

}

/* LOGIN LINK */

.login-link{
margin-top:15px;
font-size:14px;
color:#475569;
}

.login-link a{
text-decoration:none;
color:#2563eb;
font-weight:500;
}

.login-link a:hover{
text-decoration:underline;
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

<div class="left"></div>

<div class="right">

<h2>Student Registration</h2>

<form action="StudentRegisterServlet" method="post">

<input type="text" name="name" placeholder="Enter Name" required>

<input type="email" name="email" placeholder="Enter Email" required>

<input type="password" name="password" placeholder="Enter Password" required>

<input type="submit" value="Register">

</form>

<div class="login-link">
Already have an account?
<a href="login.jsp">Login</a>
</div>

</div>

</body>
</html>