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

@WebServlet(name = "SupDocumentServlet", value = "/supprimerdoc")
public class SupprimerDocumentServlet extends HttpServlet {
    DocumentDAO documentDAO;
    utilisateur user;
    @Override
    public void init() throws ServletException {
        DaoFactory df = DaoFactory.getInstance();
        documentDAO = df.getDocumentDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        try{
           id = Integer.parseInt(request.getParameter("id"));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        if(documentDAO.supprimer(id)){
            /*String urlPageActuelle = request.getRequestURI();
            //  sendRedirect pour recharger la page en redirigeant vers l'URL actuelle
            response.sendRedirect(urlPageActuelle);*/
            String urlServlet = request.getContextPath() + "/home";
            // sendRedirect pour rediriger vers l'URL de l'edition
            response.sendRedirect(urlServlet);
        }else {
            System.out.println("erreur de suppression du document.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}