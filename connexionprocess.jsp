<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>

<%
    // Étape 1: Établir la connexion à la base de données
    String url = "jdbc:mysql://localhost:3306/bdbd3"; // Mettez votre URL de base de données
    String user = "root";
    String password = "1234";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);

        // Étape 2: Récupérer les valeurs des champs saisis par l'utilisateur
        String cin = request.getParameter("logcin");
        String email = request.getParameter("logemail");
        String telephone = request.getParameter("logphone");


        // Étape 3: Effectuer une requête SQL pour récupérer les données du client correspondant
        String query = "SELECT * FROM client WHERE cin=? AND email=? AND telephone=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, cin);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, telephone);

        ResultSet resultSet = preparedStatement.executeQuery();

        // Étape 4: Comparer les valeurs saisies par l'utilisateur avec celles récupérées de la base de données
        if (resultSet.next()) {
            // Les informations sont correctes, autorisez l'accès (vous pouvez ajouter une redirection ici)
            response.sendRedirect("chambresytry.jsp");
        } else {
            // Les informations sont incorrectes, affichez un message d'erreur
            out.println("<script>alert('Informations incorrectes. Veuillez réessayer.');</script>");
        }

        // Étape 5: Fermer les ressources
        resultSet.close();
        preparedStatement.close();
        connection.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
%>
