package sistema_academico.modelo;

import java.util.ArrayList;
import java.util.List;

class Usuario implements IAutenticacao(){

	private String login;
	private String senha;
	private TipoUsuario tipoUsuario;
	private static List<Usuario> usuarios = new ArrayList<>();

	public Usuario(String nome, String login, String senha, TipoUsuario tipoUsuario){
		super(login, senha);
		this.nome = nome;
		this.tipoUsuario = tipoUsuario;
	}

	static{
			TipoUsuario Administrador = new TipoUsuario("Administrador");
			TipoUsuario Professor = new TipoUsuario("Professor");
			TipoUsuario Aluno = new TipoUsuario("Aluno");
			TipoUsuario Turma = new TipoUsuario("Turma");

			usuarios.add(new Usuario("ADMIN", Administrador));
			usuarios.add(new Usuario("Professor1", Professor));
			usuarios.add(new Usuario("Professor2", Professor));
			usuarios.add(new Usuario("Aluno1", Aluno));
						usuarios.add(new Usuario("Aluno2", Aluno));
						usuarios.add(new Usuario("Aluno3", Aluno));
						usuarios.add(new Usuario("Aluno4", Aluno));
						usuarios.add(new Usuario("Aluno5", Aluno));
						usuarios.add(new Usuario("Turma1", Turma));
												
	}

	public getTipoUsuario getTipoUsuario(){
		return(tipoUsuario);
	}

	public Usuario obter(String login, String senha){
		
	}

@Override
	public boolean autenticar(String login, String senha){
		return this.login.equals(login) && this.senha.equals(senha);
	}  
}
