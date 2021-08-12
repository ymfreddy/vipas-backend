package bo.gob.aduana.vipas.repository.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bo.gob.aduana.vipas.model.Comision;
import bo.gob.aduana.vipas.repository.ComisionRepository;
import bo.gob.aduana.vipas.repository.entity.VipComision;
import bo.gob.aduana.vipas.repository.jpa.ComisionJpaRepository;
import bo.gob.aduana.vipas.repository.mapper.ComisionMapper;

@Repository
public class ComisionRepositoryImpl implements ComisionRepository{
	@Autowired 
	private ComisionJpaRepository comisionJpaRepository;
	
	@Override
	public Comision guardarComision(Comision comision){
		VipComision aux = ComisionMapper.INSTANCIA.toVipComision(comision);
		String cor=obtenerCorrelativo("R",comision.getCodGer());
		aux.setComNrocom(cor);
		aux.setVerNum(0);
		aux.setLstOpe("U");
		aux.setFechaReg(Timestamp.from(Instant.now()));
		return ComisionMapper.INSTANCIA.toComision(comisionJpaRepository.save(aux));		
	}
	
	public String obtenerCorrelativo(String tipo, String aduana){		
		return comisionJpaRepository.f_correlativo(tipo, aduana);
	}	
	
	@Override
	public String eliminarComision(String nroCom){
		comisionJpaRepository.deleteById(nroCom);
		return "La comisión memorizada se eliminó correctamente";				
	}
	
	@Override
	public Comision obtenerComision(String nroCom){
		return ComisionMapper.INSTANCIA.toComision(comisionJpaRepository.obtieneSolicitud(nroCom,"U",0));			
	}
	
	@Override
	public Integer verificaMemo(String memorandum){
		return comisionJpaRepository.verificaMemo(memorandum,"U",0);			
	}
	
	@Override
	public List<Comision> obtenerComisiones(String gerencia){
		return ComisionMapper.INSTANCIA.toComisiones(comisionJpaRepository.obtieneComisiones(gerencia,"U",0));			
	}
}
