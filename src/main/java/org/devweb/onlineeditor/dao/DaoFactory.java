package org.devweb.onlineeditor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String pwd;

    DaoFactory(String url, String username, String pwd){
        this.url = url;
        this.username = username;
        this.pwd = pwd;
    }

    public static DaoFactory getInstance(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
        }

        DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3300/editor?serverTimezone=UTC", "root", "Rachel.64");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, pwd);
    }

    public  UtilisateurDao getUtilisateurDAO(){
        return  new UtilisateurDao(this);
    }

    public  CollaborationDAO getCollabDAO(){
        return  new CollaborationDAO(this);
    }

    public DocumentDAO getDocumentDAO(){
        return  new DocumentDAO(this);
    }

    public HistoriqueDAO getHistoriqueDAO() {
        return new HistoriqueDAO(this);
    }
}
