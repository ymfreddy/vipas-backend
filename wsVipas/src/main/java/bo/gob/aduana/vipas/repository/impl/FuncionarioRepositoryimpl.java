package bo.gob.aduana.vipas.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import bo.gob.aduana.vipas.model.Funcionario;
import bo.gob.aduana.vipas.repository.FuncionarioRepository;
import bo.gob.aduana.vipas.repository.dao.FuncionarioDaoRepository;

@Repository
public class FuncionarioRepositoryimpl implements FuncionarioRepository{
	@Autowired 
	private FuncionarioDaoRepository funcionarioDaoRepository;
	
	@Override
	public Funcionario obtenerFuncionario (String nroDoc) throws Exception{		
		return funcionarioDaoRepository.obtenerFuncionario(nroDoc);		
	}
}
