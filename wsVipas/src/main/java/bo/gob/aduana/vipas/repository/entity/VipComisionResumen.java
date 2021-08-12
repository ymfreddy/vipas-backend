package bo.gob.aduana.vipas.repository.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vip_v_comisiones", schema = "vipas")
public class VipComisionResumen {
	@Id
	@Column(name = "mem_nro_memo")
	private String memNroMemo;
	@Column(name = "mem_fecha_emision")
	private Timestamp memFechaEmision;
	@Column(name = "com_rape")
	private String comRape;
	@Column(name = "com_cod_ger")
	private String comCodGer;
	@Column(name = "com_gerencia")
	private String comGerencia;
	@Column(name = "com_departamento")
	private String comDepartamento;
	@Column(name = "com_nro_doc")
	private String comNroDoc;
	@Column(name = "com_tipo_fun")
	private String comTipoFuncionario;
	@Column(name = "com_nombre")
	private String comNombre;
	@Column(name = "com_cargo")
	private String comCargo;
	@Column(name = "com_no_hab")
	private String comNoHabitacion;
	@Column(name = "com_origen")
	private String comOrigen;
	@Column(name = "com_observacion")
	private String comObservacion;
}
