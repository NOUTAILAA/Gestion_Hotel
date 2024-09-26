<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>NOUTIYAF HOTEL - Gallery</title>
    <style>
        body {
            margin: 0;
            padding: 0;
        }

     

        .gallery-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Utilise 100% de la hauteur de la fenêtre */
            position: relative; /* Permet de positionner les boutons par rapport à ce conteneur */
        }

        .gallery-image {
            display: none;
            width: 1654px; /* Définissez la largeur souhaitée */
            height: 839px; /* Ajuste automatiquement la hauteur en fonction de la largeur */
        }
.video-size {
    width: 1654px;
    height: 839px;
}

        .active {
            display: block;
            color : black;
        }

        .button {
            position: absolute;
            top: 50%; /* Positionne le bouton à mi-hauteur */
            transform: translateY(-50%); /* Centre le bouton verticalement */
            padding: 5px 10px;
            font-size: 16px;
            cursor: pointer;
            color: #fff; /* Couleur du texte du bouton */
            border: none;
            border-radius: 5px;
            background: transparent; /* Fond transparent */
        }

        .button-prev {
            left: 10px; /* Positionne le bouton "Précédent" à gauche */
            height: 800px;
        }

        .button-next {
            right: 10px; /* Positionne le bouton "Suivant" à droite */
        }

        /* Ajout de styles pour les icônes */
        .mbri-icon {
            font-size: 24px;
            margin: 0 5px;
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
  
}  
    </style>
</head>
<body>
<ul>
  <li><a  href="index2.jsp">Home</a></li>
  <li><a href="Chambres3.jsp">Chambres</a></li>
  <li><a href="gallery.jsp" onclick="redirectToGallery()" class="active" >Galerie</a></li>
  <li><a href="reservation.jsp"  >Reservations</a></li>
    <li><a href="contact.jsp">Contact</a></li>
  <li><a href="timeline2.jsp">About</a></li>
  <li style="float:right"><a  href="index2.jsp">NOUTIYAFH HOTEL</a></li>
</ul>

    <div class="gallery-container">
        <!-- Affichez vos images ici -->
<video src="imagess/VID3.mp4" class="gallery-image active " autoplay loop muted></video>
<video src="imagess/VID4.mp4" class="gallery-image " autoplay loop muted></video>
        <img src="imagess/1.jpg" alt="Image 1" class="gallery-image ">

        <img src="imagess/2.jpg" alt="Image 2" class="gallery-image">




        <img src="imagess/3.jpg" alt="Image 3" class="gallery-image">
        <img src="imagess/4.jpg" alt="Image 4" class="gallery-image">
        <img src="imagess/5.jpg" alt="Image 5" class="gallery-image">
        <img src="imagess/6.jpg" alt="Image 6" class="gallery-image">
        <img src="imagess/7.jpg" alt="Image 7" class="gallery-image">
        <img src="imagess/8.jpg" alt="Image 8" class="gallery-image">
        <img src="imagess/9.jpg" alt="Image 9" class="gallery-image">

        <img src="imagess/10.jpg" alt="Image 10" class="gallery-image">
        <button class="button button-prev" onclick="prevImage()">
            <span class="mbri-icon">&lt;</span>         </button>
        <button class="button button-next" onclick="nextImage()">
             <span class="mbri-icon">&gt;</span>
        </button>
    </div>

    <script>
        var currentIndex = 0;
        var images = document.getElementsByClassName('gallery-image');

        function showImage(index) {
            // Masquer toutes les images
            for (var i = 0; i < images.length; i++) {
                images[i].classList.remove('active');
            }

            // Afficher l'image spécifiée
            images[index].classList.add('active');
        }

        function nextImage() {
            currentIndex = (currentIndex + 1) % images.length;
            showImage(currentIndex);
        }

        function prevImage() {
            currentIndex = (currentIndex - 1 + images.length) % images.length;
            showImage(currentIndex);
        }
    </script>
</body>
</html>
