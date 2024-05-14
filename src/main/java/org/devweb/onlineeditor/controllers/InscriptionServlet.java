package org.devweb.onlineeditor.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "InscriptionServlet", value = "/inscription")
public class InscriptionServlet extends HttpServlet {
    Connection connexion;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(( session.getAttribute("utilisateur")) != null)
            response.sendRedirect(request.getContextPath() + "/home");
        else
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String pseudo = request.getParameter("pseudo");
        String pwd = request.getParameter("pwd");

        // Insertion de l'utilisateur dans la base de données
        boolean isSuccess = registerUser(mail, pseudo, pwd);

        if (isSuccess) {
            // Redirection vers la page de connexion après l'inscription réussie
            response.sendRedirect("index.jsp");
        } else {
            // Gestion des erreurs d'inscription
            response.sendRedirect("WEB-INF/inscription.jsp");
        }
    }

    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3300/editor?serverTimezone=UTC", "root", "Rachel.64");
            System.out.println("Connexion à la bdd");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean registerUser(String mail, String pseudo, String password) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String dbUsername = "your_username";
        String dbPassword = "your_password";

       loadDatabase();

        PreparedStatement ps = null;
        try {
            ps = connexion.prepareStatement("INSERT INTO user (pseudo, mail, mdp) VALUES (?, ?, ?)");
            ps.setString(1, pseudo);
            ps.setString(2, mail);
            ps.setString(3, password);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}