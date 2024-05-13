package org.devweb.onlineeditor.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.devweb.onlineeditor.dao.DaoFactory;
import org.devweb.onlineeditor.dao.DocumentDAO;
import org.devweb.onlineeditor.model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditorServlet", value = "/editor")
public class EditorServlet extends HttpServlet {
    List<document> docs = new ArrayList<>();
    private DocumentDAO documentDAO;
    private utilisateur user;

    @Override
    public void init() throws ServletException {
        DaoFactory df = DaoFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user = (utilisateur) request.getAttribute("utilisateur");
        request.setAttribute("documents", documentDAO.lister(user.getId()));
        System.out.println(docs);
        this.getServletContext().getRequestDispatcher("/editor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}