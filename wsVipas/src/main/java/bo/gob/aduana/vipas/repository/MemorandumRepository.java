package bo.gob.aduana.vipas.repository;

import bo.gob.aduana.vipas.model.Comision;

public interface MemorandumRepository {
	public Comision verificarMemorandum (String nroMemo) throws Exception;
}
