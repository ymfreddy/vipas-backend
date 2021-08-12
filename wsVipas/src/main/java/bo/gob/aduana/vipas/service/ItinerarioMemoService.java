package bo.gob.aduana.vipas.service;

import java.util.List;

import bo.gob.aduana.vipas.model.ItinerarioMemo;
import bo.gob.aduana.vipas.model.SimpleResponse;
import bo.gob.aduana.vipas.repository.entity.KeyVipItinerario;

public interface ItinerarioMemoService {
	public SimpleResponse guardarItinerarioMemo(ItinerarioMemo itinerarioMemo);
	public String eliminarItinerarioMemo(KeyVipItinerario id);
	public String eliminarItinerariosMemo(String nroCom);
	public List<ItinerarioMemo> obtenerItinerariosMemo(String nroCom);
}
