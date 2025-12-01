package sistema_academico.visao;

import javax.swing.JOptionPane;
import java.util.List;
import sistema_academico.modelo.Professor;

public class ProfessorUI {

    public static Professor criar() {
        String siapeStr = JOptionPane.showInputDialog("Digite o SIAPE do Professor:");
        if (siapeStr == null) return null;

        int siape;
        try {
            siape = Integer.parseInt(siapeStr);
        } catch (NumberFormatException e) {
            UsuarioUI.exibirMensagem("SIAPE invalido. Deve ser um numero.");
            return null;
        }

        String nome = JOptionPane.showInputDialog("Digite o Nome do Professor:");
        if (nome == null) return null;

        Professor nvProf = new Professor(siape, nome);
        Professor.inserirProfessor(nvProf);
        
        UsuarioUI.exibirMensagem("Professor cadastrado com sucesso!");
        return nvProf;
    }

    public static void listar() {
        List<Professor> professores = Professor.getProfessores();
        StringBuilder sb = new StringBuilder("--- LISTA DE PROFESSORES ---\n");

        if (professores.isEmpty()) {
            sb.append("Nenhum professor cadastrado.");
        } else {
            for (Professor p : professores) {
                sb.append("SIAPE: ").append(p.getSiape())
                  .append(" | Nome: ").append(p.getNome()).append("\n");
            }
        }
        UsuarioUI.exibirMensagem(sb.toString());
    }

    public static void remover() {
        String siapeStr = JOptionPane.showInputDialog("Digite o SIAPE do professor a remover:");
        if (siapeStr == null) return;
        
        try {
            int siape = Integer.parseInt(siapeStr);
            Professor prof = Professor.obterProfessor(siape);
            
            if (prof != null) {
                Professor.removerProfessor(prof);
                UsuarioUI.exibirMensagem("Professor removido com sucesso!");
            } else {
                UsuarioUI.exibirMensagem("Professor nao encontrado.");
            }
        } catch (NumberFormatException e) {
            UsuarioUI.exibirMensagem("SIAPE invalido.");
        }
    }
}
