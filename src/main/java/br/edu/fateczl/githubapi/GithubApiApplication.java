package br.edu.fateczl.githubapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.HttpClientErrorException;

import br.edu.fateczl.githubapi.controller.ConsumerController;

@SpringBootApplication
public class GithubApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubApiApplication.class, args);
		ConsumerController show = new ConsumerController();
		
		try {
			System.out.println(show.getUserFromGithub("hkokt").toString());
			System.out.println(show.getRepositoryFromGithub("hkokt", "POO").toString());
		
			
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
		}
	}
	

}
