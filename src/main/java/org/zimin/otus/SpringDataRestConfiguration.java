package org.zimin.otus;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class SpringDataRestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        config.getExposureConfiguration()
                .forDomainType(User.class)
                .withItemExposure(((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PATCH)))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PATCH));
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
    }
}
