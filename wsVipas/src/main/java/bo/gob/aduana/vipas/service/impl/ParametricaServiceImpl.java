package bo.gob.aduana.vipas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.aduana.vipas.model.Parametrica;
import bo.gob.aduana.vipas.repository.ParametricaRepository;
import bo.gob.aduana.vipas.service.ParametricaService;

@Service
public class ParametricaServiceImpl implements ParametricaService{
	@Autowired
    protected ParametricaRepository parametricaRepository;
	
	public List<Parametrica> getParametricas(){
		List<Parametrica> res= parametricaRepository.getParametricas();
		return res;
	}
}
