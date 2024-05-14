import org.devweb.onlineeditor.model.document;

import java.sql.*;

public class DataBase {
    private static Connection connection;

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3300/editor?serverTimezone=UTC";
        String username = "root";
        String pwd = "Rachel.64";
        try {
            connection = DriverManager.getConnection(url, username, pwd);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from document where user_id = ?; ");
            preparedStatement.setInt(1, 1);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                int user_id = 1;
                int id_doc = result.getInt("id");
                String contenu = result.getString("content");
                String titre = result.getString("title");

                document doc = new document();
                doc.setId(id_doc);
                doc.setUser_id(user_id);
                doc.setContenu(contenu);
                doc.setTitre(titre);
                System.out.println(doc.getTitre());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, username, pwd);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into document(user_id, content, title) values (?, ?, ?); ");
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "test");
            preparedStatement.setString(3, "test");
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("test réussi");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, username, pwd);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from document where id = ?; ");
            preparedStatement.setInt(1, 6);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("suppression réussi");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


        try {
            connection = DriverManager.getConnection(url, username, pwd);
            PreparedStatement preparedStatement = connection.prepareStatement("Update document SET content='^S?????' where id= 20;");
            /*preparedStatement.setString(1, "Texte modifié");
            preparedStatement.setInt(2, 23 );*/

            System.out.println("Document modifié. ");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    DataBase(){


    }
}
