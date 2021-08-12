package bo.gob.aduana.vipas.service;

import java.util.List;

import bo.gob.aduana.vipas.model.ComisionMemo;
import bo.gob.aduana.vipas.model.SimpleResponse;

public interface ComisionMemoService {
	public SimpleResponse guardarComisionMemo(ComisionMemo comisionMemo);
	public String eliminarComisionMemo(String nroCom);
	public SimpleResponse registrarComision(ComisionMemo comisionMemo);
	public ComisionMemo obtenerComisionMemo(String nroCom);
	public List<ComisionMemo> obtenerComisionesMemo(String gerencia);
	public SimpleResponse verificarMemorandum (String nroMemo);
}
