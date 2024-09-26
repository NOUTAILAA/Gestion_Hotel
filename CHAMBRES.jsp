<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hotel Central Palace</title>
<style>
  .card {
    font-family: Arial, sans-serif;
    display: flex;
    max-width: 1000px;
    margin: 20px auto;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    border-radius: 5px;
    overflow: hidden;
  }

  .card-image {
    flex: 1;
  }

  .card-image img {
    width: 100%;
    height: auto;
    border-radius: 5px;
  }

  .card-content {
    flex: 2;
    padding: 15px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }

  .card-header {
    font-size: 24px;
    color: #555;
  }

  .card-body {
    font-size: 14px;
  }

  .card-footer {
    align-self: flex-end;
  }

  .rating, .location {
    background-color: blue;
    color: white;
    padding: 3px 6px;
    border-radius: 3px;
    font-weight: bold;
    margin-right: 5px;
  }

  .btn {
    text-decoration: none;
    background-color: #00b359;
    color: white;
    padding: 10px 20px;
    border-radius: 5px;
    display: inline-block;
    margin-top: 10px;
  }

  /* Ajout de classes pour inverser l'ordre pour le deuxième conteneur */
  .card-reverse {
    flex-direction: row-reverse;
  }

  .card-image-reverse {
    border-radius: 0 5px 5px 0; /* Courbure de l'image à droite */
  }

</style>
</head>
<body>

<!-- Carte avec l'image à gauche -->
<div class="card">
  <div class="card-image">
    <img src="hotel-image-left.jpg" alt="Hotel Central Palace Image Gauche">
  </div>
  <div class="card-content">
    <div class="card-header">
      Hotel Central Palace
    </div>
    <div class="card-body">
      Situé à Marrakech, à 700 mètres du minaret de la mosquée Koutoubia, l'Hotel Central Palace propose des hébergements avec terrasse.
    </div>
    <div class="card-footer">
      <span class="rating">8,0 Très bien</span> 2365 expériences vécues
      <span class="location">9,4 Situation géographique</span>
      <a href="#" class="btn">Voir les tarifs</a>
    </div>
  </div>
</div>

<!-- Carte avec l'image à droite -->
<div class="card card-reverse">
  <div class="card-content">
    <div class="card-header">
      Hotel Central Palace
    </div>
    <div class="card-body">
      Situé à Marrakech, à 700 mètres du minaret de la mosquée Koutoubia, l'Hotel Central Palace propose des hébergements avec terrasse.
    </div>
    <div class="card-footer">
      <span class="rating">8,0 Très bien</span> 2365 expériences vécues
      <span class="location">9,4 Situation géographique</span>
      <a href="#" class="btn">Voir les tarifs</a>
    </div>
  </div>
  <div class="card-image card-image-reverse">
    <img src="hotel-image-right.jpg" alt="Hotel Central Palace Image Droite">
  </div>
</div>

</body>
</html>
