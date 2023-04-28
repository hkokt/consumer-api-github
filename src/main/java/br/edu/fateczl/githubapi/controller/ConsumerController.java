package br.edu.fateczl.githubapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.edu.fateczl.githubapi.model.Endpoint;
import br.edu.fateczl.githubapi.model.Repository;
import br.edu.fateczl.githubapi.model.User;

@Controller
public class ConsumerController {

	public User getUserFromGithub(String username) throws HttpClientErrorException {
		User user = new RestTemplate().getForObject(new Endpoint().toUser(username), User.class);
		return user;
	}

	public Repository getRepositoryFromGithub(String username, String repoName) throws HttpClientErrorException {
		Repository repo = new RestTemplate().getForObject(new Endpoint().toRepository(username, repoName),
				Repository.class);
		return repo;
	}

}
