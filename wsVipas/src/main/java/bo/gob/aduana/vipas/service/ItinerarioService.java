package bo.gob.aduana.vipas.service;

import java.util.List;

import bo.gob.aduana.vipas.model.Itinerario;

public interface ItinerarioService {
	public List<Itinerario> obtenerItinerarios(String nroCom);
}
