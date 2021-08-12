package bo.gob.aduana.vipas.service;

import java.util.List;

import bo.gob.aduana.vipas.model.Comision;

public interface ComisionService {
	public Comision obtenerComision(String nroCom);
	public List<Comision> obtenerComisiones(String gerencia);
}
