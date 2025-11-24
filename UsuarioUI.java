package sistema_academico.visao;

import sistema_academico.modelo.Usuario;
import sistema_academico.modelo.TipoUsuario;
import sistema_academico.modelo.Funcionalidade;

import javax.swing.JOptionPane;

public class UsuarioUI{
	
	public static Usuario autenticar() {
		String login = JOptionPane.showInputDialog(null, "Login:");
		if(login == null){
			return null;
		}
	
		String senha = JOptionPane.showInputDialog(null, "Senha:");
		if(senha == null){
			return null;
		}

		Usuario u = Usuario.obter(login, senha);
		if(u == null){
			JOptionPane.showMessageDialog(null, "Login ou senha inválidos");
			return null;
		}
			return u;
	}

}