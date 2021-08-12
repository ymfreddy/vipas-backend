package bo.gob.aduana.vipas.repository.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "vip_itinerario", schema = "vipas")
public class VipItinerario {
	
	@EmbeddedId
	private KeyVipItinerario id;
	@Column (name = "iti_tipoitinerario")
	private String itiTipoItinerario;
	@Column (name = "iti_tipoviaje")
	private String itiTipoViaje;
	@Column (name = "iti_pais")
	private String itiPais;
	@Column (name = "iti_departamento")
	private String itiDepartamento;
	@Column (name = "iti_ciudad")
	private String itiCiudad;
	@Column (name = "iti_tramo")
	private String itiTramo;
	@Column (name = "iti_tipotransporte")
	private String itiTipoTransporte;
	@Column (name = "iti_fecdesde")
	private Timestamp itiFecDesde;
	@Column (name = "iti_fechasta")
	private Timestamp itiFecHasta;
	@Column (name = "iti_horadesde")
	private String itiHoraDesde;
	@Column (name = "iti_horahasta")
	private String itiHoraHasta;
	@Column (name = "iti_origen")
	private String itiOrigen;
	@Column (name = "usuario")
	private String usuario;
	@Column (name = "lst_ope")
	private String lstOpe;
	@Column (name = "ver_num")
	private Integer verNum;	
	@Column (name = "fechareg")
	private Timestamp fechaReg;
	
	public KeyVipItinerario getId() {
		return id;
	}
	public void setId(KeyVipItinerario id) {
		this.id = id;
	}
	public String getItiTipoItinerario() {
		return itiTipoItinerario;
	}
	public void setItiTipoItinerario(String itiTipoItinerario) {
		this.itiTipoItinerario = itiTipoItinerario;
	}
	public String getItiTipoViaje() {
		return itiTipoViaje;
	}
	public void setItiTipoViaje(String itiTipoViaje) {
		this.itiTipoViaje = itiTipoViaje;
	}
	public String getItiPais() {
		return itiPais;
	}
	public void setItiPais(String itiPais) {
		this.itiPais = itiPais;
	}
	public String getItiDepartamento() {
		return itiDepartamento;
	}
	public void setItiDepartamento(String itiDepartamento) {
		this.itiDepartamento = itiDepartamento;
	}
	public String getItiCiudad() {
		return itiCiudad;
	}
	public void setItiCiudad(String itiCiudad) {
		this.itiCiudad = itiCiudad;
	}
	public String getItiTramo() {
		return itiTramo;
	}
	public void setItiTramo(String itiTramo) {
		this.itiTramo = itiTramo;
	}
	public String getItiTipoTransporte() {
		return itiTipoTransporte;
	}
	public void setItiTipoTransporte(String itiTipoTransporte) {
		this.itiTipoTransporte = itiTipoTransporte;
	}
	public Timestamp getItiFecDesde() {
		return itiFecDesde;
	}
	public void setItiFecDesde(Timestamp itiFecDesde) {
		this.itiFecDesde = itiFecDesde;
	}
	public Timestamp getItiFecHasta() {
		return itiFecHasta;
	}
	public void setItiFecHasta(Timestamp itiFecHasta) {
		this.itiFecHasta = itiFecHasta;
	}
	public String getItiHoraDesde() {
		return itiHoraDesde;
	}
	public void setItiHoraDesde(String itiHoraDesde) {
		this.itiHoraDesde = itiHoraDesde;
	}
	public String getItiHoraHasta() {
		return itiHoraHasta;
	}
	public void setItiHoraHasta(String itiHoraHasta) {
		this.itiHoraHasta = itiHoraHasta;
	}
	public String getItiOrigen() {
		return itiOrigen;
	}
	public void setItiOrigen(String itiOrigen) {
		this.itiOrigen = itiOrigen;
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
}
