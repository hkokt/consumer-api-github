package br.edu.fateczl.githubapi.model;

import org.springframework.stereotype.Component;

@Component
public class Repository {

	private int id;
	private String node_id;
	private String name;
	private String full_name;
	private User owner;
	private String html_url;
	private String default_branch;
	private String visibility;
	private String language;
	private String ssh_url;

	@Override
	public String toString() {
		return "\n\nDADOS DO REPOSITÓRIO:\n\nId:" + id + "\nNome: " + name + "\nNome completo:" + full_name + "\nDono: "
				+ owner.getLogin() + "\nLink: " + html_url + "\nBranch padrão: " + default_branch + "\nVisibilidade: "
				+ visibility + "\nLinguagem: " + language + "\nUrl ssh: " + ssh_url + "\n\n";
	}

	public int getId() {
		return id;
	}

	public String getNode_id() {
		return node_id;
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

	public String getSsh_url() {
		return ssh_url;
	}

	public String getFull_name() {
		return full_name;
	}
}
