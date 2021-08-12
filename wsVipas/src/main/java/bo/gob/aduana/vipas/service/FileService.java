package bo.gob.aduana.vipas.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
 
import javax.servlet.http.HttpServletResponse;
 
@Component
public class FileService {
 
	private enum ResourceType {
		FILE_SYSTEM,
		CLASSPATH
	}
 
	//private static final String FILE_DIRECTORY = "/var/files";
 
	/**
	 * @param filename filename
	 * @param response Http response.
	 * @return file from system.
	 */
	public Resource getFileSystem(String directorio,String filename, HttpServletResponse response) {
		return getResource(directorio,filename, response, ResourceType.FILE_SYSTEM);
	}
 
	/**
	 * @param filename filename
	 * @param response Http response.
	 * @return file from classpath.
	 */
	public Resource getClassPathFile(String directorio,String filename, HttpServletResponse response) {
		return getResource(directorio,filename, response, ResourceType.CLASSPATH);
	}
 
	private Resource getResource(String directorio, String filename, HttpServletResponse response, ResourceType resourceType) {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + filename);
		response.setHeader("filename", filename);
 
		Resource resource = null;
		switch (resourceType) {
			case FILE_SYSTEM:
				resource = new FileSystemResource(directorio + filename);
				break;
			case CLASSPATH:
				resource = new ClassPathResource("data/" + filename);
				break;
		}
 
		return resource;
	}
}