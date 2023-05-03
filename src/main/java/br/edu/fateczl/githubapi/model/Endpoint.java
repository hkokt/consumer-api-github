package br.edu.fateczl.githubapi.model;

import org.springframework.web.util.UriComponentsBuilder;

public class Endpoint {

	private String user;

	public Endpoint(String user) {
		this.user = user;
	}

	public String toUser() {
		return buildUri("users/" + user);
	}

	public String toRepositories() {
		return buildUri("/users/" + user + "/repos");

	}

	public String toRepository(String repo) {
		return buildUri("repos/" + user + "/" + repo);
	}

	private String buildUri(String path) {
		return UriComponentsBuilder.newInstance().scheme("https").host("api.github.com").path(path).build()
				.toUriString();
	}
}
