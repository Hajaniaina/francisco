/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

/**
 *
 * @author Bae
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Bae
 */
public class Connexion implements Database {
    public static Connection getConnexion()
    {
        Connection conn= null;
        try
        {
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(connURL,username,password);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        return conn;
    }
}
