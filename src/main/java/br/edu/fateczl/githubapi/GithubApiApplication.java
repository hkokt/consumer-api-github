package br.edu.fateczl.githubapi;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.HttpClientErrorException;

import br.edu.fateczl.githubapi.controller.ConsumerController;
import br.edu.fateczl.githubapi.model.Repository;

@SpringBootApplication
public class GithubApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubApiApplication.class, args);
		ConsumerController getInfo = new ConsumerController();

		Scanner sc = new Scanner(System.in);
		int opt = 0;

		try {
			while (opt != 9) {
				System.out.println(
						"(U) Mostrar dados do usuário\n(L) Listar repositorios do usuário\n(R) Mostrar dados de um repositório especifico");

				String username = "";
				String repository = "";

				String choose = sc.next();

				switch (choose.toUpperCase().charAt(0)) {

				case 'U':
					System.out.println("Digite o usuário que deseja ver os dados:");
					username = sc.next();
					System.out.println(getInfo.getUserFromGithub(username).toString());
					break;
				case 'L':
					System.out.println("Digite o usuário que deseja listar os repositórios:");
					username = sc.next();
					
					System.out.println("===========REPOSITÓRIOS===========");
					getInfo.getRepositoriesFromUserGithub(username).forEach(repo -> {
						System.out.println("->" + repo.getName());
					});
					break;
				case 'R':
					System.out.println("Digite o usuário:");
					username = sc.next();
					System.out.println("Digite o nome do repositório:");
					repository = sc.next();
					
					
					System.out.println(getInfo.getRepositoryFromGithub(username, repository));
					break;

				default:
					System.err.println("opção inválida");
					break;
				}
			}
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}

	}

}
