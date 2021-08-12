package bo.gob.aduana.vipas.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.gob.aduana.vipas.repository.entity.VipPais;
/*Se coloca la entidad con la que va interactuar y el tipo de variable de la ID de la entidad*/
public interface PaisJpaRepository extends JpaRepository<VipPais, String>{
	List<VipPais> findByVerNumAndLstOpeOrderByPaiDescripcionAsc(int verNum, String lstOpe);
}
