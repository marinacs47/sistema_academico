package sistema_academico.visao;

import javax.swing.JOptionPane;
import java.util.List;
import sistema_academico.modelo.Aluno;
import sistema_academico.modelo.MatriculaJaExisteException; 

public class AlunoUI {

    private static boolean isEntradaInvalida(String entraada) {
        return entrada == null || entrada.isEmpty(); 
    }

    public static Aluno cadastrar() {
        String matricula = JOptionPane.showInputDialog("Digite a Matricula do Aluno:");
        
        if (isEntradaInvalida(matricula)) {
            UsuarioUI.exibirMensagem("Cadastro cancelado ou Matrícula Inválida.");
            return null;
        }

        String nome = JOptionPane.showInputDialog("Digite o Nome do Aluno:");
        
        if (isEntradaInvalida(nome)) {
            UsuarioUI.exibirMensagem("Cadastro cancelado ou Nome Inválido.");
            return null;
        }

        Aluno novoAluno = new Aluno(matricula, nome); 
        
        try {
            Aluno.inserirAluno(novoAluno); 
            UsuarioUI.exibirMensagem("Aluno cadastrado com sucesso!");
            return novoAluno;
            
        } catch (MatriculaJaExisteException e) { 
            UsuarioUI.exibirMensagem("ERRO: A matrícula " + matricula + " já está cadastrada.");
            return null;
            
        } catch (Exception e) {
            UsuarioUI.exibirMensagem("ERRO INESPERADO ao cadastrar aluno: " + e.getMessage());
            return null;
        }
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
        
        if (isEntradaInvalida(matricula)) {
             UsuarioUI.exibirMensagem("Remoção cancelada ou Matrícula Inválida.");
            return;
        }

        Aluno aluno = Aluno.obterAluno(matricula);
        if (aluno != null) {
            Aluno.removerAluno(aluno);
            UsuarioUI.exibirMensagem("Aluno removido com sucesso!");
        } else {
            UsuarioUI.exibirMensagem("Aluno nao encontrado. Verifique a matrícula.");
        }
    }
}
