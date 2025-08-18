package com.varunmatangi.order_service.config;

import com.varunmatangi.order_service.service.http.ProductHttpClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpConfig {


    @LoadBalanced
    @Bean
    RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    ProductHttpClient productHttpClient(RestClient.Builder restClientBuilder) {
        RestClient client = restClientBuilder.baseUrl("http://PRODUCT-SERVICE/api/v1/products").build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client)).build();
        return factory.createClient(ProductHttpClient.class);
    }
}
