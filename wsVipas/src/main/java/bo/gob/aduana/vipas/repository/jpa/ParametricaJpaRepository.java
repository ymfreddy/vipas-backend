package bo.gob.aduana.vipas.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.gob.aduana.vipas.repository.entity.VipParametrica;

public interface ParametricaJpaRepository extends JpaRepository<VipParametrica,String>{
	List<VipParametrica>findByLstOpeOrderByParTipoAscParOrdenAsc(String lstOpe);
}
