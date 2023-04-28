package br.edu.fateczl.githubapi.model;

public class User {

	private String login;
	private String name;
	private String company;
	private String location;
	private int followers;
	private int public_repos;

	@Override
	public String toString() {
		return "\n\nDADOS ENCONSTRADOS DO USUÁRIO:\n\nLogin: " + login + "\nNome: " + name + "\nEmpresa: " + company
				+ "\nLocalização: " + location + "\nQtd. seguidores: " + followers + "\nQtd. repositórios públicos: "
				+ public_repos + "\n\n";
	}

	public String getLogin() {
		return login;
	}

	public String getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	public String getLocation() {
		return location;
	}

	public int getFollowers() {
		return followers;
	}

	public int getPublic_repos() {
		return public_repos;
	}

}
