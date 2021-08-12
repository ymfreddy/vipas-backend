package bo.gob.aduana.vipas.model;

public class Itinerario {	
	
	private String nroCom;
	private Integer nroIti;
	private String tipoItinerario;	
	private String tipoViaje;	
	private String pais;	
	private String departamento;	
	private String ciudad;
	private String tramo;
	private String tipoTransporte;	
	private String fecDesde;	
	private String fecHasta;	
	private String horaDesde;	
	private String horaHasta;	
	private String origen;
	private String usuario;
	private String fechaReg;
	
	public Itinerario() {
		super();		
	}
	
	public Itinerario(ItinerarioMemo aux) {
		this.nroCom = aux.getNroCom();
		this.nroIti = aux.getNroIti();
		this.tipoItinerario = aux.getTipoItinerario();	
		this.tipoViaje = aux.getTipoViaje();	
		this.pais = aux.getPais();	
		this.departamento = aux.getDepartamento();	
		this.ciudad = aux.getCiudad();
		this.tramo = aux.getTramo();		
		this.tipoTransporte = aux.getTipoTransporte();	
		this.fecDesde = aux.getFecDesde();	
		this.fecHasta = aux.getFecHasta();	
		this.horaDesde = aux.getHoraDesde();	
		this.horaHasta = aux.getHoraHasta();	
		this.origen = aux.getOrigen();
		this.usuario = aux.getUsuario();
		this.fechaReg = aux.getFechaReg();
	}
	
	public String getTipoItinerario() {
		return tipoItinerario;
	}
	public void setTipoItinerario(String tipoItinerario) {
		this.tipoItinerario = tipoItinerario;
	}
	public String getTipoViaje() {
		return tipoViaje;
	}
	public void setTipoViaje(String tipoViaje) {
		this.tipoViaje = tipoViaje;
	}
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTramo() {
		return tramo;
	}

	public void setTramo(String tramo) {
		this.tramo = tramo;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}
	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}
	public String getFecDesde() {
		return fecDesde;
	}
	public void setFecDesde(String fecDesde) {
		this.fecDesde = fecDesde;
	}
	public String getFecHasta() {
		return fecHasta;
	}
	public void setFecHasta(String fecHasta) {
		this.fecHasta = fecHasta;
	}
	public String getHoraDesde() {
		return horaDesde;
	}
	public void setHoraDesde(String horaDesde) {
		this.horaDesde = horaDesde;
	}
	public String getHoraHasta() {
		return horaHasta;
	}
	public void setHoraHasta(String horaHasta) {
		this.horaHasta = horaHasta;
	}	
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getNroCom() {
		return nroCom;
	}
	public void setNroCom(String nroCom) {
		this.nroCom = nroCom;
	}
	public Integer getNroIti() {
		return nroIti;
	}
	public void setNroIti(Integer nroIti) {
		this.nroIti = nroIti;
	}		
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(String fechaReg) {
		this.fechaReg = fechaReg;
	}
}
