package bo.gob.aduana.vipas.repository.mapper;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import bo.gob.aduana.vipas.model.Comision;
import bo.gob.aduana.vipas.repository.entity.VipComision;

@Mapper
public interface ComisionMapper {
	ComisionMapper INSTANCIA= Mappers.getMapper(ComisionMapper.class);
	
	@Mappings({
		@Mapping(source = "comNrocom", target = "nrocom"),
		@Mapping(source = "comCodGer", target = "codGer"),
		@Mapping(source = "comNombres", target = "nombres"),
		@Mapping(source = "comPrimerAp", target = "primerAp"),
		@Mapping(source = "comSegundoAp", target = "segundoAp"),
		@Mapping(source = "comNroDoc", target = "nroDoc"),
		@Mapping(source = "comEmail", target = "email"),
		@Mapping(source = "comCelular", target = "celular"),
		@Mapping(source = "comCargo", target = "cargo"),
		@Mapping(source = "comDepartamento", target = "departamento"),
		@Mapping(source = "comGerencia", target = "gerencia"),
		@Mapping(source = "comMemorandum", target = "memorandum"),	
		@Mapping(source = "comRape", target = "rape"),
		@Mapping(source = "comOrigen", target = "origen"),
		@Mapping(source = "usuario", target = "usuario"),
		@Mapping(expression = "java(dateToString(vipComision.getComFechaMemo()))",target = "fechaMemo"),
		@Mapping(expression = "java(dateHoraToString(vipComision.getFechaReg()))",target = "fechaReg"),
		@Mapping(ignore = true, target = "itinerarios")
	})
	Comision toComision(VipComision vipComision);
	List<Comision> toComisiones(List<VipComision> vipComision);
	default String dateToString(Timestamp comFechaMemo)
	{	
		String timestampAsString="";	
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			timestampAsString = dateFormat.format(comFechaMemo);
		} catch (Exception e) {
			timestampAsString="";
		}
		return timestampAsString;
	}
	default String dateHoraToString(Timestamp comFechaMemo)
	{	
		String timestampAsString="";	
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			timestampAsString = dateFormat.format(comFechaMemo);
		} catch (Exception e) {
			timestampAsString="";
		}
		return timestampAsString;
	}
	
/*convierte de modelo a entidad*/
	
	@InheritInverseConfiguration
	@Mappings({
		@Mapping(target = "fechaReg", ignore = true),
		@Mapping(target = "verNum", ignore = true),
		@Mapping(target = "lstOpe", ignore = true),
		@Mapping(target = "comFechaMemo", expression = "java(stringToDate(comision.getFechaMemo()))")
	})
	VipComision toVipComision(Comision comision);	
	default Timestamp stringToDate(String comFechaMemo)
	{
		Timestamp Fecha_= Timestamp.from(Instant.now());
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date;		
		try {
			date = formatter.parse(comFechaMemo);
			Fecha_ = new Timestamp(date.getTime());
		} catch (ParseException e) {
			Fecha_=null;
		}
		return Fecha_;
	}
}
