package org.devweb.onlineeditor.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.devweb.onlineeditor.dao.DaoFactory;
import org.devweb.onlineeditor.dao.DocumentDAO;
import org.devweb.onlineeditor.model.*;

import java.io.IOException;

@WebServlet(name = "AjoutDocumentServlet", value = "/ajoutdoc")
public class AjoutDocumentServlet extends HttpServlet {
    DocumentDAO documentDAO;
    utilisateur user;
    @Override
    public void init() throws ServletException {
        DaoFactory df = DaoFactory.getInstance();
        documentDAO = df.getDocumentDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        user = (utilisateur) session.getAttribute("utilisateur");
        String titreDocument = request.getParameter("titreDocument");
        if(titreDocument == "" || titreDocument == null) titreDocument = "Sans titre";
        document doc = new document(titreDocument);
        if(documentDAO.ajouter(doc, user.getId())){
            String urlServlet = request.getContextPath() + "/home";
            // sendRedirect pour rediriger vers l'URL de l'edition
            response.sendRedirect(urlServlet);
        }else {
            System.out.println("erreur de création du document.");
        }
    }
}