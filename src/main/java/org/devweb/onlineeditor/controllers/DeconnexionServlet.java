package org.devweb.onlineeditor.controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "DeconnexionServlet", value = "/logout")
public class DeconnexionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("connexion.jsp");
    }
}