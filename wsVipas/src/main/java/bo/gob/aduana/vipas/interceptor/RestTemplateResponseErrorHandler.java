package bo.gob.aduana.vipas.interceptor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;


@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	private final static Logger LOGGER = Logger.getLogger("bo.gob.aduana.auth.Interceptor");
	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		return (
			httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
					|| httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}
	
	@Override
	public void handleError (ClientHttpResponse httpResponse) throws IOException {
		if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
			LOGGER.log(Level.WARNING, "Server error");
		} else if (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
			if (httpResponse.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
				LOGGER.log(Level.SEVERE, "Client error UNAUTHORIZED");
			if (httpResponse.getStatusCode().equals(HttpStatus.NOT_FOUND))
				LOGGER.log(Level.WARNING, "Client error NOT FOUND");
		}
	}
}
