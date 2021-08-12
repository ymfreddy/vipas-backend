package bo.gob.aduana.vipas.repository.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bo.gob.aduana.vipas.model.Funcionario;
import oracle.jdbc.OracleTypes;

@Repository
public class FuncionarioDaoRepository {	
	
	@Autowired
	OracleConnectionRrhh oracleConnectionRrhh;
	
	public Funcionario obtenerFuncionario (String nroDoc)	throws Exception{
		Funcionario funcionario = null;	
		Connection con = null;
		CallableStatement call = null;
		try {
			con = oracleConnectionRrhh.openConnection();
			call = con.prepareCall("{?=call pkg_vipas.f_obtener_funcionario(?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);	
			call.setString(2, nroDoc);
			call.execute();
			
				ResultSet rs = (ResultSet) call.getObject(1);
				if (!(rs == null || !rs.next())) {
					do {
						funcionario=new Funcionario();
						funcionario.setCodFuncionario(rs.getString("COD_FUNCIONARIO"));
						funcionario.setNombres(rs.getString("FUN_NOMBRE"));
						funcionario.setPrimerAp(rs.getString("FUN_PATERNO"));
						funcionario.setSegundoAp(rs.getString("FUN_MATERNO"));
						funcionario.setNroDoc(rs.getString("FUN_NUMERO_DOCUMENTO"));
						funcionario.setEmail(rs.getString("fun_email_int"));
						funcionario.setCelular(rs.getString("fun_celular"));
						funcionario.setCargo(rs.getString("cargo_funcional"));
						funcionario.setDepartamento(rs.getString("DEPARTAMENTO"));
						funcionario.setGerencia(rs.getString("GERENCIA"));						
					} while (rs.next());
				}
						
			
		} catch (Exception e) {
			throw new  Exception(e.getMessage());
		} finally {
			oracleConnectionRrhh.closeConnection();
		}
		return funcionario;
	}
}
