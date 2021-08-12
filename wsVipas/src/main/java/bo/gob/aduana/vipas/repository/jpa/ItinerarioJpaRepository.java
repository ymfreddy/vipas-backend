package bo.gob.aduana.vipas.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bo.gob.aduana.vipas.repository.entity.KeyVipItinerario;
import bo.gob.aduana.vipas.repository.entity.VipItinerario;

public interface ItinerarioJpaRepository extends JpaRepository<VipItinerario,KeyVipItinerario>{
	
	@Query(value="select COALESCE( max (iti_nroiti)+1 ,1)  from vip_itinerario where com_nrocom = :com_nrocom and lst_ope = :lst_ope and ver_num = :ver_num", nativeQuery = true)	
	int obtieneCorreIti(@Param(value = "com_nrocom") String com_nrocom,@Param(value = "lst_ope") String lst_ope,@Param(value = "ver_num") Integer ver_num);
	
	@Modifying
	@Query(value="delete from vip_itinerario where com_nrocom=:com_nrocom" , nativeQuery = true)
	void deleteItinerarios(@Param("com_nrocom") String com_nrocom);
	
	@Query(value="select * from vip_itinerario where com_nrocom = :com_nrocom and iti_nroiti = :iti_nroiti and lst_ope = :lst_ope and ver_num = :ver_num", nativeQuery = true)	
	VipItinerario obtieneItinerario(@Param(value = "com_nrocom") String com_nrocom,  @Param(value = "iti_nroiti") Integer iti_nroiti, @Param(value = "lst_ope") String lst_ope, @Param(value = "ver_num") Integer ver_num);
	
	@Query(value="SELECT com_nrocom, iti_nroiti, iti_tipoitinerario, "
			+ " f_parametricades (iti_tipoviaje,'TIPOVIAJE') iti_tipoviaje, iti_tramo, "
			+ " f_paisdes(iti_pais) iti_pais, f_depdes(iti_departamento) iti_departamento, iti_ciudad, "
			+ " f_parametricades(iti_tipotransporte,'ITI_TRANSPORTE') iti_tipotransporte, iti_fecdesde, "
			+ " iti_fechasta, iti_horadesde, iti_horahasta, iti_origen, usuario, lst_ope, ver_num, fechareg "
			+ " FROM vip_itinerario "
			+ " where com_nrocom = :com_nrocom and lst_ope = :lst_ope and ver_num = :ver_num", nativeQuery = true)	
	List<VipItinerario> obtieneItinerarios(@Param(value = "com_nrocom") String com_nrocom, @Param(value = "lst_ope") String lst_ope, @Param(value = "ver_num") Integer ver_num);
}
