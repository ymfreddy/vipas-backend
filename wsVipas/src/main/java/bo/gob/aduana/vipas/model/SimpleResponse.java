package bo.gob.aduana.vipas.model;

import org.springframework.http.HttpStatus;

public class SimpleResponse {

	private String response;
	private Object content;
	private HttpStatus status;
	public HttpStatus getStatus() {
		return status;
	}
	public SimpleResponse() {
		super();
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public SimpleResponse(String response, Object content, String status) {
		super();
		this.response = response;
		this.content = content;
		this.setStatus(status);
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	public void setStatus(String httpcod) {
		if(httpcod.equals("200"))
			this.status = HttpStatus.OK;
		else
			if(httpcod.equals("401"))
				this.status = HttpStatus.UNAUTHORIZED;
			else
				if(httpcod.equals("403"))
					this.status = HttpStatus.FORBIDDEN;
				else
					if(httpcod.equals("404"))
						this.status = HttpStatus.NOT_FOUND;
					else
						if(httpcod.equals("405"))
							this.status = HttpStatus.METHOD_NOT_ALLOWED;
						else
							if(httpcod.equals("422"))
								this.status = HttpStatus.UNPROCESSABLE_ENTITY;
							else
								if(httpcod.equals("500"))
									this.status = HttpStatus.INTERNAL_SERVER_ERROR;
								else
									if(httpcod.equals("400"))
										this.status = HttpStatus.BAD_REQUEST;
	}
	
}
