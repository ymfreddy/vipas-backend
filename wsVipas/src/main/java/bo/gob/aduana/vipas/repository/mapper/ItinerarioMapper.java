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

import bo.gob.aduana.vipas.model.Itinerario;
import bo.gob.aduana.vipas.repository.entity.VipItinerario;

@Mapper
public interface ItinerarioMapper {
	ItinerarioMapper INSTANCIA= Mappers.getMapper(ItinerarioMapper.class);
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
		@Mapping(expression = "java(dateToString(vipItinerario.getItiFecDesde()))", target = "fecDesde"),		
		@Mapping(expression = "java(dateToString(vipItinerario.getItiFecHasta()))", target = "fecHasta"),
		@Mapping(source = "itiHoraDesde", target = "horaDesde"),
		@Mapping(source = "itiHoraHasta", target = "horaHasta"),
		@Mapping(source = "itiOrigen", target = "origen"),
		@Mapping(source = "usuario", target = "usuario"),
		@Mapping(expression = "java(dateHoraToString(vipItinerario.getFechaReg()))",target = "fechaReg")
	})
	Itinerario toItinerario(VipItinerario vipItinerario);
	List<Itinerario> toItinerarios(List<VipItinerario> vipItinerario);
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
		@Mapping(target = "itiFecDesde", expression = "java(stringToDate(itinerario.getFecDesde()))"),
		@Mapping(target = "itiFecHasta", expression = "java(stringToDate(itinerario.getFecHasta()))")
	})
	VipItinerario toVipItinerario(Itinerario itinerario);
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
