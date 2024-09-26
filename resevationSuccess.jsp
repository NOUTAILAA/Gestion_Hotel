<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Réservation Réussie</title>
    <!-- Inclure CSS et autres en-têtes nécessaires -->
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

 <div id="bonDeReservation">
    <h2 class ="bonbon">Bon de Réservation</h2>
    <p><strong>Nom Complet:</strong> <%= request.getParameter("name") %></p>
    <p><strong>Date de Début:</strong> <%= request.getParameter("startDate") %></p>
    <p><strong>Date de Fin:</strong> <%= request.getParameter("endDate") %></p>
    <p><strong>Type de Chambre:</strong> <%= request.getParameter("roomType") %></p>
    <p><strong>Nombre de Chambres:</strong> <%= request.getParameter("numRooms") %></p>
    <!-- Autres détails ici -->

  <a class="fancy" href="#">
  <span class="top-key"></span>
  <span class="text" onclick="telechargerBon()" >Telecharger Bon</span>
  <span class="bottom-key-1"></span>
  <span class="bottom-key-2"></span>
</a>
</div>
 <script>
 function telechargerBon() {
	    var contenu = document.getElementById('bonDeReservation').innerHTML;
	    var blob = new Blob([contenu], { type: "text/html;charset=utf-8" });
	    var url = URL.createObjectURL(blob);
	    var a = document.createElement('a');
	    a.href = url;
	    a.download = 'Bon-de-Reservation.html';
	    a.click();
	    window.URL.revokeObjectURL(url);
	}
</script>
<style>
#bonDeReservation {
    border: 1px solid #000;
    padding: 15px;
    margin: 20px auto; /* Centrer le bloc */
    background-color: #f9f9f9;
    text-align: center; /* Centrer le contenu textuel */
    width: 80%; /* Ajustez la largeur selon vos besoins */
}

.bonbon {
    text-align: center; /* Centrer le titre */
    margin: 0; /* Supprimer la marge par défaut */
}
.fancy {
 background-color: #111;
 border: 2px solid #000;
 border-radius: 0;
 box-sizing: border-box;
 color: #fff;
 cursor: pointer;
 display: inline-block;
 float: left;
 font-weight: 700;
 letter-spacing: 0.05em;
 margin: 0;
 outline: none;
 overflow: visible;
 padding: 1.25em 2em;
 position: relative;
 text-align: center;
 text-decoration: none;
 text-transform: none;
 transition: all 0.3s ease-in-out;
 user-select: none;
 font-size: 13px;
}

.fancy::before {
 content: " ";
 width: 1.5625rem;
 height: 2px;
 background: black;
 top: 50%;
 left: 1.5em;
 position: absolute;
 transform: translateY(-50%);
 transform-origin: center;
 transition: background 0.3s linear, width 0.3s linear;
}

.fancy .text {
 font-size: 1.125em;
 line-height: 1.33333em;
 padding-left: 2em;
 display: block;
 text-align: left;
 transition: all 0.3s ease-in-out;
 text-transform: uppercase;
 text-decoration: none;
 color: WHITE;
}

.fancy .top-key {
 height: 2px;
 width: 1.5625rem;
 top: -2px;
 left: 0.625rem;
 position: absolute;
 background: #e8e8e8;
 transition: width 0.5s ease-out, left 0.3s ease-out;
}

.fancy .bottom-key-1 {
 height: 2px;
 width: 1.5625rem;
 right: 1.875rem;
 bottom: -2px;
 position: absolute;
 background: #e8e8e8;
 transition: width 0.5s ease-out, right 0.3s ease-out;
}

.fancy .bottom-key-2 {
 height: 2px;
 width: 0.625rem;
 right: 0.625rem;
 bottom: -2px;
 position: absolute;
 background: #e8e8e8;
 transition: width 0.5s ease-out, right 0.3s ease-out;
}

.fancy:hover {
 color: RED;
 background: black;
}

.fancy:hover::before {
 width: 0.9375rem;
 background: white;
}

.fancy:hover .text {
 color: RED;
 padding-left: 1.5em;
}

.fancy:hover .top-key {
 left: -2px;
 width: 0px;
}

.fancy:hover .bottom-key-1,
 .fancy:hover .bottom-key-2 {
 right: 0;
 width: 0;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}

.active {
  background-color: white;
  color: black;
}
</style>
</body>
</html>
