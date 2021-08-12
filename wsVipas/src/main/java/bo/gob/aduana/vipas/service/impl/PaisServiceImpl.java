package bo.gob.aduana.vipas.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.gob.aduana.vipas.model.Pais;
import bo.gob.aduana.vipas.repository.PaisRepository;
import bo.gob.aduana.vipas.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService{
	
	@Autowired
    protected PaisRepository paisRepository;
	
	public List<Pais> getPaises(){
		List<Pais> res= paisRepository.getPaises();
		return res;
	}
}
