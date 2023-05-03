package br.edu.fateczl.githubapi;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.HttpClientErrorException;

import br.edu.fateczl.githubapi.controller.ConsumerController;

@SpringBootApplication
public class GithubApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubApiApplication.class, args);
		ConsumerController getInfo = new ConsumerController();

		try (Scanner sc = new Scanner(System.in)) {
			int opt = 0;

			while (opt != 9) {
				System.out.println(
						"\n\nSelecione com os caracteres:\n\n(U) Mostrar dados do usuário\n(L) Listar repositorios do usuário\n(R) Mostrar dados de um repositório especifico");

				String data = "";

				String choose = sc.next();

				switch (choose.toUpperCase().charAt(0)) {

				case 'U':
					System.out.println("Digite o usuário que deseja ver os dados:");
					data = sc.next();

					try {
						System.out.println(getInfo.getUserFromGithub(data).toString());
					} catch (HttpClientErrorException e) {
						System.out.println(e.getMessage());
					}

					break;
				case 'L':
					System.out.println("Digite o usuário que deseja listar os repositórios:");
					data = sc.next();

					try {
						System.out.println("\n\n\n===========REPOSITÓRIOS===========");
						getInfo.getRepositoriesFromUserGithub(data).forEach(repo -> {
							System.out.println("->" + repo.getName());
						});
					} catch (HttpClientErrorException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'R':
					System.out.println("Digite o nome do repositório:");
					data = sc.next();

					try {
						System.out.println(getInfo.getRepositoryFromGithub(data));
					} catch (HttpClientErrorException e) {
						System.out.println(e.getMessage());
					}
					break;

				default:
					System.err.println("opção inválida");
					break;
				}
			}
		}

	}

}
