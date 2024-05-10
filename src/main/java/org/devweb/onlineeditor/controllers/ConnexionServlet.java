package org.devweb.onlineeditor.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.devweb.onlineeditor.forms.ConnexionForm;
import org.devweb.onlineeditor.models.user.Utilisateur;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ConnexionServlet", value = "/connexion")
public class ConnexionServlet extends HttpServlet {
    Connection connexion = null;
    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/WEB-INF/connexion.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("login");
        String password = request.getParameter("pwd");

        // Vérification de l'authenticité des informations
        boolean isValid = validate(username, password);

        if (isValid) {
            // Authentification réussie
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            System.out.println("utilisateur connecté");
            response.sendRedirect("index.jsp");
        } else {
            // Authentification échouée
            response.sendRedirect(VUE);
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

    private boolean validate(String username, String password) {
        String url = "jdbc:mysql://localhost:3300/editor?serverTimezone=UTC";
        String user = "root";
        String pwd = "Rachel.64";

        loadDatabase();
        PreparedStatement ps = null;
        try {
            ps = connexion.prepareStatement("SELECT * FROM user WHERE pseudo=? AND mdp=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        /*try {
            Connection connexion = ParamBD.getConnection();

            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return false;
    }
}