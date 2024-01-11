<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>

<style>

#user{

margin-top:30px;	
height : 25px;
width : 150px;
border : 1px solid black;
background-color : black;
border-radius: 5px;
text-align: center;
align-content: center;
}
#admin{
height : 25px;
width : 150px;
border : 1px solid black;
background-color : black;
border-radius: 5px;
text-align: center;
align-content: center;
}

a{
margin-top:4px;
text-decoration: none;
color: white;
display:flex;
justify-content: center;
align-content: center;
text-align: center;
}

#box{
height: 150px;
width: 200px;
border: 2px solid black;
border-radius: 5px;
justify-content: center;
align-content: center;
text-align: center;
}


.one{
margin-left:25px;
margin-top:20px;
}

</style>
</head>
<body>

<center>
<div class="main">

<div class="ulogin">
<h1>ADMIN DETAILS</h1>
<hr>

<div id="box">

<div id="user" class="one">
<a href="adminlogin.jsp">ADMIN LOGIN</a>
</div>
<br>
<div id="admin" class="one">
<a href="adminsignup.jsp">ADMIN SIGNUP</a>
</div>

</div>


</div>
</center>
</body>
</html>