package bo.gob.aduana.vipas.repository.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import bo.gob.aduana.vipas.exception.DataBaseException;


@Service
public class OracleConnectionSidunea {
	@Autowired
	Environment env;
	
	private Connection con = null;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
  
    public Connection openConnection() throws DataBaseException {
    	
    	try{            
    		InitialContext ic = new InitialContext();
    		DataSource ds = (DataSource) ic.lookup("java:/Set");
    		con = ds.getConnection();     		
        }catch (Exception e) {        	
            System.out.println("wsAuth E-001: " + e.getMessage());
            throw new DataBaseException("Hubo un error al abrir la conexión con la base de datos");
        }    	
        return con;
    }

    /*public Connection openConnection() throws Exception {
    	String driver = env.getProperty("oracle.driver");
    	String url = env.getProperty("oracle.url");
    	String user = env.getProperty("oracle.user");
    	String pass = env.getProperty("oracle.password");
    	try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException("Hubo un error al abrir la conexión con la base de datos");
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        return con;
    }*/    
    
    public void closeConnection() {
        try{
            if (con != null) {
                con.close();
            }
            con = null;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}