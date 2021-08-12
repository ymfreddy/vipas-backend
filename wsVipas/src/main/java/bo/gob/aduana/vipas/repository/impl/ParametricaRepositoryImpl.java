package bo.gob.aduana.vipas.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bo.gob.aduana.vipas.model.Parametrica;
import bo.gob.aduana.vipas.repository.ParametricaRepository;
import bo.gob.aduana.vipas.repository.entity.VipParametrica;
import bo.gob.aduana.vipas.repository.jpa.ParametricaJpaRepository;
import bo.gob.aduana.vipas.repository.mapper.ParametricaMapper;


@Repository
public class ParametricaRepositoryImpl implements ParametricaRepository{
	@Autowired
	ParametricaJpaRepository parametricaCrudRepository;
	
	@Override
	public List<Parametrica> getParametricas(){
		List<VipParametrica> con= (List<VipParametrica>) parametricaCrudRepository.findByLstOpeOrderByParTipoAscParOrdenAsc("U");	
		return ParametricaMapper.INSTANCIA.toParametricas(con);
	}	
}
