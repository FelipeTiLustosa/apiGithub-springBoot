package com.apiGithab.dev.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RepositoryResponse(String id,
                                 @JsonProperty("html_url") String url,
                                 @JsonProperty("private") boolean isPrivate,
                                 String name) {
}
