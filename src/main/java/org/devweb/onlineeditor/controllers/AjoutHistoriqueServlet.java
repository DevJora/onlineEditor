
package org.devweb.onlineeditor.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.devweb.onlineeditor.dao.DaoFactory;
import org.devweb.onlineeditor.dao.HistoriqueDAO;
import org.devweb.onlineeditor.model.*;

        import java.io.IOException;

@WebServlet(name = "AjoutHistoriqueServlet", value = "/ajouthistorique")
public class AjoutHistoriqueServlet extends HttpServlet {
    HistoriqueDAO historiqueDAO;
    utilisateur utilisateur;
    @Override
    public void init() throws ServletException {
        DaoFactory df = DaoFactory.getInstance();
        historiqueDAO = df.getHistoriqueDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        document document = (document) session.getAttribute("document");
        utilisateur = (utilisateur) session.getAttribute("utilisateur");

        if(utilisateur != null){
            if(historiqueDAO.ajouterHistorique(document, utilisateur.getId())){
                // sendRedirect pour rediriger vers l'URL de l'edition
                response.sendRedirect("editor?id="+document.getId());

            }else {
                System.out.println("erreur de création du document.");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}