package bo.gob.aduana.vipas.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vip_parametrica", schema = "vipas")
public class VipParametrica {
	@Id
	@Column (name = "par_codigo")
	private String parCodigo;
	@Column (name = "par_descripcion")
	private String parDescripcion;
	@Column (name = "par_tipo")
	private String parTipo;
	@Column (name = "par_orden")
	private Integer parOrden;	
	@Column (name = "fechareg")
	private LocalDateTime fechaReg;	
	@Column (name = "lst_ope")
	private String lstOpe;
	public String getParCodigo() {
		return parCodigo;
	}
	public void setParCodigo(String parCodigo) {
		this.parCodigo = parCodigo;
	}
	public String getParDescripcion() {
		return parDescripcion;
	}
	public void setParDescripcion(String parDescripcion) {
		this.parDescripcion = parDescripcion;
	}
	public String getParTipo() {
		return parTipo;
	}
	public void setParTipo(String parTipo) {
		this.parTipo = parTipo;
	}
	public Integer getParOrden() {
		return parOrden;
	}
	public void setParOrden(Integer parOrden) {
		this.parOrden = parOrden;
	}
	public LocalDateTime getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(LocalDateTime fechaReg) {
		this.fechaReg = fechaReg;
	}
	public String getLstOpe() {
		return lstOpe;
	}
	public void setLstOpe(String lstOpe) {
		this.lstOpe = lstOpe;
	}

}
