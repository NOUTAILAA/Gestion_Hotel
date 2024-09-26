<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>



<%

    String cin = request.getParameter("cin");
    String firstname = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String confirmPassword = request.getParameter("confirmPassword");
    String telephone = request.getParameter("telephone");

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String errorMessage = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bdbd3";
        String DB_USER = "root";
        String DB_PASSWORD = "1234";

        connection = DriverManager.getConnection(url, DB_USER, DB_PASSWORD);

        // Check if cin, email, or telephone already exist
        String checkQuery = "SELECT * FROM client WHERE cin = ? OR email = ? OR telephone = ?";
        preparedStatement = connection.prepareStatement(checkQuery);
        preparedStatement.setString(1, cin);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, telephone);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            if (resultSet.getString("cin").equals(cin)) {
                errorMessage = "Error: Cin is already in use.";
            } else if (resultSet.getString("email").equals(email)) {
                errorMessage = "Error: Email is already in use.";
            } else if (resultSet.getString("telephone").equals(telephone)) {
                errorMessage = "Error: Telephone is already in use.";
            }
        } else {
            // Cin, email, and telephone are unique; proceed with the registration
            String insertQuery = "INSERT INTO client (cin, nom, prenom, email, telephone) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, cin);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, firstname);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, telephone);

            preparedStatement.executeUpdate();

            // Redirect to formdeux.jsp after successful registration
            response.sendRedirect("chambresytry.jsp");
            return;
        }
    } catch (Exception e) {
        e.printStackTrace();
        errorMessage = "Error: An unexpected error occurred.";
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Set the error message as a request attribute
    request.setAttribute("errorMessage", errorMessage);
    // Forward to registration.jsp
    request.getRequestDispatcher("reservation.jsp").forward(request, response);

%>

