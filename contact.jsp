<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact Card</title>
<link rel="stylesheet" href="styless.css">
</head>
<body>
<ul>
  <li><a  href="index2.jsp">Home</a></li>
  <li><a href="Chambres3.jsp">Chambres</a></li>
  <li><a href="gallery.jsp" >Galerie</a></li>
  <li><a href="reservation.jsp" >Reservations</a></li>
  <li><a href="contact.jsp" class="active" >Contact</a></li>
  <li><a href="timeline2.jsp">About</a></li>
  <li style="float:right"><a  href="index2.jsp">NOUTIYAFH HOTEL</a></li>
</ul>
<div class="contact-card">
    <h2>CONTACT </h2>
    <p>We're open for any suggestion or just to have a chat</p>
    <div class="contact-item">
        <img src="imagess/location.jpg" alt="Address Icon" class="icon">
        <span>Address: J2J3+3GJ, Derb Assehbi, Marrakesh 40000</span>
    </div>
    <div class="contact-item">
        <img src="imagess/phone.png" alt="Phone Icon" class="icon">
        <span>Phone: +1 2355 2355 98</span>
    </div>
    <div class="contact-item">
        <img src="imagess/email.jpg" alt="Email Icon" class="icon">
        <span>Email: NOUTIYAFH@gmail.com</span>
    </div>
    <div class="contact-item">
        <img src="imagess/weeb.png" alt="Website Icon" class="icon">
        <span>Website NOUTIYAFH.com</span>
    </div>
</div>
<style>
body {
    font-family: 'Arial', sans-serif;
    background-color: #e0ece4;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.contact-card {
    background-color: #80a89e;
    padding: 20px;
    border-radius: 10px;
    width: 300px; /* Adjust width as necessary */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.contact-card h2 {
    color: #fff;
    font-size: 24px;
    margin-bottom: 10px;
}

.contact-card p {
    color: #d1d8e0;
    font-size: 14px;
    margin-bottom: 20px;
}

.contact-item {
    display: flex;
    align-items: center;
    margin-bottom: 15px;
}

.icon {
    width: 24px; /* Adjust width as necessary */
    height: 24px; /* Adjust height as necessary */
    margin-right: 10px;
}

.contact-item span {
    color: #fff;
    font-size: 16px;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  background-color: #333;
  position: fixed; /* Fixed positioning */
  top: 0; /* At the top of the page */
  width: 100%; /* Full width */
  z-index: 1000; /* Above other items */
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

li a:hover, .active {
  background-color: #111;
}

.active {
  background-color: white;
  color: black;
}

/* Contact card styles */
.contact-card {
    background-color: #80a89e;
    padding: 20px;
    border-radius: 10px;
    width: 300px; /* Adjust width as necessary */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    /* Removed flex styles and used margin to position the card */
    margin-top: 50px; /* Space for the navbar */
}

</style>

</body>
</html>
