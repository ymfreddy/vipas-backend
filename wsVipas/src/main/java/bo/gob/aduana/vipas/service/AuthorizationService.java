package bo.gob.aduana.vipas.service;

import org.springframework.http.HttpHeaders;

import bo.gob.aduana.vipas.exception.UnauthorizedException;


public interface AuthorizationService {
	Boolean validToken(HttpHeaders headers) throws UnauthorizedException;
}
