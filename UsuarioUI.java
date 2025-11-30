/*package sistema_academico.visao;

import javax.swing.JOptionPane;
import java.util.List;
import sistema_academico.modelo.Usuario;
import sistema_academico.modelo.TipoUsuario;
import sistema_academico.modelo.Funcionalidade;


public class UsuarioUI {

public Usuario autenticar(){
String login = JOptionPane.showInputDialog("Login");
if(login == null)
return null;

String senha = JOptionPane.showInputDialog("Senha:");
if(senha == null)
return null;

Usuario u = Usuario.obter(login, senha);

if(u == null){
exibirMensagem("Usuário ou senha inválidos.", JOptionPane.ERROR_MESSAGE);
return autenticar();
}
return u;
}

public void exibirMensagem(String mensagem){
JOptionPane.showMessageDialog(null, mensagem);
}

public void exibirMensagem(String mensagem, int tipo){
JOptionPane.showMessageDialog(null, mensagem, "Mensagem", tipo);
}

public int exibirMenu(Usuario usuario){
if(usuario == null) return -1;
String menu = construirMenu(usuario.getTipoUsuario());
String escolha = JOptionPane.showInputDialog(menu);
if(escolha == null) return -1;
try{
return Integer.parseInt(escolha.trim());
}catch (NumberFormatException e){
exibirMensagem("Opção inválida.Tente Novamente", JOptionPane.WARNING_MESSAGE);
return exibirMenu(usuario);
}
}

private String construirMenu(TipoUsuario tipoUsuario){
StringBuilder sb = new StringBuilder();
sb.append("MENU PRINCIPAL\n");

List<Funcionalidade> funs = tipoUsuario.getFuncionalidades();
for(Funcionalidade f : funs){
switch(f.getCodigo()){
case "CA":
sb.append("1 - Cadastrar Aluno\n");
break;
case "CP":
sb.append("2 - Cadastrar Professor\n");
break;
case "CT":
sb.append("3 - Cadastrar Turma\n");
break;
case "LA":
sb.append("4 - Listar Aluno\n");
break;
case "LP":
sb.append("5 - Listar Professor\n");
break;
case "LT":
sb.append("6 - Listar Turma\n");
break;
case "RA":
sb.append("7 - Remover Aluno\n");
break;
case "RP":
sb.append("8 - Remover Professor\n");
break;
case "RT":
sb.append("9 - Remover Turma\n");
break;
}
}

sb.append("0 - Sair");
return sb.toString();
}
}*/

package sistema_academico.visao;

import java.util.Scanner;
import java.util.List;

import sistema_academico.modelo.Usuario;
import sistema_academico.modelo.TipoUsuario;
import sistema_academico.modelo.Funcionalidade;

public class UsuarioUI {

    private Scanner sc = new Scanner(System.in);

    public Usuario autenticar() {
        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario u = Usuario.obter(login, senha);

        if (u == null) {
            System.out.println("Usuário ou senha inválidos.");
            return autenticar();
        }

        return u;
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirMensagem(String mensagem, int tipo) {
        System.out.println(mensagem);
    }

    public int exibirMenu(Usuario usuario) {
        if (usuario == null) return -1;

        String menu = construirMenu(usuario.getTipoUsuario());
        System.out.println(menu);

        System.out.print("Escolha: ");
        String escolha = sc.nextLine();

        try {
            return Integer.parseInt(escolha.trim());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida. Tente novamente.");
            return exibirMenu(usuario);
        }
    }

    private String construirMenu(TipoUsuario tipoUsuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("MENU PRINCIPAL\n");

        List<Funcionalidade> funs = tipoUsuario.getFuncionalidades();

        for (Funcionalidade f : funs) {
            switch (f.getCodigo()) {
                case "CA": sb.append("1 - Cadastrar Aluno\n"); break;
                case "CP": sb.append("2 - Cadastrar Professor\n"); break;
                case "CT": sb.append("3 - Cadastrar Turma\n"); break;
                case "LA": sb.append("4 - Listar Alunos\n"); break;
                case "LP": sb.append("5 - Listar Professores\n"); break;
                case "LT": sb.append("6 - Listar Turmas\n"); break;
                case "RA": sb.append("7 - Remover Aluno\n"); break;
                case "RP": sb.append("8 - Remover Professor\n"); break;
                case "RT": sb.append("9 - Remover Turma\n"); break;
            }
        }

        sb.append("0 - Sair\n");
        return sb.toString();
    }
}