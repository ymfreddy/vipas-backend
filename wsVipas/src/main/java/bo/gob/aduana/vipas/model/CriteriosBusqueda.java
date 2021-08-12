package bo.gob.aduana.vipas.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CriteriosBusqueda {
	private String numeroMemo;
	private String fechaInicio;
	private String fechaFin;
	private String numeroDocumento;
	private String codigoGerencia;
}
