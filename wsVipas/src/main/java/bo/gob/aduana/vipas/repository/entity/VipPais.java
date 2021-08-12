package bo.gob.aduana.vipas.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vip_ppais", schema = "vipas")
public class VipPais {
	
	/*@EmbeddedId
	private VipPaisId vipPaisId;*/
	
	@Id	
	@Column (name = "pai_codigo")
	private String paiCodigo;
	@Column (name = "pai_descripcion")
	private String paiDescripcion;
	@Column (name = "pai_continente")
	private String paiContinente;
	@Column (name = "pai_region")
	private String paiRegion;	
	@Column (name = "fechareg")
	private LocalDateTime fechaReg;
	@Column (name = "ver_num")
	private Integer verNum;
	@Column (name = "lst_ope")
	private String lstOpe;
	public String getPaiCodigo() {
		return paiCodigo;
	}
	public void setPaiCodigo(String paiCodigo) {
		this.paiCodigo = paiCodigo;
	}
	public String getPaiDescripcion() {
		return paiDescripcion;
	}
	public void setPaiDescripcion(String paiDescripcion) {
		this.paiDescripcion = paiDescripcion;
	}
	public String getPaiContinente() {
		return paiContinente;
	}
	public void setPaiContinente(String paiContinente) {
		this.paiContinente = paiContinente;
	}
	public String getPaiRegion() {
		return paiRegion;
	}
	public void setPaiRegion(String paiRegion) {
		this.paiRegion = paiRegion;
	}
	public LocalDateTime getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(LocalDateTime fechaReg) {
		this.fechaReg = fechaReg;
	}
	public Integer getVerNum() {
		return verNum;
	}
	public void setVerNum(Integer verNum) {
		this.verNum = verNum;
	}
	public String getLstOpe() {
		return lstOpe;
	}
	public void setLstOpe(String lstOpe) {
		this.lstOpe = lstOpe;
	}
}
