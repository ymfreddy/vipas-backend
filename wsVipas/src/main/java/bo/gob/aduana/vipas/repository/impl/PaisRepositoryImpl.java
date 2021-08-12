package bo.gob.aduana.vipas.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bo.gob.aduana.vipas.repository.entity.VipPais;
import bo.gob.aduana.vipas.repository.jpa.PaisJpaRepository;
import bo.gob.aduana.vipas.repository.mapper.PaisMapper;
import bo.gob.aduana.vipas.model.Pais;
import bo.gob.aduana.vipas.repository.PaisRepository;

@Repository
public class PaisRepositoryImpl implements PaisRepository{
	//El objeto que reciba esta notacion, spring creara el objeto, solo funciona con componentes spring
	
	@Autowired 
	private PaisJpaRepository paisRepository;
	
	@Override
	public List<Pais> getPaises(){		
		List<VipPais> con= (List<VipPais>) paisRepository.findByVerNumAndLstOpeOrderByPaiDescripcionAsc(0,"U");	
		//Cliente cliente= PaisMapper.INSTANCIA.toPaises(con);
	      
		//return mapper.toPaises(con);
		return PaisMapper.INSTANCIA.toPaises(con);
	}
}
