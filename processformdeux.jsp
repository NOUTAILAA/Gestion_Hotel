<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>NOUTIYAFH RESERVATION</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="chambresytry.css">
</head>
<body>

<%
    String cin = request.getParameter("cin");
    String nomclient = request.getParameter("nomclient");
    String date_debut = request.getParameter("date_debut");
    String date_fin = request.getParameter("date_fin");
    String nbr_chambres = request.getParameter("nbr_chambres");
    String type_chambre = request.getParameter("type_chambre");

    Connection conn = null;
    PreparedStatement stmt = null;
    PreparedStatement checkAvailabilityStmt = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bdbd3";
        String username = "root";
        String password = "1234";
        conn = DriverManager.getConnection(url, username, password);

        // Vérification de la disponibilité
        String checkAvailabilityQuery = "SELECT COUNT(*) FROM reservations WHERE type_chambre = ? AND ((date_debut < ? AND date_fin > ?) OR (date_debut < ? AND date_fin > ?))";
        checkAvailabilityStmt = conn.prepareStatement(checkAvailabilityQuery);
        checkAvailabilityStmt.setString(1, type_chambre);
        checkAvailabilityStmt.setString(2, date_fin);
        checkAvailabilityStmt.setString(3, date_debut);
        checkAvailabilityStmt.setString(4, date_fin);
        checkAvailabilityStmt.setString(5, date_debut);
        ResultSet resultSet = checkAvailabilityStmt.executeQuery();

        boolean isAvailable = true;
        if (resultSet.next() && resultSet.getInt(1) > 0) {
            isAvailable = false;
        }

        if (isAvailable) {
            String sql = "INSERT INTO reservations (cin, nomclient, date_debut, date_fin, nbr_chambres, type_chambre) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cin);
            stmt.setString(2, nomclient);
            stmt.setString(3, date_debut);
            stmt.setString(4, date_fin);
            stmt.setString(5, nbr_chambres);
            stmt.setString(6, type_chambre);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                String redirectUrl = "resevationSuccess.jsp?name=" + URLEncoder.encode(nomclient, "UTF-8") 
                    + "&startDate=" + URLEncoder.encode(date_debut, "UTF-8") 
                    + "&endDate=" + URLEncoder.encode(date_fin, "UTF-8") 
                    + "&roomType=" + URLEncoder.encode(type_chambre, "UTF-8") 
                    + "&numRooms=" + nbr_chambres;
                session.setAttribute("reservationSuccess", "true");
                response.sendRedirect(redirectUrl);
            } else {
            	
                session.setAttribute("reservationSuccess", "false");
            }
            response.sendRedirect("chambresytry.jsp");
        } else {
            session.setAttribute("reservationError", "Le nombre de chambres demandées n'est pas disponible pour les dates sélectionnées.");
            response.sendRedirect("chambresytry.jsp");
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (stmt != null) stmt.close(); } catch (Exception e) { }
        try { if (checkAvailabilityStmt != null) checkAvailabilityStmt.close(); } catch (Exception e) { }
        try { if (conn != null) conn.close(); } catch (Exception e) { }
    }
    

%>

</body>
</html>
