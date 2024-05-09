package org.devweb.onlineeditor.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    public void init(){
        try {
            Class.forName(this.getServletContext().getInitParameter("JDBC_DRIVER"));
            String bdURL = this.getServletContext().getInitParameter("JDBC_URL");
            String bdLogin = this.getServletContext().getInitParameter("JDBC_LOGIN");
            String bdPwd = this.getServletContext().getInitParameter("JDBC_PASSWORD");
            Connection c = DriverManager.getConnection(bdURL, bdLogin, bdPwd);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("connected to database.");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}