package bo.gob.aduana.vipas.repository.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bo.gob.aduana.vipas.model.Comision;
import oracle.jdbc.OracleTypes;

@Repository
public class MemorandumDaoRepository {
	@Autowired
	OracleConnectionRrhh oracleConnectionRrhh;
	public Comision verificarMemorandum (String nroMemo) throws Exception{
		Comision comision = null;	
		Connection con = null;
		CallableStatement call = null;
		try {
			con = oracleConnectionRrhh.openConnection();
			call = con.prepareCall("{?=call pkg_vipas.f_verifica_memorandum(?,?,?)}");
			call.registerOutParameter(1, OracleTypes.CURSOR);	
			call.setString(2, nroMemo);
			call.registerOutParameter(3, OracleTypes.VARCHAR);
			call.registerOutParameter(4, OracleTypes.VARCHAR);
			call.execute();
			String res = (String) call.getObject(4);
			if (res.equals("OK"))
			{
				ResultSet rs = (ResultSet) call.getObject(1);
				if (!(rs == null || !rs.next())) {
					do {
						comision=new Comision();
						//comision.setNroDoc(rs.getString("COD_FUNCIONARIO"));
						comision.setNombres(rs.getString("fun_nombre1"));
						comision.setPrimerAp(rs.getString("fun_paterno"));
						comision.setSegundoAp(rs.getString("fun_materno"));
						comision.setNroDoc(rs.getString("fun_numero_documento"));
						comision.setEmail(rs.getString("fun_email_int"));
						comision.setCelular(rs.getString("fun_celular"));
						comision.setCargo(rs.getString("car_cargo_funcional"));
						comision.setDepartamento(rs.getString("dep_nombre_departamento"));
						comision.setGerencia(rs.getString("uni_gral2"));	
						comision.setMemorandum(nroMemo);
						comision.setFechaMemo((String) call.getObject(3)); 
						comision.setOrigen("RRHH");
					} while (rs.next());
				}
			}
			else {
				throw new  Exception(res);
			}
		} catch (Exception e) {
			throw new  Exception(e.getMessage());
		} finally {
			oracleConnectionRrhh.closeConnection();
		}
		return comision;
	}
}
