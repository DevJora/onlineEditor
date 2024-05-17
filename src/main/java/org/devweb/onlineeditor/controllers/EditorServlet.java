package org.devweb.onlineeditor.controllers;


import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.devweb.onlineeditor.dao.DaoFactory;
import org.devweb.onlineeditor.dao.DocumentDAO;
import org.devweb.onlineeditor.dao.HistoriqueDAO;
import org.devweb.onlineeditor.model.*;

import javax.json.JsonObject;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditorServlet", value = "/editor")
public class EditorServlet extends HttpServlet {
    document doc;
    private DocumentDAO documentDAO;
    private utilisateur user;
    private HistoriqueDAO historiqueDAO;

    private List<historique> historiques;

    @Override
    public void init() throws ServletException {
        DaoFactory df = DaoFactory.getInstance();
        documentDAO = df.getDocumentDAO();
        historiqueDAO = df.getHistoriqueDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = 0;
        try{
            id = Integer.parseInt(request.getParameter("id"));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        user = (utilisateur) session.getAttribute("utilisateur");
        if (user == null) {
            response.sendRedirect(request.getContextPath()+"/authentification");
        }else {
            doc = documentDAO.getDocument(id);
            session.setAttribute("document", doc);
            request.setAttribute("historiques", historiqueDAO.afficherHistorique(doc, user));

            Cookie pseudoCookie = new Cookie("pseudo", user.getPseudo());
            Cookie mailCookie = new Cookie("mail", user.getMail());
            Cookie iduserCookie = new Cookie("id", String.valueOf(user.getId()));

            Cookie iddocumentCookie = new Cookie("id_document", String.valueOf(doc.getId()));
            Cookie contenudocumentCookie = new Cookie("contenu_document", URLEncoder.encode(doc.getContenu(), "UTF-8"));
            Cookie titredocumentCookie = new Cookie("titre_document", URLEncoder.encode(doc.getTitre(), "UTF-8"));

            response.addCookie(pseudoCookie);

            response.addCookie(mailCookie);
            response.addCookie(iduserCookie);


            response.addCookie(iddocumentCookie);
            response.addCookie(contenudocumentCookie);
            response.addCookie(titredocumentCookie);



            this.getServletContext().getRequestDispatcher("/WEB-INF/editor.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}