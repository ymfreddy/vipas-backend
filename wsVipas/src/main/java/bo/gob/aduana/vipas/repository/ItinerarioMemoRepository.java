package bo.gob.aduana.vipas.repository;

import java.util.List;

import bo.gob.aduana.vipas.model.ItinerarioMemo;
import bo.gob.aduana.vipas.repository.entity.KeyVipItinerario;

public interface ItinerarioMemoRepository {
	public ItinerarioMemo guardarItinerarioMemo(ItinerarioMemo itinerarioMemo) throws Exception;
	public String eliminarItinerarioMemo(KeyVipItinerario id);
	public String eliminarItinerariosMemo(String nroCom);
	public ItinerarioMemo obtenerItinerarioMemo(KeyVipItinerario id);
	public List<ItinerarioMemo> obtenerItinerariosMemo(String nroCom);
	public List<ItinerarioMemo> obtieneItinerarioCod(String nroCom) throws Exception;

}
