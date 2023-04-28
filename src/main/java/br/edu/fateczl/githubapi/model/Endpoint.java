package br.edu.fateczl.githubapi.model;

import org.springframework.web.util.UriComponentsBuilder;

public class Endpoint {

	public String toUser(String user) {
		return buildUri("users/" + user);
	}

	public String toRepository(String user, String repo) {
		return buildUri("repos/" + user + "/" + repo);
	}

	private String buildUri(String path) {
		return UriComponentsBuilder.newInstance().scheme("https").host("api.github.com").path(path).build()
				.toUriString();
	}
}
