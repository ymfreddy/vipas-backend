package bo.gob.aduana.vipas.model;

public class Pais {
	
	private String codigo;	
	private String descripcion;	
	private String continente;	
	private String region;
	
	public Pais() {
		super();
	}	
	public Pais(String codigo, String descripcion, String continente, String region) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.continente = continente;
		this.region = region;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}	
	
}
