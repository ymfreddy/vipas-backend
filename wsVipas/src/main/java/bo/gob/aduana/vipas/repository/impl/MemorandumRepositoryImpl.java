package bo.gob.aduana.vipas.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bo.gob.aduana.vipas.model.Comision;
import bo.gob.aduana.vipas.repository.MemorandumRepository;
import bo.gob.aduana.vipas.repository.dao.MemorandumDaoRepository;
@Repository
public class MemorandumRepositoryImpl implements MemorandumRepository {
	@Autowired 
	private MemorandumDaoRepository memorandumDaoRepository;
	@Override
	public Comision verificarMemorandum (String nroMemo) throws Exception{		
		return memorandumDaoRepository.verificarMemorandum(nroMemo);	
	}

}
