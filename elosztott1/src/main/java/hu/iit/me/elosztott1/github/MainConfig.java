package hu.iit.me.elosztott1.github;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MainConfig {

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
