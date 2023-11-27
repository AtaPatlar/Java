package Utility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

public Connection getConnection(){

        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/deneme";
        String username = "postgres";
        String password = "root";
        try {
            Driver.class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,username,password);
            return connection;
        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
            System.out.println("Driver hatası");
        }
        catch (SQLException s){
            s.printStackTrace();
            System.out.println("SQL hatası");
        }
        return connection;
    }
public boolean closeConnection(Connection connection){
        try {
        connection.close();
        return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL hatası");
        }
        return false;
}
}
