package bo.gob.aduana.vipas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.aduana.vipas.model.Itinerario;
import bo.gob.aduana.vipas.repository.ItinerarioRepository;
import bo.gob.aduana.vipas.service.ItinerarioService;

@Service
public class ItinerarioServiceImpl implements ItinerarioService{
	@Autowired
    protected ItinerarioRepository itinerarioRepository;
	
	@Override
	public List<Itinerario> obtenerItinerarios(String nroCom){		
		return itinerarioRepository.obtenerItinerarios(nroCom);		
	}
}
