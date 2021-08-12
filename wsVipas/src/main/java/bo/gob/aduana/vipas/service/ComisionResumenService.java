package bo.gob.aduana.vipas.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import bo.gob.aduana.vipas.model.CriteriosBusqueda;
import bo.gob.aduana.vipas.repository.entity.VipComisionResumen;

public interface ComisionResumenService {

	@Transactional(readOnly = true)
	List<VipComisionResumen> findAllByCriterios(CriteriosBusqueda criterios, String campoOrden, boolean ascendente)
			throws ParseException;

}
