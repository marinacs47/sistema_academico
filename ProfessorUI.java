package sistema_academico.visao;

import javax.swing.JOptionPane;
import sistema_academico.modelo.Professor;

public class ProfessorUI {

    public Professor criar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do professor:");
        if (nome == null) return null;

        String siapeStr = JOptionPane.showInputDialog("Digite o SIAPE do professor:");
        if (siapeStr == null) return null;

        int siape;
        try {
            siape = Integer.parseInt(siapeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "SIAPE deve ser um número!");
            return null;
        }

        return new Professor(siape, nome);
    }

    public void listar() {
        StringBuilder lista = new StringBuilder("Lista de Professores:\n\n");

        for (Professor professor : Professor.getProfessores()) {
            lista.append("SIAPE: ").append(professor.getSiape())
                 .append("   |   Nome: ").append(professor.getNome())
                 .append("\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public Professor remover() {
        String siapeStr = JOptionPane.showInputDialog("Digite o SIAPE do professor a remover:");
        if (siapeStr == null) return null;

        int siape;
        try {
            siape = Integer.parseInt(siapeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "SIAPE inválido!");
            return null;
        }

        Professor professor = Professor.obter(siape);

        if (professor != null) {
            Professor.remover(professor);
            JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Professor não encontrado.");
        }

        return professor;
    }
}
