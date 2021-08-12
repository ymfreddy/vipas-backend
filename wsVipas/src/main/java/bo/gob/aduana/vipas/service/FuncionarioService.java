package bo.gob.aduana.vipas.service;

import bo.gob.aduana.vipas.model.Funcionario;

public interface FuncionarioService {
	public Funcionario obtenerFuncionario (String nroDoc) throws Exception;
}
