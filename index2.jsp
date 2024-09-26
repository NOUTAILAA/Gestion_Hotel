<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <title>NOUTIYAFH HOTEL</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light position-relative top-0 start-0 w-100">
  <div class="container">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse p-2 flex-column" id="navbarContent">
      <div class="d-flex justify-content-center">
        <a class="navbar-brand d-none d-lg-block" href="index2.jsp">
        <img src="imagess/LOGO.png" height="250" width="auto">
        </a>
      </div>

      <div class="d-block w-100">
        <ul class="navbar-nav d-flex justify-content-center align-items-center pt-3">
          <li class="nav-item mx-2">
            <a class="nav-link active" href="index2.jsp">
              Home
            </a>
          </li>
          <li class="nav-item mx-2">
            <a class="nav-link"  href="Chambres3.jsp">
              Chambres
            </a>
          </li>
          <li class="nav-item mx-2">
            <a class="nav-link" href="gallery.jsp">
              Galerie
            </a>
          </li>
          <li class="nav-item mx-2">
            <a class="nav-link" href="reservation.jsp">
              Réservations
            </a>
          </li>
          <li class="nav-item mx-2">
            <a class="nav-link" href="contact.jsp">
              Contact
            </a>
          </li>
          <li class="nav-item mx-2">
            <a class="nav-link" href="timeline2.jsp">
              About
            </a>
          </li>
          

        </ul>
      </div>
    </div>
  </div>
</nav>


<div class="header-banner">
  <img src="imagess/1.jpg" alt="Banner"/>
  
</div>

