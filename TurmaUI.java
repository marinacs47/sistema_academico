package sistema_academico.visao;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import sistema_academico.modelo.Aluno;
import sistema_academico.modelo.Professor;
import sistema_academico.modelo.Turma;

public class TurmaUI {

    public static Turma criar() {
        if (Professor.getProfessores().isEmpty()) {
            UsuarioUI.exibirMensagem("Erro: Nao ha professores cadastrados.");
            return null;
        }

        String codigo = JOptionPane.showInputDialog("Digite o Codigo da Turma:");
        if (codigo == null) return null;

        List<Professor> listaProfs = Professor.getProfessores();
        Object[] profsArray = new Object[listaProfs.size()];
        for(int i=0; i < listaProfs.size(); i++) {
            profsArray[i] = listaProfs.get(i).getNome() + " (" + listaProfs.get(i).getSiape() + ")";
        }

        Object selecionado = JOptionPane.showInputDialog(
            null, "Selecione o Professor:", "Professor", 
            JOptionPane.QUESTION_MESSAGE, null, profsArray, profsArray[0]
        );

        if (selecionado == null) return null;

        int indexProf = -1;
        for(int i=0; i<profsArray.length; i++){
            if(profsArray[i].equals(selecionado)){
                indexProf = i;
                break;
            }
        }
        Professor professorEscolhido = listaProfs.get(indexProf);

        List<Aluno> alunosDaTurma = new ArrayList<>();
        List<Aluno> todosAlunos = Aluno.getAlunos();

        if (todosAlunos.isEmpty()) {
            UsuarioUI.exibirMensagem("Aviso: Nao ha alunos cadastrados.");
        } else {
            while (true) {
                int confirm = JOptionPane.showConfirmDialog(null, "Deseja adicionar um aluno a turma?", "Alunos", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) break;

                Object[] alunosArray = new Object[todosAlunos.size()];
                for(int i=0; i<todosAlunos.size(); i++){
                    alunosArray[i] = todosAlunos.get(i).getNome() + " (" + todosAlunos.get(i).getMatricula() + ")";
                }

                Object alunoSelecionadoObj = JOptionPane.showInputDialog(
                    null, "Escolha o aluno:", "Adicionar Aluno", 
                    JOptionPane.QUESTION_MESSAGE, null, alunosArray, alunosArray[0]);
                
                if (alunoSelecionadoObj != null) {
                    for(int i=0; i<alunosArray.length; i++){
                        if(alunosArray[i].equals(alunoSelecionadoObj)){
                            Aluno a = todosAlunos.get(i);
                            if(!alunosDaTurma.contains(a)){
                                alunosDaTurma.add(a);
                                UsuarioUI.exibirMensagem("Aluno adicionado!");
                            } else {
                                UsuarioUI.exibirMensagem("Este aluno ja esta na turma.");
                            }
                            break;
                        }
                    }
                }
            }
        }

        Turma novaTurma = new Turma(codigo, professorEscolhido, alunosDaTurma);
        Turma.inserirTurma(novaTurma);
        UsuarioUI.exibirMensagem("Turma cadastrada com sucesso!");
        return novaTurma;
    }

    public static void listar() {
        List<Turma> turmas = Turma.getTurmas();
        StringBuilder sb = new StringBuilder("--- LISTA DE TURMAS ---\n\n");

        if (turmas.isEmpty()) {
            sb.append("Nenhuma turma cadastrada.");
        } else {
            for (Turma t : turmas) {
                sb.append("Cod: ").append(t.getCodigo()).append("\n");
                sb.append("Prof: ").append(t.getProfessor().getNome()).append("\n");
                sb.append("Qtd Alunos: ").append(t.getAlunos().size()).append("\n");
                sb.append("----------------------------\n");
            }
        }
        UsuarioUI.exibirMensagem(sb.toString());
    }

    public static void remover() {
        String codigo = JOptionPane.showInputDialog("Digite o Codigo da turma a remover:");
        if (codigo == null) return;

        Turma turma = Turma.obterTurma(codigo);
        if (turma != null) {
            Turma.removerTurma(turma);
            UsuarioUI.exibirMensagem("Turma removida com sucesso!");
        } else {
            UsuarioUI.exibirMensagem("Turma nao encontrada.");
        }
    }

}
