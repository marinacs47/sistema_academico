package sistema_academico.modelo;

import java.util.ArrayList;
import java.util.List;

class Usuario implements IAutenticacao{

	private String login;
	private String senha;
	private TipoUsuario tipoUsuario;
	public static List<Usuario> usuarios = new ArrayList<>();

	static{ 
		usuarios.add(new Usuario("admin", "12345", new TipoUsuario("Administrador")));
	}

	public Usuario(String login, String senha, TipoUsuario tipoUsuario){
		this.login = login;
   		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

	public TipoUsuario getTipoUsuario(){
		return tipoUsuario;
	}

	public static Usuario obter(String login, String senha){
		for (Usuario u : usuarios) {
			if(u.autenticar(login, senha))
				return u;
		}
				return null;
	}

@Override
	public boolean autenticar(String login, String senha){
		return this.login.equals(login) && this.senha.equals(senha);
	}  
}
