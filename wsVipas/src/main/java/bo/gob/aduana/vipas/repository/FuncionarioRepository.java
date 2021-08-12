package bo.gob.aduana.vipas.repository;

import bo.gob.aduana.vipas.model.Funcionario;

public interface FuncionarioRepository {
	public Funcionario obtenerFuncionario (String nroDoc) throws Exception;
}
