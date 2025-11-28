package sistema_academico.visao;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import sistema_academico.modelo.Turma;
import sistema_academico.modelo.Professor;
import sistema_academico.modelo.Aluno;

public class TurmaUI {

    public Turma criar() {
        String codigo = JOptionPane.showInputDialog("Digite o código da turma:");
        if (codigo == null) return null;

        String siapeStr = JOptionPane.showInputDialog("Digite o SIAPE do professor responsável:");
        if (siapeStr == null) return null;

        int siape;
        try {
            siape = Integer.parseInt(siapeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERRO: o SIAPE deve ser um número inteiro.");
            return null;
        }

        Professor professor = Professor.obter(siape);
        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado!");
            return null;
        }

        List<Aluno> alunos = new ArrayList<>();
        boolean adicionarMais = true;

        while (adicionarMais) {
            String matricula = JOptionPane.showInputDialog(
                    "Digite a matrícula do aluno\n(Deixe vazio e pressione OK para terminar):"
            );

            if (matricula == null || matricula.isEmpty()) {
                adicionarMais = false;
            } else {
                Aluno aluno = Aluno.obter(matricula);
                if (aluno != null) {
                    alunos.add(aluno);
                    JOptionPane.showMessageDialog(null, "Aluno adicionado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
                }
            }
        }

        return new Turma(codigo, professor, alunos);
    }

    public void listar() {
        StringBuilder lista = new StringBuilder("📚 Lista de Turmas:\n\n");

        for (Turma turma : Turma.getTurmas()) {
            lista.append("Código: ").append(turma.getCodigo())
                 .append("\nProfessor: ").append(turma.getProfessor().getNome())
                 .append("\nQtd. Alunos: ").append(turma.getAlunos().size())
                 .append("\n-----------------------------\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public Turma remover() {
        String codigo = JOptionPane.showInputDialog("Digite o código da turma a remover:");
        if (codigo == null) return null;
        
        Turma turma = Turma.obter(codigo);

        if (turma != null) {
            Turma.remover(turma);
            JOptionPane.showMessageDialog(null, "Turma removida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada!");
        }

        return turma;
    }
}
