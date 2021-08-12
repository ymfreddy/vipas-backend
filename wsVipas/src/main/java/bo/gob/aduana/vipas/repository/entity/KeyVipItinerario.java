package bo.gob.aduana.vipas.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class KeyVipItinerario implements Serializable{

	private static final long serialVersionUID = 1L;
		
	@Column (name = "com_nrocom")
	private String comNrocom;
		
	@Column (name = "iti_nroiti")
	private Integer itiNroiti;
	
	public String getComNrocom() {
		return comNrocom;
	}
	public void setComNrocom(String comNrocom) {
		this.comNrocom = comNrocom;
	}
	public Integer getItiNroiti() {
		return itiNroiti;
	}
	public void setItiNroiti(Integer itiNroiti) {
		this.itiNroiti = itiNroiti;
	}
}