<!--images/eddi-aguirre-ZAVHbpOn4Jk-unsplash.jpg-->
<!--images/kelsey-curtis--27u_GzlAFw-unsplash.jpg-->

  </header>

  <style>

    h1 {
      font-family: 'Great Vibes', cursive;
      font-size: 40px;
    }
    @keyframes fadeInUp {
      from {
        opacity: 0;
        transform: translateY(20px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }

    .titre-hotel {
      font-family: 'Great Vibes', cursive;
      animation: fadeInUp 5s ease-out forwards;
      opacity: 0; /* Commencer avec une opacité de 0 pour l'animation */
    }


    .luxury-title {
      font-family: 'Georgia', serif;
      color: #4a4a4a;
      font-size: 2rem;
      margin-bottom: 20px;
      
    }

    .luxury-text {
      font-family: 'Arial', sans-serif;
      color: #333;
      font-size: 18px;
      line-height: 1.6;
    }

    .img-fluid {
      border-radius: 5px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .header-banner .btn-custom {
      background-color: transparent; /* Fond blanc */
      color: #ffffff; /* Texte en noir clair */
      border: transparent; /* Bordure noire */
      /* Autres propriétés du bouton */
    }

    .header-banner .btn-custom:hover {
      background-color: #9f3bb5; /* Couleur de fond au survol */
      color: white; /* Texte blanc au survol */
      border: 2px solid #b59f3b; /* Bordure de la même couleur que le fond au survol */
    }
    .header-banner {
      position: relative;
      text-align: center;
      color: white;
    }

    .header-banner img {
      width: 100%;
      height: auto;
    }
    .navbar-nav .nav-link {
      transition: color 0.3s ease; /* Transition pour le survol */
    }

    .navbar-nav .nav-link:hover {
      color: #b59f3b; /* Couleur de survol, assortie au bouton 'Réserver maintenant' */
    }

    /* Style personnalisé pour le bouton */
    .btn-custom {
      background-color: transparent; /* Fond transparent */
      color: #333; /* Couleur du texte noir clair */
      border: none; /* Pas de bordure */
      padding: 10px 20px; /* Espacement interne */
      border-radius: 5px; /* Coins arrondis */
      font-weight: bold; /* Texte en gras */
      text-transform: uppercase; /* Texte en majuscules */
      transition: background-color 0.3s ease, color 0.3s ease, border 0.3s ease; /* Transition pour survol */
    }

    /* Style du bouton au survol */
    .btn-custom:hover {
      background-color: #804040; /* Couleur de fond au survol */
      color: white; /* Couleur du texte au survol */
      border: 2px solid #FFFFFF; /* Ajout d'une bordure au survol */
    }

    /* Style personnalisé pour le footer */
    .footer {
      background-color: #f8f9fa; /* Couleur de fond clair */
      color: #333; /* Couleur du texte sombre */
      padding: 20px 0; /* Réduction de l'espacement */
      font-family: 'Arial', sans-serif; /* Police élégante */
    }

    .footer .container {
      display: flex;
      justify-content: space-around;
      align-items: center;
      flex-wrap: wrap;
    }

    .footer .nav-item {
      list-style: none;
      display: inline;
      margin: 0 10px;
    }

    .footer a {
      color: #333;
      text-decoration: none;
      margin-bottom: 10px;
      display: inline;
      transition: color 0.3s ease; /* Transition pour le survol */
    }

    .footer a:hover {
      color:#9f3bb5; /* Couleur de survol, assortie au bouton 'Réserver maintenant' */
    }

    .footer .logo-center {
      text-align: center;
      width: 100%;
      margin-bottom: 20px;
    }

    @media (max-width: 768px) {
      .footer .container {
        flex-direction: column;
        align-items: center;
      }

      .footer .nav-item {
        display: block;
        margin-bottom: 10px;
      }
    }
    .Btn {
  width: 130px;
  height: 40px;

  align-items: center;
  position : center;
  justify-content: center;
  background-color: rgb(15, 15, 15);
  border: none;
  color: white;
  font-weight: 600;
  gap: 8px;
  cursor: pointer;
  box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.103);
  position: relative;
  overflow: hidden;
  transition-duration: .3s;
}

.svgIcon {
  width: 16px;
}

.svgIcon path {
  fill: white;
}

.Btn::before {
  width: 130px;
  height: 130px;
  position: absolute;
  content: "";
  background-color: white;
  border-radius: 50%;
  left: -100%;
  top: 0;
  transition-duration: .3s;
  mix-blend-mode: difference;
}

.Btn:hover::before {
  transition-duration: .3s;
  transform: translate(100%,-50%);
  border-radius: 0;
}

.Btn:active {
  transform: translate(5px,5px);
  transition-duration: .3s;
}
  </style>
  </header>

<div class="text-center my-5">
  <h2 class="display-6">Nos Chambres</h2>
  <div class="d-flex justify-content-between align-items-center flex-column flex-lg-row my-5" id="new">
    <div class="card m-2">
      <a >
        <img src="imagess/suite-duplex.jpg" class="card-img-top" height="200" alt="Product">
      </a>
      <div class="card-body">
        <p class="card-text fw-bold">
          SUITE DUPLEX
        </p>
        <small class="text-secondary">
          4000DHS
        </small>
      </div>
      <a href="reservation.jsp" class="btn btn-custom">
        Réserver 
      </a>
    </div>
    <div class="card m-2">
      <a >
        <img src="imagess/chambre-superieur.jpg" class="card-img-top" height="200" alt="Product">
      </a>
      <div class="card-body">
        <p class="card-text fw-bold">
          CHAMBRE DE LUXE
        </p>
        <small class="text-secondary">
          2000DHS
        </small>
      </div>
      <a href="reservation.jsp" class="btn btn-custom">
        Réserver 
      </a>
    </div>
    <div class="card m-2">
      <a href="chambres.jsp">
        <img src="imagess/chambre-deluxe.jpg" class="card-img-top" height="200" alt="Product">
      </a>
      <div class="card-body">
        <p class="card-text fw-bold">
          CHAMBRE SUPERIEUR
        </p>
        <small class="text-secondary">
          1200DHS
        </small>
      </div>
      <a href="reservation.jsp" class="btn btn-custom">
        Réserver 
      </a>
    </div>
    
  </div>
       <button class="Btn"  onclick="redirectToChambres3()">
  
  <svg class="svgIcon" viewBox="0 0 576 512"><path d="M512 80c8.8 0 16 7.2 16 16v32H48V96c0-8.8 7.2-16 16-16H512zm16 144V416c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16V224H528zM64 32C28.7 32 0 60.7 0 96V416c0 35.3 28.7 64 64 64H512c35.3 0 64-28.7 64-64V96c0-35.3-28.7-64-64-64H64zm56 304c-13.3 0-24 10.7-24 24s10.7 24 24 24h48c13.3 0 24-10.7 24-24s-10.7-24-24-24H120zm128 0c-13.3 0-24 10.7-24 24s10.7 24 24 24H360c13.3 0 24-10.7 24-24s-10.7-24-24-24H248z"></path></svg>
VOIR PLUS </button>

  <div class="row text-start align-items-center gy-5 my-5">
    <div class="col-12 col-md-6">
      <img src="imagess/spa.jpg" class="img-fluid shadow" alt="Luxury Room"/>
    </div>
    <div class="col-12 col-md-6">
      <h2 class="luxury-title">                       LE SPA </h2>
      <p class="luxury-text">
Le spa de La Mamounia vous propose plus de 80 soins d’exceptions visage et corps qui sont autant d’expériences de pure sensorialité à vivre dans des écrins de douceurs aux lumières tamisées.      </p>
    </div>
  </div>

  <div class="row text-start align-items-center gy-5 my-5">
    <div class="col-12 col-md-6">
      <h2 class="luxury-title">                     LES SPORTS</h2>
      <p class="luxury-text">
Face aux merveilleux jardins, baignée de lumière et vibrant d’un superbe et énergisant bleu Majorelle, la salle de sports offre tous les équipements nécessaires à l’effort : tapis de course, vélos… des machines de dernière génération accessibles du matin au soir. 

</div>
    <div class="col-12 col-md-6">
      <img src="imagess/sport.jpeg" class="img-fluid shadow" alt="Elegant Urban Retreat"/>
    </div>
  </div>

</div>
<div class="footer">
  <div class="container">
    <div class="logo-center">
      <a href="index2.jsp">
        <img src="imagess/LOGO.png" height="100" alt="ZK GRANDEUR HÔTEL">
      </a>
    </div>
    <ul>
      <li class="nav-item">
        <a href="index2.jsp" class="nav-link">Home</a>
      </li>
      <li class="nav-item">
        <a href="Chambres3.jsp" class="nav-link">Chambres</a>
      </li>
      <li class="nav-item">
        <a href="gallery.jsp" class="nav-link">Galerie</a>
      </li>
      <li class="nav-item">
        <a href="reservation.jsp" class="nav-link">Reservations</a>
      </li>
      <li class="nav-item">
        <a href="contact.jsp" class="nav-link">Contact</a>
      </li>
      <li class="nav-item">
        <a href="timeline2.jsp" class="nav-link">About</a>
      </li>
      
      
    </ul>
  </div>
</div>
<script src="script.js"></script>
<script>
        function redirectToChambres3() {
            window.location.href = "Chambres3.jsp";
        }
    </script>
</body>
</html>