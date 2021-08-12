package bo.gob.aduana.vipas.repository.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import bo.gob.aduana.vipas.repository.entity.VipPais;
import bo.gob.aduana.vipas.model.Pais;

//@Mapper(componentModel = "spring")
@Mapper
public interface PaisMapper {
		
	PaisMapper INSTANCIA= Mappers.getMapper(PaisMapper.class);
	/*convierte de entidad a modelo*/
	
	@Mappings({
		@Mapping(source = "paiCodigo", target = "codigo"),
		@Mapping(source = "paiDescripcion", target = "descripcion"),
		@Mapping(source = "paiContinente", target = "continente"),
		@Mapping(source = "paiRegion", target = "region")
	})
	
	Pais toPais(VipPais vipPais);	
	List<Pais> toPaises(List<VipPais> vipPais);
	
	/*convierte de modelo a entidad*/
	
	@InheritInverseConfiguration
	@Mappings({
		@Mapping(target = "fechaReg", ignore = true),
		@Mapping(target = "verNum", ignore = true),
		@Mapping(target = "lstOpe", ignore = true)
	})
	
	VipPais toVipPais(Pais pais);
}
