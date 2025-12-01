package sistema_academico.visao;

import javax.swing.JOptionPane;
import java.util.List;
import sistema_academico.modelo.Aluno;

public class AlunoUI {

    public static Aluno criar() {
        
        String matricula = JOptionPane.showInputDialog("Digite a Matricula do Aluno:");
        if (matricula == null) return null;

        String nome = JOptionPane.showInputDialog("Digite o Nome do Aluno:");
        if (nome == null) return null;

        Aluno nvAluno = new Aluno(matricula, nome);

        Aluno.inserirAluno(nvAluno);
        
        UsuarioUI.exibirMensagem("Aluno cadastrado com sucesso!");
        return novoAluno;
    }

    public static void listar() {
        
        List<Aluno> alunos = Aluno.getAlunos();
        StringBuilder sb = new StringBuilder("--- LISTA DE ALUNOS ---\n");

        if (alunos.isEmpty()) {
            sb.append("Nenhum aluno cadastrado.");
        } else {
            for (Aluno a : alunos) {
                sb.append("Matricula: ").append(a.getMatricula())
                  .append(" | Nome: ").append(a.getNome()).append("\n");
            }
        }
        UsuarioUI.exibirMensagem(sb.toString());
    }

    public static void remover() {
        
        String matricula = JOptionPane.showInputDialog("Digite a Matricula do aluno a ser removido:");
        if (matricula == null) return;

        Aluno aluno = Aluno.obterAluno(matricula);
        if (aluno != null) {
            Aluno.removerAluno(aluno);
            UsuarioUI.exibirMensagem("Aluno removido com sucesso");
        } else {
            UsuarioUI.exibirMensagem("Aluno nao encontrado.");
        }
    }
}
