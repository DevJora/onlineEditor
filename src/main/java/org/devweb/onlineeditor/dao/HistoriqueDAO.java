
package org.devweb.onlineeditor.dao;

import org.devweb.onlineeditor.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistoriqueDAO implements IHistoriqueDAO{
    private DaoFactory daoFactory;
    private DocumentDAO documentDAO;
    private UtilisateurDao utilisateurDao;
    HistoriqueDAO(DaoFactory df){
        this.daoFactory = df;
        df = DaoFactory.getInstance();
        utilisateurDao = df.getUtilisateurDAO();
        documentDAO = df.getDocumentDAO();
    }

    @Override
    public boolean ajouterHistorique(document doc, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("insert into historic(id_user, id_doc, content_doc, date) values(?, ?, ?, ?); ");
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, doc.getId());
            preparedStatement.setString(3, doc.getContenu());

            //date
            LocalDateTime dt = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String txt = dt.format(formatter);
            LocalDateTime date = LocalDateTime.parse(txt, formatter);

            preparedStatement.setString(4, date.toString());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<historique> afficherHistorique(document doc, utilisateur user){

        List<historique> historiques = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select distinct * from historic inner join user on user.id = historic.id_user inner join document on historic.id_doc = document.id  where id_doc=?;");
            preparedStatement.setInt(1, doc.getId());
            result = preparedStatement.executeQuery();
            while (result.next()){
                historique historique = new historique();
                int user_id = result.getInt("id_user");
                int id_doc = result.getInt("id_doc");
                String contenu = result.getString("content_doc");
                String date = result.getString("date");
                historique.setDate(date);
                historique.setContenu_document(contenu);
                historique.setDocument(doc);
                String code = result.getString("code_collab");
                document doc1 = documentDAO.getDocument(doc.getId());
                doc1.setContenu(contenu);
                historique.setDocument(doc);
                historique.setUtilisateur(user);
                historiques.add(historique);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return historiques;
    }

    public historique getHistorique(String date, utilisateur user){
        historique historique = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from historic where date = ?; ");
            preparedStatement.setString(1, date);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                String contenu = result.getString("content_doc");
                historique.setDate(date);
                historique.setContenu_document(contenu);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return historique;
    }
}