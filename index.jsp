<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>NOUTIYAFH HOTEL</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>


<body>
<ul>
  <li><a class="active" href="index.jsp">Home</a></li>
  <li><a href="Chambres3.jsp">Chambres</a></li>
  <li><a href="#contact" onclick="redirectToGallery()">Galerie</a></li>
  <li><a href="#news" onclick="redirectToReservation()" >Reservations</a></li>
  <li><a href="timeline2.jsp">About</a></li>
  <li style="float:right"><img src="imagess/LOGO.png" height="50" width="auto"></li>
</ul>

    
    <!-- Utilisez un conteneur pour l'image de fond et le paragraphe -->
    <div class="background-container">
        <!-- Ajoutez l'image de fond ici -->
        <div class="background-image"></div>
        
        <div class="container">
            <h2>WELCOME TO OUR HOTEL</h2>
            <p class = "hada">Discover comfort and luxury at NOUTIYAFH Hotel.</p>

            
        </div>
        
    </div>
 
    <script>
        function redirectToGallery() {
            window.location.href = "gallery.jsp";
        }
    </script>
        <script>
        function redirectToReservation() {
            window.location.href = "reservation.jsp";
        }
    </script>

</body>

</html>
