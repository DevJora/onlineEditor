package org.devweb.onlineeditor.dao;

import org.devweb.onlineeditor.model.document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CollaborationDAO implements ICollaborationDAO {
    private DaoFactory daoFactory;
    CollaborationDAO(DaoFactory df){
        this.daoFactory = df;
    }
    @Override
    public boolean ajouterCollaboration(document doc, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("insert into collaboration(id_user, id_document) values(?, ?); ");
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, doc.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
