package bo.gob.aduana.vipas.utilitario.documentation;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("bo.gob.aduana.vipas.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Set Service API",
				"Set Service API Description",
				"1.0",
				"https://andesjboss.aduana.gob.bo:8463/wsset/",
				new Contact("Victor Miguel Mollo Huaygua", "www.linkedin.com/in/miguel-huaygua", "vmollo@aduana.com.bo"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
}
