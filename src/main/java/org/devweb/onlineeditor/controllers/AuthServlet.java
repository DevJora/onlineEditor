package org.devweb.onlineeditor.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.websocket.Session;
import org.devweb.onlineeditor.model.utilisateur;

import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/authentification")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(( session.getAttribute("utilisateur")) != null)
            response.sendRedirect(request.getContextPath() + "/home");
        else
            this.getServletContext().getRequestDispatcher("/WEB-INF/auth.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}