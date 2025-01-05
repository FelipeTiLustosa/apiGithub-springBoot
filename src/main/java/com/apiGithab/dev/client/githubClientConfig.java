package com.apiGithab.dev.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class githubClientConfig {

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory() {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.github.com")
                .build();

        return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();
    }

    @Bean
    public GithubClient githubClient(HttpServiceProxyFactory factory) {
        return factory.createClient(GithubClient.class);
    }

}
