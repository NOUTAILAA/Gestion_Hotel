<!DOCTYPE html>
<html>
<head>
<style>
body {
  margin: 0; /* Supprimer les marges par défaut du body */
  overflow: hidden; /* Empêcher la barre de défilement horizontale */
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh; /* 100% de la hauteur de la vue */
}

div.gallery {
  margin: 5px;
  border: 1px solid #ccc;
  width: 180px;
  text-align: center; /* Centrer le contenu à l'intérieur de la div.gallery */
}

div.gallery:hover {
  border: 1px solid #777;
}

div.gallery img {
  width: 100%;
  height: auto;
}

div.desc {
  padding: 15px;
}
</style>
</head>
<body>

<div class="container">

  <div class="gallery">
    <a target="_blank" href="img_5terre.jpg">
      <img src="imagess/9.jpg" alt="Cinque Terre" width="600" height="400">
    </a>
    <div class="desc">Add a description of the image here</div>
  </div>

  <div class="gallery">
    <a target="_blank" href="imagess/9.jpg">
      <img src="imagess/9.jpg" alt="Forest" width="600" height="400">
    </a>
    <div class="desc">Add a description of the image here</div>
  </div>

  <div class="gallery">
    <a target="_blank" href="/imagess/10.jpg">
      <img src="imagess/9.jpg" alt="Northern Lights" width="600" height="400">
    </a>
    <div class="desc">Add a description of the image here</div>
  </div>

  <div class="gallery">
    <a target="_blank" href="img_mountains.jpg">
      <img src="imagess/9.jpg" alt="Mountains" width="600" height="400">
    </a>
    <div class="desc">Add a description of the image here</div>
  </div>

</div>

</body>
</html>
