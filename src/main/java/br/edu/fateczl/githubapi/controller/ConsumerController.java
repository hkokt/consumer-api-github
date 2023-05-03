package br.edu.fateczl.githubapi.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.edu.fateczl.githubapi.model.Endpoint;
import br.edu.fateczl.githubapi.model.Repository;
import br.edu.fateczl.githubapi.model.User;

@Controller
public class ConsumerController {

	private final RestTemplate restTemplate = new RestTemplate();

	public User getUserFromGithub(String username) throws HttpClientErrorException {
		ResponseEntity<User> user = restTemplate.getForEntity(new Endpoint(username).toUser(), User.class);
		return user.getBody();
	}

	public List<Repository> getRepositoriesFromUserGithub(String username) throws HttpClientErrorException {
		ResponseEntity<List<Repository>> response = restTemplate.exchange(new Endpoint(username).toRepositories(),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Repository>>() {
				});
		return response.getBody();
	}

	public Repository getRepositoryFromGithub(String repoName) throws HttpClientErrorException {
		ResponseEntity<Repository> repo = restTemplate.getForEntity(new Endpoint().toRepository(repoName),
				Repository.class);
		return repo.getBody();
	}

}
