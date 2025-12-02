package sistema_academico.visao;

import javax.swing.JOptionPane;
import sistema_academico.modelo.Funcionalidade;
import sistema_academico.modelo.TipoUsuario;
import sistema_academico.modelo.Usuario;

public class UsuarioUI {

    public static Usuario autenticar() {
        while (true) {
            String login = JOptionPane.showInputDialog(null, "Digite seu Login:", "Autenticacao", JOptionPane.QUESTION_MESSAGE);
            if (login == null) System.exit(0);

            String senha = JOptionPane.showInputDialog(null, "Digite sua Senha:", "Autenticacao", JOptionPane.QUESTION_MESSAGE);
            if (senha == null) System.exit(0);

            String loginLimpo = login.trim();
            String senhaLimpa = senha.trim();
            
            if (loginLimpo.isEmpty() || senhaLimpa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Login e Senha não podem ser vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            Usuario usuario = Usuario.obter(loginLimpo, senhaLimpa);

            if (usuario != null) {
                return usuario;
            } else {
                JOptionPane.showMessageDialog(null, "Login ou Senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static int exibirMenu(Usuario usuario) {
        String menuTexto = construirMenu(usuario.getTipoUsuario());
        String opcaoStr = JOptionPane.showInputDialog(null, menuTexto, "Menu Principal - " + usuario.getLogin(), JOptionPane.PLAIN_MESSAGE);

        if (opcaoStr == null) return 99;

        try {
            return Integer.parseInt(opcaoStr);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static String construirMenu(TipoUsuario tipoUsuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- MENU SISTEMA ACADEMICO ---\n");
        sb.append("Usuario: ").append(tipoUsuario.getNome()).append("\n\n");
        
        int indice = 1;
        for (Funcionalidade func : tipoUsuario.getFuncionalidades()) {
            sb.append(indice).append(". ").append(func.getDescricao()).append("\n");
            indice++;
        }
        
        sb.append("\nDigite o numero da opcao desejada:");
        return sb.toString();
    }
}
