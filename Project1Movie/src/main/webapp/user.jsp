<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

.ulogin{

height: 300px;
width:400px;
border: 1px solid black;
border-radius: 5px;
margin: 100px;
}

.main{

display: flex;
justify-content: center;
align-items: center;

}

.uname{
margin-left: 23px;
}

.users{
margin-top:30px;
}
a{
text-decoration: none;

}

</style>
</head>
<body>

<center>
<div class="main">

<div class="ulogin">
<h1>USER LOGIN</h1>
<hr>

<table>
<tr>
<td > User Name  <input type="text" class="uname users"> </td>
</tr>

<tr>
<td>User Password  <input type="password" class="upwd users"> </td> 
</tr>


</table>

<input type="submit" class="users">
Create an user <a href="usignup.jsp">Signup</a>
</div> 

</div>
</center>

</body>
</html>