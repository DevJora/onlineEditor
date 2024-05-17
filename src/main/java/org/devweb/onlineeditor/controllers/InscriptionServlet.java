package org.devweb.onlineeditor.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.*;

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
            response.sendRedirect(request.getContextPath()+"/connexion");
        } else {
            // Gestion des erreurs d'inscription
	    request.setAttribute("error", "L'e-mail fourni est déjà utilisé. Veuillez en choisir un autre.");          
            response.sendRedirect(request.getContextPath()+"/inscription");
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
        loadDatabase();

        // Vérifier si l'e-mail existe déjà
        PreparedStatement checkStmt = null;
        ResultSet resultSet = null;
        try {
            checkStmt = connexion.prepareStatement("SELECT COUNT(*) FROM user WHERE mail = ?");
            checkStmt.setString(1, mail);
            resultSet = checkStmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count > 0) {
                // L'e-mail existe déjà, retourner false
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (checkStmt != null) {
                    checkStmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Insertion de l'utilisateur dans la base de données
        PreparedStatement insertStmt = null;
        try {
            insertStmt = connexion.prepareStatement("INSERT INTO user (pseudo, mail, mdp) VALUES (?, ?, ?)");
            insertStmt.setString(1, pseudo);
            insertStmt.setString(2, mail);
            insertStmt.setString(3, password);
            int rowsAffected = insertStmt.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (insertStmt != null) {
                    insertStmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}