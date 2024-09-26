<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>NOUTIYAFH RESERVATION</title>
    <link rel="stylesheet" type="text/css" href="Chambres3.css">
    <link  type="text/js" href="Chambres3.js">
</head>
<body>
<ul>
  <li><a  href="index2.jsp">Home</a></li>
  <li><a class="active" href="Chambres3.jsp">Chambres</a></li>
  <li><a href="gallery.jsp" onclick="redirectToGallery()">Galerie</a></li>
  <li><a href="reservation.jsp" onclick="redirectToReservation()" >Reservations</a></li>
  <li><a href="contact.jsp">Contact</a></li>
  <li><a href="timeline2.jsp">About</a></li>
  <li style="float:right"><a  href="index2.jsp">NOUTIYAFH HOTEL</a></li>
</ul>

<div class="container">
 <div class="card">
    <img src="imagess/suite-duplex.jpg">
    <div class="card__head">SUITE DUPLEX</div>
    <div class="description">Découvrez le summum du luxe et de l'espace dans nos suites duplex. Ces hébergements exclusifs sur deux niveaux offrent une intimité totale, des espaces de vie distincts et des détails sophistiqués, créant ainsi une expérience de séjour incomparable à 4000DHS.</div>
  </div>
  <div class="card">
    <img src="imagess/chambre-deluxe.jpg">
    <div class="card__head">CHAMBRE DE LUXE</div>
    <div class="description">Découvrez l'élégance ultime dans nos chambres de luxe. Immergez-vous dans un monde de raffinement où chaque détail est pensé pour vous offrir une expérience inoubliable. Profitez d'un espace spacieux, d'un mobilier somptueux et d'un service personnalisé d'exception à 2000DHS.</div>
  </div>
  <div class="card">
    <img src="imagess/chambre-superieur.jpg">
    <div class="card__head">CHAMBRE SUPERIEURE</div>
    <div class="description">Optez pour notre catégorie de chambres supérieures pour une expérience supérieure sans compromis. Des équipements améliorés et un confort optimal vous attendent, créant l'environnement parfait pour un séjour relaxant et agréable à 1200DHS .</div>
  </div>
  <div class="card">
    <img src="imagess/chambre-classique.jpg">
    <div class="card__head">CHAMBRE CLASSIQUE</div>
    <div class="description">Notre chambre classique vous offre l'essentiel du confort à un prix abordable. Un espace accueillant doté de toutes les commodités nécessaires pour assurer un séjour plaisant. Une option idéale pour les voyageurs recherchant une valeur exceptionnelle à 800DHS .</div>

  </div>

<button class="Btn"  onclick="redirectToReservation()">
  
  <svg class="svgIcon" viewBox="0 0 576 512"><path d="M512 80c8.8 0 16 7.2 16 16v32H48V96c0-8.8 7.2-16 16-16H512zm16 144V416c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16V224H528zM64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H512c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64zm56 304c-13.3 0-24 10.7-24 24s10.7 24 24 24h48c13.3 0 24-10.7 24-24s-10.7-24-24-24H120zm128 0c-13.3 0-24 10.7-24 24s10.7 24 24 24H360c13.3 0 24-10.7 24-24s-10.7-24-24-24H248z"></path></svg>
Réserver </button>
</div>
<script>
  // Fonction pour rediriger vers reservation.jsp
  function redirectToReservation() {
    // Utilisez window.location.href pour rediriger
    window.location.href = "reservation.jsp";
  }
</script>
</body>
</html>
