package bo.gob.aduana.vipas.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.aduana.vipas.model.CriteriosBusqueda;
import bo.gob.aduana.vipas.repository.entity.VipComisionResumen;
import bo.gob.aduana.vipas.repository.impl.ComisionResumenCriteriaRepositoryImpl;
import bo.gob.aduana.vipas.service.ComisionResumenService;

@Service
public class ComisionResumenServiceImpl implements ComisionResumenService {

	@Autowired
	ComisionResumenCriteriaRepositoryImpl repositoryCriteria;

	@Override
	public List<VipComisionResumen> findAllByCriterios(CriteriosBusqueda criterios, String campoOrden,
			boolean ascendente) throws ParseException {
		List<VipComisionResumen> lista = repositoryCriteria.findAllByCriterios(criterios, campoOrden, ascendente);
		return lista;
	}
}
