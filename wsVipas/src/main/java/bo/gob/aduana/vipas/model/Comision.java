package bo.gob.aduana.vipas.model;

import java.util.List;

public class Comision {
	
	private String nrocom;	
	private String codGer;	
	private String nombres;	
	private String primerAp;	
	private String segundoAp;	
	private String nroDoc;
	private String email;
	private String celular;
	private String cargo;
	private String departamento;
	private String gerencia;
	private String memorandum;
	private String fechaMemo;
	private String origen;
	private String usuario;
	private List<Itinerario> itinerarios;	
	private String fechaReg;
	private String rape;
	
	public Comision() {
		super();
		// TODO Auto-generated constructor stub
	}	
	public Comision(ComisionMemo aux) {
		super();
		this.nrocom = aux.getNrocom();
		this.codGer = aux.getCodGer();
		this.nombres = aux.getNombres();
		this.primerAp = aux.getPrimerAp();
		this.segundoAp = aux.getSegundoAp();
		this.nroDoc = aux.getNroDoc();
		this.email = aux.getEmail();
		this.celular = aux.getCelular();
		this.cargo = aux.getCargo();
		this.departamento = aux.getDepartamento();
		this.gerencia = aux.getGerencia();
		this.memorandum = aux.getMemorandum();
		this.fechaMemo = aux.getFechaMemo();
		this.origen = aux.getOrigen();
		this.usuario = aux.getUsuario();
		this.rape = aux.getRape();
	}
	public String getNrocom() {
		return nrocom;
	}
	public void setNrocom(String nrocom) {
		this.nrocom = nrocom;
	}
	public String getCodGer() {
		return codGer;
	}
	public void setCodGer(String codGer) {
		this.codGer = codGer;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPrimerAp() {
		return primerAp;
	}
	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}
	public String getSegundoAp() {
		return segundoAp;
	}
	public void setSegundoAp(String segundoAp) {
		this.segundoAp = segundoAp;
	}
	public String getNroDoc() {
		return nroDoc;
	}
	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getGerencia() {
		return gerencia;
	}
	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}
	public String getMemorandum() {
		return memorandum;
	}
	public void setMemorandum(String memorandum) {
		this.memorandum = memorandum;
	}
	public String getFechaMemo() {
		return fechaMemo;
	}
	public void setFechaMemo(String fechaMemo) {
		this.fechaMemo = fechaMemo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public List<Itinerario> getItinerarios() {
		return itinerarios;
	}
	public void setItinerarios(List<Itinerario> itinerarios) {
		this.itinerarios = itinerarios;
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
	public String getRape() {
		return rape;
	}
	public void setRape(String rape) {
		this.rape = rape;
	}	
}
