package bo.gob.aduana.vipas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import bo.gob.aduana.vipas.exception.UnauthorizedException;

@Component
public class SecurityInterceptor implements HandlerInterceptor {

	@Autowired
	Environment env;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws UnauthorizedException {		
			return true;
		}
	
}
