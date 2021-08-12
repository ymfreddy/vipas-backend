package bo.gob.aduana.vipas.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import bo.gob.aduana.vipas.model.Parametrica;
import bo.gob.aduana.vipas.repository.entity.VipParametrica;

@Mapper
public interface ParametricaMapper {
	ParametricaMapper INSTANCIA= Mappers.getMapper(ParametricaMapper.class);
	@Mappings({
		@Mapping(source = "parCodigo", target = "codigo"),
		@Mapping(source = "parDescripcion", target = "descripcion"),
		@Mapping(source = "parTipo", target = "tipo"),
		@Mapping(source = "parOrden", target = "orden")
	})
	
	Parametrica toParametrica(VipParametrica vipParametrica);	
	List<Parametrica> toParametricas(List<VipParametrica> vipParametrica);
}
