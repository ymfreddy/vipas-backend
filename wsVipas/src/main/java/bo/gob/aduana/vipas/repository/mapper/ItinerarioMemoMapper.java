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

import bo.gob.aduana.vipas.model.ItinerarioMemo;
import bo.gob.aduana.vipas.repository.entity.VipItinerarioMemo;

@Mapper
public interface ItinerarioMemoMapper {
	ItinerarioMemoMapper INSTANCIA= Mappers.getMapper(ItinerarioMemoMapper.class);
	@Mappings({
		@Mapping(source = "id.comNrocom", 	target = "nroCom"),
		@Mapping(source = "id.itiNroiti", 	target = "nroIti"),
		@Mapping(source = "itiTipoItinerario", target = "tipoItinerario"),
		@Mapping(source = "itiTipoViaje", target = "tipoViaje"),
		@Mapping(source = "itiPais", target = "pais"),
		@Mapping(source = "itiDepartamento", target = "departamento"),
		@Mapping(source = "itiCiudad", target = "ciudad"),
		@Mapping(source = "itiTramo", target = "tramo"),
		@Mapping(source = "itiTipoTransporte", target = "tipoTransporte"),
		@Mapping(expression = "java(dateToString(vipItinerarioMemo.getItiFecDesde()))", target = "fecDesde"),		
		@Mapping(expression = "java(dateToString(vipItinerarioMemo.getItiFecHasta()))", target = "fecHasta"),
		@Mapping(source = "itiHoraDesde", target = "horaDesde"),
		@Mapping(source = "itiHoraHasta", target = "horaHasta"),
		@Mapping(source = "itiOrigen", target = "origen"),
		@Mapping(source = "usuario", target = "usuario"),
		@Mapping(expression = "java(dateHoraToString(vipItinerarioMemo.getFechaReg()))",target = "fechaReg")
	})
	ItinerarioMemo toItinerarioMemo(VipItinerarioMemo vipItinerarioMemo);
	List<ItinerarioMemo> toItinerariosMemo(List<VipItinerarioMemo> vipItinerarioMemo);
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
		@Mapping(target = "itiFecDesde", expression = "java(stringToDate(itinerarioMemo.getFecDesde()))"),
		@Mapping(target = "itiFecHasta", expression = "java(stringToDate(itinerarioMemo.getFecHasta()))")
	})
	VipItinerarioMemo toVipItinerarioMemo(ItinerarioMemo itinerarioMemo);
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
