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
    public void ajouter(document doc) {

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

                document doc = new document();
                doc.setId(id_doc);
                doc.setUser_id(user_id);
                doc.setContenu(contenu);

                documents.add(doc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return documents;
    }
}
