package bo.gob.aduana.vipas.repository;

import java.util.List;

import bo.gob.aduana.vipas.model.Comision;

public interface ComisionRepository {
	public Comision guardarComision(Comision comision);
	public String eliminarComision(String nroCom);
	public Comision obtenerComision(String nroCom);
	public Integer verificaMemo(String memorandum);
	public List<Comision> obtenerComisiones(String gerencia);
}
