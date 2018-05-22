package springfoxswaggerui.springfoxswaggerui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringfoxSwaggerUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringfoxSwaggerUiApplication.class, args);
    }



}
