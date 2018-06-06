package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import static proyecto.Login.passwordUser;


/**
 * Clase que se encarga de realizar las consultas a la base de datos.
 */
public class dbQuerys {

    MyDataAcces conexion = new MyDataAcces();

    /**
     * The resultado.
     */
    ResultSet resultado;

    ResultSet resultado2;

    String userName;
    String password;
    String pass;
    String newUser;
    String newUserName;
    String newPass;
    String newUserPass;

    /**
     * Instantiates a new db querys.
     *
     * @throws SQLException the SQL exception
     */
    public dbQuerys() throws SQLException {

    }

    /**
     *
     * Metodo que se encarga de realizar las consultas para el login de usuarios
     *
     * @return true Si el usuario y la contraseña existen en la base de datos. false Si el usuario y la contraseña no existen
     * @throws SQLException the SQL exception
     */
    public boolean Login() throws SQLException {
        
        userName = Login.userName;
        password = Login.passwordUser;

        resultado = conexion.getQuery("SELECT * FROM users WHERE username = '" + userName + "'");

        resultado2 = conexion.getQuery("SELECT password FROM users WHERE username = '" + userName + "'");
        
        while (resultado2.next()) {
            
            pass = resultado2.getString("password");
        }

        if (pass.equals(password)) {
            
            return true;
        } 
        else {
            return false;
        }
    }

    /**
     * Metodo que se encarga de realizar las consultas para el registro de usuarios
     * @return 
     * @throws SQLException 
     */
    public boolean Register() throws SQLException {

        newUserName = Registro.newUser;
        newUserPass = Registro.newPass;
        
        String queryNewUser = "INSERT INTO users (username, password) "
                + "VALUES ('" + newUserName + "', md5('" + newUserPass + "'));";
        System.out.println(queryNewUser);
        conexion.updateQuery(queryNewUser);
        
        return true;
    }
}
