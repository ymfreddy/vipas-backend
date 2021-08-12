package bo.gob.aduana.vipas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import bo.gob.aduana.vipas.exception.UnauthorizedException;
import bo.gob.aduana.vipas.interceptor.RestTemplateResponseErrorHandler;
import bo.gob.aduana.vipas.model.ErrorResponse;
import bo.gob.aduana.vipas.service.AuthorizationService;



@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	@Autowired
	Environment env;
	
	@Override
	public Boolean validToken(HttpHeaders headers) throws UnauthorizedException {
		
		final String uri = env.getProperty("project.auth") + "/verificar/" + env.getProperty("project.name");
		if(headers.get("Authorization") != null ) {
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);		
			RestTemplateBuilder restBuilder = new RestTemplateBuilder();
			RestTemplate restTemplate = restBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
			
			ResponseEntity<ErrorResponse> result = restTemplate.exchange(uri, HttpMethod.GET, entity, ErrorResponse.class);
			if (result.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
				throw new UnauthorizedException(result.getBody().getMessage());
			else 
				return true;
		}
		else 
			throw new UnauthorizedException("Esta consulta requiere token de autorización");
	}

}
