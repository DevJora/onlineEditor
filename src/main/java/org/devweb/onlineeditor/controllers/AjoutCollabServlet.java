package org.devweb.onlineeditor.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import org.devweb.onlineeditor.dao.CollaborationDAO;
import org.devweb.onlineeditor.dao.DaoFactory;
import org.devweb.onlineeditor.dao.DocumentDAO;
import org.devweb.onlineeditor.model.*;

@WebServlet(name = "AjoutCollabServlet", value = "/ajoutcollab")
public class AjoutCollabServlet extends HttpServlet {

    DocumentDAO documentDAO;
    CollaborationDAO collaborationDAO;
    utilisateur user;

    document documentCollab;

    @Override
    public void init() throws ServletException {
        DaoFactory df = DaoFactory.getInstance();
        documentDAO = df.getDocumentDAO();
        collaborationDAO = df.getCollabDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        user = (utilisateur) session.getAttribute("utilisateur");
        documentCollab = documentDAO.getDocumentByCode(request.getParameter("code"));
        if(collaborationDAO.ajouterCollaboration(documentCollab, user.getId())){
            String urlServlet = request.getContextPath() + "/home";
            // sendRedirect pour rediriger vers l'URL de l'edition
            response.sendRedirect(urlServlet);
        }else {
            System.out.println("erreur de création du document.");
        }
    }
}