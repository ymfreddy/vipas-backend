package bo.gob.aduana.vipas.repository.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vip_comisionmemo", schema = "vipas")
public class VipComisionMemo {
	@Id	
	@Column (name = "com_nrocom")
	private String comNrocom;
	@Column (name = "com_cod_ger")
	private String comCodGer;
	@Column (name = "com_nombres")
	private String comNombres;
	@Column (name = "com_primer_ap")
	private String comPrimerAp;	
	@Column (name = "com_segundo_ap")
	private String comSegundoAp;	
	@Column (name = "com_nro_doc")
	private String comNroDoc;	
	@Column (name = "com_email")
	private String comEmail;
	@Column (name = "com_celular")
	private String comCelular;
	@Column (name = "com_cargo")
	private String comCargo;
	@Column (name = "com_departamento")
	private String comDepartamento;
	@Column (name = "com_gerencia")
	private String comGerencia;
	@Column (name = "com_memorandum")
	private String comMemorandum;
	@Column (name = "com_fecha_memo")
	private Timestamp comFechaMemo;
	@Column (name = "com_rape")
	private String comRape;
	@Column (name = "com_origen")
	private String comOrigen;
	@Column (name = "usuario")
	private String usuario;
	@Column (name = "lst_ope")
	private String lstOpe;
	@Column (name = "ver_num")
	private Integer verNum;	
	@Column (name = "fechareg")
	private Timestamp fechaReg;
	public String getComNrocom() {
		return comNrocom;
	}
	public void setComNrocom(String comNrocom) {
		this.comNrocom = comNrocom;
	}	
	public String getComCodGer() {
		return comCodGer;
	}
	public void setComCodGer(String comCodGer) {
		this.comCodGer = comCodGer;
	}
	public String getComNombres() {
		return comNombres;
	}
	public void setComNombres(String comNombres) {
		this.comNombres = comNombres;
	}
	public String getComPrimerAp() {
		return comPrimerAp;
	}
	public void setComPrimerAp(String comPrimerAp) {
		this.comPrimerAp = comPrimerAp;
	}
	public String getComSegundoAp() {
		return comSegundoAp;
	}
	public void setComSegundoAp(String comSegundoAp) {
		this.comSegundoAp = comSegundoAp;
	}
	public String getComNroDoc() {
		return comNroDoc;
	}
	public void setComNroDoc(String comNroDoc) {
		this.comNroDoc = comNroDoc;
	}
	public String getComEmail() {
		return comEmail;
	}
	public void setComEmail(String comEmail) {
		this.comEmail = comEmail;
	}
	public String getComCelular() {
		return comCelular;
	}
	public void setComCelular(String comCelular) {
		this.comCelular = comCelular;
	}
	public String getComCargo() {
		return comCargo;
	}
	public void setComCargo(String comCargo) {
		this.comCargo = comCargo;
	}
	public String getComDepartamento() {
		return comDepartamento;
	}
	public void setComDepartamento(String comDepartamento) {
		this.comDepartamento = comDepartamento;
	}
	public String getComGerencia() {
		return comGerencia;
	}
	public void setComGerencia(String comGerencia) {
		this.comGerencia = comGerencia;
	}
	public String getComMemorandum() {
		return comMemorandum;
	}
	public void setComMemorandum(String comMemorandum) {
		this.comMemorandum = comMemorandum;
	}
	public Timestamp getComFechaMemo() {
		return comFechaMemo;
	}
	public void setComFechaMemo(Timestamp comFechaMemo) {
		this.comFechaMemo = comFechaMemo;
	}
	public String getComOrigen() {
		return comOrigen;
	}
	public void setComOrigen(String comOrigen) {
		this.comOrigen = comOrigen;
	}
	public String getLstOpe() {
		return lstOpe;
	}
	public void setLstOpe(String lstOpe) {
		this.lstOpe = lstOpe;
	}
	public Integer getVerNum() {
		return verNum;
	}
	public void setVerNum(Integer verNum) {
		this.verNum = verNum;
	}
	public Timestamp getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Timestamp fechaReg) {
		this.fechaReg = fechaReg;
	}	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getComRape() {
		return comRape;
	}
	public void setComRape(String comRape) {
		this.comRape = comRape;
	}	
}
