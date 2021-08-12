package bo.gob.aduana.vipas.repository.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bo.gob.aduana.vipas.model.CriteriosBusqueda;
import bo.gob.aduana.vipas.repository.entity.VipComisionResumen;

@Repository
public class ComisionResumenCriteriaRepositoryImpl {

	@Autowired
	EntityManager em;

	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public List<VipComisionResumen> findAllByCriterios(CriteriosBusqueda criterios, String campoOrden,
			boolean ascendente) throws ParseException {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<VipComisionResumen> cq = cb.createQuery(VipComisionResumen.class);

		Root<VipComisionResumen> comision = cq.from(VipComisionResumen.class);
		List<Predicate> predicates = new ArrayList<>();

		if (criterios.getNumeroMemo() != null && !criterios.getNumeroMemo().isEmpty()) {
			predicates.add(cb.equal(comision.get("memNroMemo"), criterios.getNumeroMemo()));
		}
		if (criterios.getNumeroDocumento() != null && !criterios.getNumeroDocumento().isEmpty()) {
			predicates.add(cb.equal(comision.get("comNroDoc"), criterios.getNumeroDocumento()));
		}
		if (criterios.getCodigoGerencia() != null && !criterios.getCodigoGerencia().isEmpty()) {
			predicates.add(cb.equal(comision.get("comCodGer"), criterios.getCodigoGerencia()));
		}

		if (criterios.getFechaInicio() != null && criterios.getFechaFin() != null) {
			predicates.add(cb.greaterThanOrEqualTo(comision.get("memFechaEmision"), formatter.parse(criterios.getFechaInicio())));
			predicates.add(cb.lessThanOrEqualTo(comision.get("memFechaEmision"), formatter.parse(criterios.getFechaFin())));
		}

		cq.where(predicates.toArray(new Predicate[0]));
		if (campoOrden != null && !campoOrden.isEmpty()) {
			cq.orderBy(ascendente ? cb.asc(comision.get(campoOrden)) : cb.desc(comision.get(campoOrden)));
		}

		return em.createQuery(cq).getResultList();
	}

}
