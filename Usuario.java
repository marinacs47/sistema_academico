package sistema_academico.modelo;

import java.util.ArrayList;
import java.util.List;

class Usuario implements IAutenticacao(){

	private String login;
	private String senha;
	private TipoUsuario tipoUsuario;
	private List<Usuario> usuarios = new ArrayList<>();

	public Usuario(String nome, String login, String senha, TipoUsuario tipoUsuario){
		super(login, senha);
		this.nome = nome;
		this.tipoUsuario = tipoUsuario;
	}

	public getTipoUsuario getTipoUsuario(){
		return(tipoUsuario);
	}

	public Usuario obter(String login, String senha){
		
	}
}
