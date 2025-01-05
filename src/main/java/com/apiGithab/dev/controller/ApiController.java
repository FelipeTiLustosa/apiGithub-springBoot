package com.apiGithab.dev.controller;

import com.apiGithab.dev.client.GithubClient;
import com.apiGithab.dev.client.RepositoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final GithubClient githubClient;

    public ApiController(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @GetMapping(value = "/repos")
    public ResponseEntity<List<RepositoryResponse>> listMyRepositories(@RequestHeader(value = "token") String personalAccesToken) {

        var repos = githubClient.getRepositories(
                "bearer " + personalAccesToken,
                null,
                "public");

        return ResponseEntity.ok(repos);
    }
}