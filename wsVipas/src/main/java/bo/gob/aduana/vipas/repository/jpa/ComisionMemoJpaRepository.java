package bo.gob.aduana.vipas.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import bo.gob.aduana.vipas.repository.entity.VipComisionMemo;

public interface ComisionMemoJpaRepository extends JpaRepository<VipComisionMemo,String>{
	@Procedure
	String f_correlativo(String p_tipo,String p_aduana);
	
	@Query(value="select * from vip_comisionmemo where com_nrocom = :com_nrocom and lst_ope = :lst_ope and ver_num = :ver_num", nativeQuery = true)	
	VipComisionMemo obtieneSolicitud(@Param(value = "com_nrocom") String com_nrocom, @Param(value = "lst_ope") String lst_ope, @Param(value = "ver_num") Integer ver_num);
	
	@Query(value="select * from vip_comisionmemo where com_cod_ger = :gerencia and lst_ope = :lst_ope and ver_num = :ver_num order by fechareg desc", nativeQuery = true)	
	List<VipComisionMemo> obtieneComisiones(@Param(value = "gerencia") String gerencia, @Param(value = "lst_ope") String lst_ope, @Param(value = "ver_num") Integer ver_num);
	
	@Query(value="select count (1) from vip_comisionmemo where com_memorandum = :memorandum and lst_ope = :lst_ope and ver_num = :ver_num", nativeQuery = true)	
	Integer verificaMemo(@Param(value = "memorandum") String memorandum, @Param(value = "lst_ope") String lst_ope, @Param(value = "ver_num") Integer ver_num);
}