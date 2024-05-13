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

                document doc = new document();
                doc.setId(id_doc);
                doc.setUser_id(user_id);
                doc.setContenu(contenu);
                System.out.println(doc.getContenu());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    DataBase(){


    }
}
