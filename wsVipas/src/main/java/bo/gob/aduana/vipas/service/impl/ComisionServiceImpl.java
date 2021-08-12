package bo.gob.aduana.vipas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.gob.aduana.vipas.model.Comision;
import bo.gob.aduana.vipas.model.Itinerario;
import bo.gob.aduana.vipas.repository.ComisionRepository;
import bo.gob.aduana.vipas.repository.ItinerarioRepository;
import bo.gob.aduana.vipas.service.ComisionService;

@Service
public class ComisionServiceImpl implements ComisionService{
	@Autowired
    protected ComisionRepository comisionRepository;	
	@Autowired
    protected ItinerarioRepository itinerarioRepository;
		
	@Override
	public Comision obtenerComision(String nroCom){	
		Comision res = comisionRepository.obtenerComision(nroCom);		
		List<Itinerario> lis = itinerarioRepository.obtenerItinerarios(nroCom);
		if (lis.isEmpty())
			lis = new ArrayList<Itinerario>(); 
		if (res != null)
			res.setItinerarios(lis);
		return res;
	}
	
	@Override
	public List<Comision> obtenerComisiones(String gerencia){	
		List<Comision> res = comisionRepository.obtenerComisiones(gerencia);		
		if (res.isEmpty())
			res = new ArrayList<Comision>();
		return res;
	}	
}
