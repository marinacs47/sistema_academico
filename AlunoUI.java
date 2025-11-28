package sistema_academico.visao;

import javax.swing.JOptionPane;
import sistema_academico.modelo.Aluno;

public class AlunoUI {

    public Aluno criar() {
        String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
        if (nome == null) return null;

        String matricula = JOptionPane.showInputDialog("Digite a matrícula do aluno:");
        if (matricula == null) return null;

        return new Aluno(matricula, nome);
    }

    public void listar() {
        StringBuilder lista = new StringBuilder("Lista de alunos:\n\n");

        for (Aluno aluno : Aluno.getAlunos()) {
            lista.append("Matrícula: ").append(aluno.getMatricula())
                 .append("   |   Nome: ").append(aluno.getNome())
                 .append("\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public Aluno remover() {
        String matricula = JOptionPane.showInputDialog("Digite a matrícula do aluno a remover:");
        if (matricula == null) return null;

        Aluno Aluno = Aluno.obter(a);

        if (aluno != null) {
            Aluno.remover(aluno);
            JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
        }

        return aluno;
    }
}
