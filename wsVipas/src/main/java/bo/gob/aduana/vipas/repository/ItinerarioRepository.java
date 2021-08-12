package bo.gob.aduana.vipas.repository;

import java.util.List;

import bo.gob.aduana.vipas.model.Itinerario;
import bo.gob.aduana.vipas.repository.entity.KeyVipItinerario;


public interface ItinerarioRepository {
	public Itinerario guardarItinerario(Itinerario itinerario);
	public String eliminarItinerario(KeyVipItinerario id);
	public String eliminarItinerarios(String nroCom);
	public Itinerario obtenerItinerario(KeyVipItinerario id);
	public List<Itinerario> obtenerItinerarios(String nroCom);
}
