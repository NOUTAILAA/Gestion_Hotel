<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>NOUTIYAFH RESERVATION</title>
    <link rel="stylesheet" type="text/css" href="reservation.css">
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
<ul>
    <li><a href="index2.jsp">Home</a></li>
    <li><a href="Chambres3.jsp">Chambres</a></li>
    <li><a href="gallery.jsp" onclick="redirectToGallery()">Galerie</a></li>
    <li><a class="active" href="reservation.jsp" onclick="redirectToReservation()">Reservations</a></li>
      <li><a href="contact.jsp">Contact</a></li>
    <li><a href="timeline2.jsp">About</a></li>
    <li style="float:right"><a href="index2.jsp">NOUTIYAFH HOTEL</a></li>
</ul>
<center>
    <form class="form" method="post" action="processReservation.jsp">
        <p class="title">Register</p>
        <p class="message">Signup now and get full access to our app.</p>

        <label>
            <input class="input" type="text" name="cin" placeholder="" required="">
            <span>Cin</span>
        </label>

        <div class="flex">
            <label>
                <input class="input" type="text" name="firstname" placeholder="" required="">
                <span>Firstname</span>
            </label>

            <label>
                <input class="input" type="text" name="lastname" placeholder="" required="">
                <span>Lastname</span>
            </label>
        </div>

        <label>
            <input class="input" type="email" name="email" placeholder="" required="">
            <span>Email</span>
        </label>

        <label>
            <input class="input" type="password" name="password" placeholder="" required="">
            <span>Password</span>
        </label>

        <label>
            <input class="input" type="password" name="confirmPassword" placeholder="" required="">
            <span>Confirm password</span>
        </label>

        <label>
            <input class="input" type="text" name="telephone" placeholder="" required="">
            <span>Téléphone</span>
        </label>

     
        <button>
  <span class="transition"></span>
  <span class="gradient"></span>
  <span class="submitt" type="submit">SIGN UP</span>
</button>
        <p class="signin"> Already have an account? <a href="Connexion.jsp">Signin</a></p>

        <!-- Display error message if any -->
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
                out.println("<p style='color: red;'>" + errorMessage + "</p>");
            }
        %>
    </form>
    
</center>
<style>
button {
  font-family: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas,
    "Liberation Mono", "Courier New", monospace;
  font-size: 17px;
  padding: 1em 2.7em;
  font-weight: 500;
  background: #1f2937;
  color: white;
  border: none;
  position: relative;
  overflow: hidden;
  border-radius: 0.6em;
  cursor: pointer;
}

.gradient {
  position: absolute;
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
  border-radius: 0.6em;
  margin-top: -0.25em;
  background-image: linear-gradient(
    rgba(0, 0, 0, 0),
    rgba(0, 0, 0, 0),
    rgba(0, 0, 0, 0.3)
  );
}

.submitt {
  position: relative;
  top: -1px;
}

.transition {
  transition-timing-function: cubic-bezier(0, 0, 0.2, 1);
  transition-duration: 500ms;
  background-color: #00bfff;
  border-radius: 9999px;
  width: 0;
  height: 0;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

button:hover .transition {
  width: 22em;
  height: 14em;
}

button:active {
  transform: scale(0.99);
}
</style>
</body>
</html>
