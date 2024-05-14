package org.devweb.onlineeditor.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.devweb.onlineeditor.dao.DaoFactory;
import org.devweb.onlineeditor.dao.DocumentDAO;
import org.devweb.onlineeditor.model.document;
import org.devweb.onlineeditor.model.utilisateur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    private DocumentDAO documentDAO;
    private utilisateur user;

    @Override
    public void init() throws ServletException {
        DaoFactory df = DaoFactory.getInstance();
        documentDAO = df.getDocumentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if((user = (utilisateur) session.getAttribute("utilisateur")) != null){
            request.setAttribute("documents", documentDAO.lister(user.getId()));
            request.setAttribute("documentsCollab", documentDAO.listerCollab(user.getId()));
            this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }else {
            String urlServlet = request.getContextPath() + "/authentification";
            // sendRedirect pour rediriger vers l'URL de l'edition
            response.sendRedirect(urlServlet);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}