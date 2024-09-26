<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>MED HOTEL</title>
    <link rel="stylesheet" type="text/css" href="formdeux.css">
    <style>
        center {
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }
    </style>
</head>
<body>


<div class="container">
     <form method="post" action="inscriptiontraitemant.jsp">
        <div class="card">
             
            <a class="singup">S'inscrire</a>
            <div class="inputBox1">
                <input type="text" name="cin" required="required">
                <span class="user">CIN</span>
            </div>

            <div class="inputBox">
                <input type="text" name="firstname" required="required">G
                <span>First Name</span>
            </div>

            <div class="inputBox">
                <input type="text" name = "lastname" required="required">
                <span>Last Name</span>
            </div>
            <div class="inputBox">
                <input type="email" name = "email" required="required">
                <span>EMAIL</span>
            </div>
            <div class="inputBox">
                <input type="password" name = "password" required="required">
                <span>PASSWORD</span>
            </div>
            <div class="inputBox">
                <input type="password" name = "confirmPassword" required="required">
                <span>Confirm Password</span>
            </div>
            <div class="inputBox">
                <input type="text" name = "telephone" required="required">
                <span>Telephone</span>
            </div>
            
          



            

            <button class="enter">SIGNIN</button>

        </div>
         </form>
    </div>
    </body>
</html>