package bo.gob.aduana.vipas.utilitario.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("file:/u03/jboss/data/wsVipas/application.properties")
//@PropertySource("file:C:/u03/jboss/data/services.properties")
public class ServicesProperties {

	Project project;
	private String location;//direccion para almacenar los archivos 
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}

	public static class Project {
		String auth;

		public String getAuth() {
			return auth;
		}

		public void setAuth(String auth) {
			this.auth = auth;
		}
	}
}
