package bo.gob.aduana.vipas.repository;

import java.util.List;

import bo.gob.aduana.vipas.model.ComisionMemo;

public interface ComisionMemoRepository {
	public ComisionMemo guardarComisionMemo(ComisionMemo comisionMemo) throws Exception;
	public String eliminarComisionMemo(String nroCom);
	public ComisionMemo obtenerComisionMemo(String nroCom);
	public List<ComisionMemo> obtenerComisionesMemo(String gerencia);
	public Integer verificaMemo(String memorandum);
}
