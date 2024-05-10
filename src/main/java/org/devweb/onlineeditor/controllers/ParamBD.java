package org.devweb.onlineeditor.controllers;

import java.sql.*;

public class ParamBD {
        public static Connection getConnection(){
            String url = "jdbc:mysql://localhost:3300/editor?serverTimezone=UTC";
            String username = "root";
            String pwd = "Rachel.64";
            Connection connexion = null;
            try {
                 connexion = DriverManager.getConnection(url, username, pwd);
                Statement statement = connexion.createStatement();
                //statement.executeUpdate("INSERT INTO utilisateur(nom, prenom, email, pwd) VALUES ('test', 'test', 'test@xyz', '1234')");
                ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

                while(resultSet.next()){
                    System.out.println("id: "+ resultSet.getInt("id") );
                    System.out.println("pseudo: "+ resultSet.getString("pseudo") );
                    System.out.println("mail: "+ resultSet.getString("mail") );
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
            return connexion;
        }

        public static void loadDatabase(Connection connexion) {
            // Chargement du driver
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                connexion = DriverManager.getConnection("jdbc:mysql://localhost:3300/editor?serverTimezone=UTC", "root", "Rachel.64");
                System.out.println("Connexion à la bdd");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
