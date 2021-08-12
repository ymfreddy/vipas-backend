package bo.gob.aduana.vipas.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import bo.gob.aduana.vipas.repository.entity.VipItinerarioMemo;

public interface ItinerarioMemoJpaRepository2 extends  CrudRepository<VipItinerarioMemo,String>{

	@Query(value="SELECT com_nrocom, iti_nroiti, iti_tipoitinerario, iti_tipoviaje, iti_tipotransporte, iti_pais, iti_departamento, iti_ciudad, iti_tramo, iti_fecdesde, iti_fechasta, iti_horadesde, iti_horahasta, iti_origen, usuario,'D' lst_ope, 0 ver_num, fechareg "
			+ " FROM vip_itinerariomemo "
			+ " where com_nrocom = :com_nrocom and lst_ope = 'U' and ver_num = 0", nativeQuery = true)	
	List<VipItinerarioMemo> obtieneItinerariosCod(@Param(value = "com_nrocom") String com_nrocom);
	
	
}
