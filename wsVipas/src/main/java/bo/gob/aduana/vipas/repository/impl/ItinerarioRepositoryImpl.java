package bo.gob.aduana.vipas.repository.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bo.gob.aduana.vipas.model.Itinerario;
import bo.gob.aduana.vipas.repository.ItinerarioRepository;
import bo.gob.aduana.vipas.repository.entity.KeyVipItinerario;
import bo.gob.aduana.vipas.repository.entity.VipItinerario;
import bo.gob.aduana.vipas.repository.jpa.ItinerarioJpaRepository;
import bo.gob.aduana.vipas.repository.mapper.ItinerarioMapper;

@Repository
public class ItinerarioRepositoryImpl implements ItinerarioRepository{
	@Autowired 
	private ItinerarioJpaRepository itinerarioJpaRepository;
	
	@Override
	public Itinerario guardarItinerario(Itinerario itinerario){
		VipItinerario aux = ItinerarioMapper.INSTANCIA.toVipItinerario(itinerario);
		Integer cor = itinerarioJpaRepository.obtieneCorreIti(itinerario.getNroCom(), "U", 0);
		KeyVipItinerario pk = new KeyVipItinerario();
		pk.setComNrocom(itinerario.getNroCom());
		pk.setItiNroiti(cor);
		aux.setId(pk);
		aux.setVerNum(0);
		aux.setLstOpe("U");
		aux.setFechaReg(Timestamp.from(Instant.now()));
		return ItinerarioMapper.INSTANCIA.toItinerario(itinerarioJpaRepository.save(aux));		
	}
	
	@Override
	public String eliminarItinerario(KeyVipItinerario id){
		itinerarioJpaRepository.deleteById(id);		
		return "El itinerario se eliminó correctamente";		
	}
	
	@Override
	public String eliminarItinerarios(String nroCom){
		itinerarioJpaRepository.deleteItinerarios(nroCom);		
		return "El itinerario se eliminó correctamente";		
	}
	
	@Override
	public Itinerario obtenerItinerario(KeyVipItinerario id){
		return ItinerarioMapper.INSTANCIA.toItinerario(itinerarioJpaRepository.obtieneItinerario(id.getComNrocom(),id.getItiNroiti(),"U",0));				
	}
	
	@Override
	public List<Itinerario> obtenerItinerarios(String nroCom){
		return ItinerarioMapper.INSTANCIA.toItinerarios(itinerarioJpaRepository.obtieneItinerarios(nroCom,"U",0));
	}
}
