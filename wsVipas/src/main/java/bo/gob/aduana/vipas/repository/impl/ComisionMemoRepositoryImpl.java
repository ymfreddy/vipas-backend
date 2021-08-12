package bo.gob.aduana.vipas.repository.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bo.gob.aduana.vipas.model.ComisionMemo;
import bo.gob.aduana.vipas.repository.ComisionMemoRepository;
import bo.gob.aduana.vipas.repository.entity.VipComisionMemo;
import bo.gob.aduana.vipas.repository.jpa.ComisionMemoJpaRepository;
import bo.gob.aduana.vipas.repository.mapper.ComisionMemoMapper;

@Repository
public class ComisionMemoRepositoryImpl implements ComisionMemoRepository{
	@Autowired 
	private ComisionMemoJpaRepository comisionMemoJpaRepository;
	
	@Override
	public ComisionMemo guardarComisionMemo(ComisionMemo comisionMemo) throws Exception{
		VipComisionMemo aux = ComisionMemoMapper.INSTANCIA.toVipComisionMemo(comisionMemo);
		String cor=obtenerCorrelativo("M",comisionMemo.getCodGer());
		aux.setComNrocom(cor);
		aux.setVerNum(0);
		aux.setLstOpe("U");
		aux.setFechaReg(Timestamp.from(Instant.now()));
		return ComisionMemoMapper.INSTANCIA.toComisionMemo(comisionMemoJpaRepository.save(aux));		
	}
	
	public String obtenerCorrelativo(String tipo, String aduana)
	{		
		return comisionMemoJpaRepository.f_correlativo(tipo, aduana);
	}	
	
	@Override
	public String eliminarComisionMemo(String nroCom){
		comisionMemoJpaRepository.deleteById(nroCom);
		return "La comisión memorizada se eliminó correctamente";				
	}
	
	@Override
	public ComisionMemo obtenerComisionMemo(String nroCom){
		return ComisionMemoMapper.INSTANCIA.toComisionMemo(comisionMemoJpaRepository.obtieneSolicitud(nroCom,"U",0));			
	}
	
	@Override
	public List<ComisionMemo> obtenerComisionesMemo(String gerencia){
		return ComisionMemoMapper.INSTANCIA.toComisionesMemo(comisionMemoJpaRepository.obtieneComisiones(gerencia,"U",0));			
	}
	
	@Override
	public Integer verificaMemo(String memorandum){
		return comisionMemoJpaRepository.verificaMemo(memorandum,"U",0);			
	}
}
