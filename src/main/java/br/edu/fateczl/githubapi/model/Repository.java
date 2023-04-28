package br.edu.fateczl.githubapi.model;

public class Repository {

	private String name;
	private User owner;
	private String html_url;
	private String default_branch;
	private String visibility;
	private String language;

	@Override
	public String toString() {
		return "\n\nDADOS ENCONTRADOS DO REPOSITÓRIO:\n\nNome: " + name + "\nDono: " + owner.getLogin() + "\nLink: "
				+ html_url + "\nBranch padrão: " + default_branch + "\nVisibilidade: " + visibility + "\nLinguagem: "
				+ language + "\n\n";
	}

	public String getName() {
		return name;
	}

	public User getOwner() {
		return owner;
	}

	public String getHtml_url() {
		return html_url;
	}

	public String getDefault_branch() {
		return default_branch;
	}

	public String getVisibility() {
		return visibility;
	}

	public String getLanguage() {
		return language;
	}

}
