<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>NOUTIYAFH RESERVATION</title>
    <link rel="stylesheet" type="text/css" href="connexion.css">
    <style>
center {
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }
        .card {
    width: 300px; /* Ajustez la largeur selon vos besoins */
    padding: 1.9rem 1.2rem;
    background: #2a2b38;
    align-items: center;
    justify-content: center;
    text-align: center;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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
     <form method="post" action="connexionprocess.jsp">
<div class="card">
  <h4 class="title">LOG IN</h4>
  <form>
      <div class="field">
      <svg class="input-icon"  width="1em" height="1em" version="1.1" id="Icon_Set" xmlns="http://www.w3.org/2000/svg" x="0" y="0" viewBox="0 0 512 512" style="enable-background:new 0 0 512 512" xml:space="preserve"><style>.st2{fill:#4c4372}.st3{fill:#d3e6f8}.st5{fill:#7babf1}.st6{fill:#fff}</style><g id="ID_Card"><circle cx="256" cy="256" r="207" style="fill:#f0c48a"/><path class="st6" d="M389.712 375.266H122.288c-10.072 0-18.237-8.165-18.237-18.237V180.58c0-10.072 8.165-18.237 18.237-18.237h267.424c10.072 0 18.237 8.165 18.237 18.237v176.449c0 10.072-8.165 18.237-18.237 18.237z"/><path class="st3" d="M389.712 162.343h-14.726v212.922h14.726c10.072 0 18.237-8.165 18.237-18.236V180.58c0-10.072-8.165-18.237-18.237-18.237z"/><path class="st2" d="M389.712 381.266H122.288c-13.364 0-24.236-10.873-24.236-24.237V180.58c0-13.364 10.872-24.237 24.236-24.237h267.424c13.364 0 24.236 10.873 24.236 24.237v176.448c0 13.365-10.872 24.238-24.236 24.238zM122.288 168.343c-6.747 0-12.236 5.489-12.236 12.237v176.448c0 6.748 5.489 12.237 12.236 12.237h267.424c6.747 0 12.236-5.489 12.236-12.237V180.58c0-6.748-5.489-12.237-12.236-12.237H122.288z"/><path class="st5" d="M137.014 199.009h109.975V338.6H137.014z"/><path d="M246.989 338.6H137.014v-29.859c0-10.294 8.345-18.638 18.638-18.638h72.698c10.294 0 18.638 8.345 18.638 18.638V338.6z" style="fill:#fd919e"/><path class="st2" d="M246.989 344.6H137.014a6 6 0 0 1-6-6v-29.86c0-13.585 11.053-24.638 24.639-24.638h72.698c13.586 0 24.639 11.053 24.639 24.638v29.86a6.002 6.002 0 0 1-6.001 6zm-103.975-12h97.976v-23.86c0-6.969-5.67-12.638-12.639-12.638h-72.698c-6.969 0-12.639 5.669-12.639 12.638v23.86z"/><path class="st3" d="M191.989 311.491c-8.058 0-14.591-6.533-14.591-14.591v-26.002h29.182V296.9c.001 8.058-6.532 14.591-14.591 14.591z"/><path class="st2" d="M191.989 317.49c-11.354 0-20.591-9.237-20.591-20.591v-26.002a6 6 0 0 1 6-6h29.182a6 6 0 0 1 6 6v26.002c0 11.354-9.237 20.591-20.591 20.591zm-8.591-40.593v20.002c0 4.737 3.854 8.591 8.591 8.591s8.591-3.854 8.591-8.591v-20.002h-17.182z"/><path class="st6" d="M192.002 212.969c-16.124 0-29.195 13.071-29.195 29.194v14.968c0 16.124 13.071 29.194 29.194 29.194 16.124 0 29.194-13.071 29.194-29.194v-14.968c.001-16.123-13.07-29.194-29.193-29.194z"/><path class="st2" d="M192.002 292.326c-19.407 0-35.195-15.788-35.195-35.194v-14.969c0-19.406 15.788-35.194 35.195-35.194 19.406 0 35.194 15.788 35.194 35.194v14.969c0 19.406-15.788 35.194-35.194 35.194zm0-73.357c-12.79 0-23.195 10.405-23.195 23.194v14.969c0 12.789 10.405 23.194 23.195 23.194 12.789 0 23.194-10.405 23.194-23.194v-14.969c0-12.789-10.405-23.194-23.194-23.194z"/><g><path class="st2" d="M246.989 344.6H137.014a6 6 0 0 1-6-6V199.009a6 6 0 0 1 6-6H246.99a6 6 0 0 1 6 6V338.6a6.002 6.002 0 0 1-6.001 6zm-103.975-12h97.976V205.009h-97.976V332.6z"/></g><g><path class="st2" d="M374.986 205.009h-86.199a6 6 0 0 1 0-12h86.199a6 6 0 0 1 0 12z"/></g><g><path class="st2" d="M374.986 251.539h-86.199a6 6 0 0 1 0-12h86.199a6 6 0 0 1 0 12z"/></g><g><path class="st2" d="M374.986 298.069h-86.199a6 6 0 0 1 0-12h86.199a6 6 0 0 1 0 12z"/></g><g><path class="st2" d="M374.986 344.6h-86.199a6 6 0 0 1 0-12h86.199a6 6 0 0 1 0 12z"/></g><g><path d="M286.856 179.41h-61.712a5.74 5.74 0 0 1-5.741-5.741v-30.856c0-20.212 16.385-36.597 36.597-36.597s36.597 16.385 36.597 36.597v30.856c0 3.17-2.57 5.741-5.741 5.741z" style="fill:#a4cff2"/></g><g><path class="st2" d="M286.855 185.41h-61.711c-6.475 0-11.741-5.267-11.741-11.741v-30.856c0-23.488 19.108-42.597 42.597-42.597s42.597 19.108 42.597 42.597v30.856c0 6.475-5.267 11.741-11.742 11.741zm-61.452-12h61.193v-30.598c0-16.871-13.726-30.597-30.597-30.597s-30.597 13.726-30.597 30.597v30.598z"/></g><g><circle class="st5" cx="256" cy="141.283" r="13.443"/></g><g><path class="st2" d="M256 160.726c-10.721 0-19.443-8.723-19.443-19.443S245.279 121.84 256 121.84s19.443 8.722 19.443 19.442-8.722 19.444-19.443 19.444zm0-26.886c-4.104 0-7.443 3.339-7.443 7.442 0 4.104 3.339 7.443 7.443 7.443s7.443-3.339 7.443-7.443c0-4.103-3.339-7.442-7.443-7.442z"/></g></g></svg>
      <input autocomplete="off" id="logcin" placeholder="Cin" class="input-field" name="logcin" type="cin">
    </div>
    <div class="field">
      <svg class="input-icon" viewBox="0 0 500 500" xmlns="http://www.w3.org/2000/svg">
      <path d="M207.8 20.73c-93.45 18.32-168.7 93.66-187 187.1c-27.64 140.9 68.65 266.2 199.1 285.1c19.01 2.888 36.17-12.26 36.17-31.49l.0001-.6631c0-15.74-11.44-28.88-26.84-31.24c-84.35-12.98-149.2-86.13-149.2-174.2c0-102.9 88.61-185.5 193.4-175.4c91.54 8.869 158.6 91.25 158.6 183.2l0 16.16c0 22.09-17.94 40.05-40 40.05s-40.01-17.96-40.01-40.05v-120.1c0-8.847-7.161-16.02-16.01-16.02l-31.98 .0036c-7.299 0-13.2 4.992-15.12 11.68c-24.85-12.15-54.24-16.38-86.06-5.106c-38.75 13.73-68.12 48.91-73.72 89.64c-9.483 69.01 43.81 128 110.9 128c26.44 0 50.43-9.544 69.59-24.88c24 31.3 65.23 48.69 109.4 37.49C465.2 369.3 496 324.1 495.1 277.2V256.3C495.1 107.1 361.2-9.332 207.8 20.73zM239.1 304.3c-26.47 0-48-21.56-48-48.05s21.53-48.05 48-48.05s48 21.56 48 48.05S266.5 304.3 239.1 304.3z"></path></svg>
      <input autocomplete="off" id="logemail" placeholder="Email" class="input-field" name="logemail" type="email">
    </div>
    <div class="field">
      <svg class="input-icon" xmlns="http://www.w3.org/2000/svg" xml:space="preserve" width="655.359" height="655.359" style="shape-rendering:geometricPrecision;text-rendering:geometricPrecision;image-rendering:optimizeQuality;fill-rule:evenodd;clip-rule:evenodd" viewBox="0 0 6.827 6.827">
    <defs>
        <style>.fil0{fill:none}.fil2{fill:#ffeba7}</style>
    </defs>
    <g id="Layer_x0020_1">
        <g id="_491463032">
            <path id="_491463320" class="fil0" d="M0 0h6.827v6.827H0z"/>
            <path id="_491463128" class="fil0" d="M.853.853h5.12v5.12H.853z"/>
        </g>
        <g id="_491478824">
            <path id="_491463224" d="M.909 2.24c.067 1.39 1.968 3.158 3.255 3.57.863.275 2.148-.269 1.64-.777L5 4.23c-.122-.123-.32-.108-.439.01l-.46.462c-.992-.54-1.408-.966-1.953-1.951l.462-.462c.119-.119.132-.317.01-.439l-.803-.803C1.37.598.883 1.715.908 2.24z" style="fill:#ffeba7"/>
            <path id="_491478584" class="fil2" d="m.909 2.24 1.24.51.462-.46c.119-.12.132-.318.01-.44l-.803-.803C1.37.598.883 1.715.908 2.24z"/>
            <path id="_491478176" class="fil2" d="M4.164 5.81c.863.275 2.148-.269 1.64-.777L5 4.23c-.122-.123-.32-.108-.439.01l-.46.462.062 1.107z"/>
        </g>
    </g>
</svg>
            <input autocomplete="off" id="telephone" placeholder="Telephone" class="input-field" name="logphone" type="telephone">
      
    </div>
    <div class="field">
      <svg class="input-icon" viewBox="0 0 500 500" xmlns="http://www.w3.org/2000/svg">
      <path d="M80 192V144C80 64.47 144.5 0 224 0C303.5 0 368 64.47 368 144V192H384C419.3 192 448 220.7 448 256V448C448 483.3 419.3 512 384 512H64C28.65 512 0 483.3 0 448V256C0 220.7 28.65 192 64 192H80zM144 192H304V144C304 99.82 268.2 64 224 64C179.8 64 144 99.82 144 144V192z"></path></svg>
      <input autocomplete="off" id="logpass" placeholder="Password" class="input-field" name="logpass" type="password">
    </div>
    <button class="btn" type="submit">Login</button>

  </form>
</div>
</form>
</center>
    </body>
</html>






