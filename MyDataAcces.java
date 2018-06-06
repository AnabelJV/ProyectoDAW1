package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;

// TODO: Auto-generated Javadoc
/**
 * Clase que se encarga de la conexion a la base de datos
 */
public class MyDataAcces {
	
	/** The usuario. */
	String _usuario="u634818610_ana";
	
	/** The pwd. */
	String _pwd= "hola1234";
	
	/** The bd. */
	String _bd="u634818610_dbana";
	
	/** The url. */
	String _url = "jdbc:mysql://sql151.main-hosting.eu/"+_bd;
	
	/** The conn. */
	Connection conn = null;
	
	/**
	 * Instantiates a new my data acces.
	 *
	 * @throws SQLException the SQL exception
	 */
	public MyDataAcces() throws SQLException {
		
		try{
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
			if(conn != null)
			{
				
			}
		}
		catch(SQLException ex)
		{
			System.out.println("Hubo un problema al intentar conecarse a la base de datos"+_url);
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println(ex);
		}	

	}
	
	/**
	 * Metodo que permite realizar una consulta en la base de datos
	 *
	 * @param _query Consulta a realizar
	 * @return Devuelve el resultado de la consulta
	 * @throws SQLException the SQL exception
	 */
	public ResultSet getQuery(String _query) throws SQLException{
		Statement state = null;
		ResultSet resultado = null;
		state = (Statement) conn.createStatement();
		resultado = state.executeQuery(_query);
		return resultado;
	}
	
	/**
	 * Metodo que permite insertar o actualizar registros en la base de datos
	 *
	 * @param _query Consulta a realizar
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public int updateQuery(String _query) throws SQLException{
		Statement state = null;
		int algo;
		state = (Statement) conn.createStatement();
		algo = state.executeUpdate(_query);
		return algo;
	}
	
	/**
	 * Sets the query.
	 *
	 * @param _query the new query
	 * @throws SQLException the SQL exception
	 */
	public void setQuery(String _query) throws SQLException{
		Statement state = null;	
		state=(Statement) conn.createStatement();
		state.execute(_query);
	}
}
