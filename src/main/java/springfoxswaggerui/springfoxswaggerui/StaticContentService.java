package springfoxswaggerui.springfoxswaggerui;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger.web.SwaggerResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaticContentService {

    private final String basePath = "/";
    private final Logger log = LoggerFactory.getLogger(StaticContentService.class);

    public List<SwaggerResource> getContent(String fileName) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new ClassPathResource(basePath + fileName).getInputStream();
            String content = IOUtils.toString(inputStream, "UTF-8");
            List<SwaggerResource> actualObj = mapper.readValue(content, new TypeReference<List<SwaggerResource>>() {
            });
            return actualObj;
        } catch (IOException ex) {
            log.info("StaticContentService, Profile file not exist");
            return new ArrayList<>();
        }

    }
}
