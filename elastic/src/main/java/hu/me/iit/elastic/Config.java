package hu.me.iit.elastic;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories()
public class Config extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearcClient() {
        return RestClients();
    }

}
