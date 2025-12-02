package sistema_academico.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario implements IAutenticacao {

    private String login;
    private String senha;
    private TipoUsuario tipoUsuario;
    public static List<Usuario> usuarios = new ArrayList<>();

    static {
        TipoUsuario tipoAdmin = new TipoUsuario("Administrador");
        usuarios.add(new Usuario("admin", "12345", tipoAdmin));
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
        for (Usuario usuario : usuarios) {
            if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean autenticar(String login, String senha){
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public String toString() {
        return login + "(" + tipoUsuario.getNome() + ")";
    }
}
