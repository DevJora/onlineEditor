import java.sql.*;

public class DataBase {
    private static Connection connection;

    public static void main(String[] args)  {

        String url = "jdbc:mysql://localhost:3300/editor?serverTimezone=UTC";
        String username = "root";
        String pwd = "Rachel.64";
        try {
            Connection connexion = DriverManager.getConnection(url, username, pwd);
            Statement statement = connexion.createStatement();
            //statement.executeUpdate("INSERT INTO utilisateur(nom, prenom, email, pwd) VALUES ('test', 'test', 'test@xyz', '1234')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM utilisateur");

            while(resultSet.next()){
                System.out.println("id: "+ resultSet.getInt("id") );
                System.out.println("nom: "+ resultSet.getString("nom") );
                System.out.println("prenom: "+ resultSet.getString("prenom") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    DataBase(){


    }
}
