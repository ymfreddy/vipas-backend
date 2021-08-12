package bo.gob.aduana.vipas.repository.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import bo.gob.aduana.vipas.exception.DataBaseException;


@Service
public class OracleConnectionRrhh {
	@Autowired
	Environment env;
	
	private Connection con = null;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public Connection openConnection() throws Exception {
    	String es_produccion=env.getProperty("es.produccion");
    	if (es_produccion.equals("0"))//es desarrollo
    	{
    		String driver = env.getProperty("oracle.driver");
        	String url = env.getProperty("oracle.rrhh.url");
        	String user = env.getProperty("oracle.rrhh.user");
        	String pass = env.getProperty("oracle.rrhh.password");
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
    	}
    	else
    	{
    		try{            
        		InitialContext ic = new InitialContext();
        		DataSource ds = (DataSource) ic.lookup("java:/Rrhh");
        		con = ds.getConnection();     		
            }catch (Exception e) {        	
                System.out.println("wsAuth E-001: " + e.getMessage());
                throw new DataBaseException("Hubo un error al abrir la conexión con la base de datos");
            }    	
            return con;
    	}    	
    }
  
    /*public Connection openConnection() throws DataBaseException {
    	
    	try{            
    		InitialContext ic = new InitialContext();
    		DataSource ds = (DataSource) ic.lookup("java:/Rrhh");
    		con = ds.getConnection();     		
        }catch (Exception e) {        	
            System.out.println("wsAuth E-001: " + e.getMessage());
            throw new DataBaseException("Hubo un error al abrir la conexión con la base de datos");
        }    	
        return con;
    }

    public Connection openConnection() throws Exception {
    	String driver = env.getProperty("oracle.driver");
    	String url = env.getProperty("oracle.rrhh.url");
    	String user = env.getProperty("oracle.rrhh.user");
    	String pass = env.getProperty("oracle.rrhh.password");
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
    }  */  
    
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