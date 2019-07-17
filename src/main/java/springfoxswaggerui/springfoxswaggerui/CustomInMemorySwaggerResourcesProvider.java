package springfoxswaggerui.springfoxswaggerui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Primary
@Component
public class CustomInMemorySwaggerResourcesProvider extends InMemorySwaggerResourcesProvider {

    @Value("${spring.profiles.active:swagger}")
    private String activeProfiles;
    @Autowired
    StaticContentService staticContentService;

    public CustomInMemorySwaggerResourcesProvider(Environment environment, DocumentationCache documentationCache) {
        super(environment, documentationCache);
    }


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> list = new ArrayList<>();
        list.addAll(staticContentService.getContent("swaggerResources.json"));

        if (activeProfiles != null) {
            for (String profile : activeProfiles.split(",")) {
                list.addAll(staticContentService.getContent("swaggerResources-" + profile + ".json"));
            }
        }

        List<SwaggerResource> parent = super.get();

        if (list.isEmpty()) {
            return super.get();
        }
        return list;

    }
}
