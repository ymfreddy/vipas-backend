package bo.gob.aduana.vipas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.aduana.vipas.model.Funcionario;
import bo.gob.aduana.vipas.repository.FuncionarioRepository;
import bo.gob.aduana.vipas.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	@Autowired
    protected FuncionarioRepository funcionarioRepository;
	
	@Override
	public Funcionario obtenerFuncionario (String nroDoc) throws Exception {			
		return funcionarioRepository.obtenerFuncionario(nroDoc);	
	}
}
