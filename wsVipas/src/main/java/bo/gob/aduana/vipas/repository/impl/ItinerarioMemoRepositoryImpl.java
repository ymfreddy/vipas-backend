package bo.gob.aduana.vipas.repository.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import bo.gob.aduana.vipas.model.ItinerarioMemo;
import bo.gob.aduana.vipas.repository.ItinerarioMemoRepository;
import bo.gob.aduana.vipas.repository.entity.KeyVipItinerario;
import bo.gob.aduana.vipas.repository.entity.VipItinerarioMemo;
import bo.gob.aduana.vipas.repository.jpa.ItinerarioMemoJpaRepository;
import bo.gob.aduana.vipas.repository.mapper.ItinerarioMemoMapper;
@Repository
public class ItinerarioMemoRepositoryImpl implements ItinerarioMemoRepository{
	@Autowired 
	private ItinerarioMemoJpaRepository itinerarioMemoJpaRepository;
	
	@Override
	public ItinerarioMemo guardarItinerarioMemo(ItinerarioMemo itinerarioMemo) throws Exception{
		VipItinerarioMemo aux = ItinerarioMemoMapper.INSTANCIA.toVipItinerarioMemo(itinerarioMemo);
		Integer cor = itinerarioMemoJpaRepository.obtieneCorreIti(itinerarioMemo.getNroCom(), "U", 0);
		KeyVipItinerario pk = new KeyVipItinerario();
		pk.setComNrocom(itinerarioMemo.getNroCom());
		pk.setItiNroiti(cor);
		aux.setId(pk);
		aux.setVerNum(0);
		aux.setLstOpe("U");
		aux.setFechaReg(Timestamp.from(Instant.now()));
		return ItinerarioMemoMapper.INSTANCIA.toItinerarioMemo(itinerarioMemoJpaRepository.save(aux));		
	}
	
	@Override
	public String eliminarItinerarioMemo(KeyVipItinerario id){
		itinerarioMemoJpaRepository.deleteById(id);		
		return "El itinerario se eliminó correctamente";		
	}
	
	@Override
	public String eliminarItinerariosMemo(String nroCom){
		itinerarioMemoJpaRepository.deleteItinerarios(nroCom);		
		return "El itinerario se eliminó correctamente";		
	}
	
	@Override
	public ItinerarioMemo obtenerItinerarioMemo(KeyVipItinerario id){
		return ItinerarioMemoMapper.INSTANCIA.toItinerarioMemo(itinerarioMemoJpaRepository.obtieneItinerarioMemo(id.getComNrocom(),id.getItiNroiti(),"U",0));				
	}
	
	@Override
	public List<ItinerarioMemo> obtenerItinerariosMemo(String nroCom){
		return ItinerarioMemoMapper.INSTANCIA.toItinerariosMemo(itinerarioMemoJpaRepository.obtieneItinerariosMemo(nroCom,"U",0));
	}
	@Override
	public List<ItinerarioMemo> obtieneItinerarioCod(String nroCom) throws Exception{		
		return ItinerarioMemoMapper.INSTANCIA.toItinerariosMemo(itinerarioMemoJpaRepository.obtieneItinerariosCod(nroCom));
	}
}
