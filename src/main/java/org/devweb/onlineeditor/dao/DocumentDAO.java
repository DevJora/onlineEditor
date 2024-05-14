package org.devweb.onlineeditor.dao;

import org.devweb.onlineeditor.model.document;
import org.devweb.onlineeditor.model.utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentDAO implements IDocumentDAO {
    private DaoFactory daoFactory;
    DocumentDAO(DaoFactory df){
        this.daoFactory = df;
    }

    @Override
    public document modifier(document doc) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE document SET content= ? where id = ?";

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, doc.getContenu());
            preparedStatement.setInt(2, doc.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Document "+ doc.getTitre() + "modifié. ");
            }
            doc = getDocument(doc.getId());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return doc;
    }

    @Override
    public boolean supprimer(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("delete from document where id = ?; ");
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean ajouter(document doc, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("insert into document(user_id, content, title, code_collab) values (?, ?, ?, ?); ");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, doc.getContenu());
            preparedStatement.setString(3, doc.getTitre());
            preparedStatement.setString(4, doc.getCode_collab());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public document getDocument(int id) {
        document document = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from document where id = ?; ");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                int user_id = result.getInt("user_id");
                String contenu = result.getString("content");
                String titre = result.getString("title");
                String code = result.getString("code_collab");


                document = new document(titre);
                document.setId(id);
                document.setContenu(contenu);
                document.setCode_collab(code);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return document;
    }

    @Override
    public document getDocumentByCode(String code) {
        document document = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from document where code_collab = ?; ");
            preparedStatement.setString(1, code);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                int user_id = result.getInt("user_id");
                String contenu = result.getString("content");
                String titre = result.getString("title");
                int id = result.getInt("id");


                document = new document(titre);
                document.setCode_collab(code);
                document.setContenu(contenu);
                document.setId(id);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return document;
    }

    @Override
    public List<document> lister(int id) {
        List<document> documents = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;


        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from document where user_id = ?; ");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            while (result.next()){
                int user_id = id;
                int id_doc = result.getInt("id");
                String contenu = result.getString("content");
                String titre = result.getString("title");
                String code = result.getString("code_collab");

                document doc = new document();
                doc.setId(id_doc);
                doc.setUser_id(user_id);
                doc.setContenu(contenu);
                doc.setTitre(titre);
                doc.setCode_collab(code);
                System.out.println(doc.getTitre());
                documents.add(doc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return documents;
    }

    @Override
    public List<document> listerCollab(int id) {
        List<document> documents = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select distinct * from document inner join collaboration on document.id = collaboration.id_document where id_user=?;");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            while (result.next()){
                int user_id = id;
                int id_doc = result.getInt("id");
                String contenu = result.getString("content");
                String titre = result.getString("title");
                String code = result.getString("code_collab");

                document doc = new document();
                doc.setId(id_doc);
                doc.setUser_id(user_id);
                doc.setContenu(contenu);
                doc.setTitre(titre);
                doc.setCode_collab(code);
                System.out.println(doc.getTitre());
                documents.add(doc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return documents;
    }

}
