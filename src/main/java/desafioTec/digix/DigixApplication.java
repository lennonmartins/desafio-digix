package desafioTec.digix;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "API Documentation", version = "1.0", description = "API Documentation"))
@SpringBootApplication
public class DigixApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DigixApplication.class, args);

		
	}
}
