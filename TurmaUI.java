sistema_academico.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TurmaUI {

    private Scanner scanner = new Scanner(System.in);

    public Turma criar() {
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();

        System.out.print("Digite o SIAPE do professor responsável: ");
        int siape = scanner.nextLine();
        Professor professor = Professor.obterProfessor(siape);

        List<Aluno> alunos = new ArrayList<>();
        boolean adicionarMais = true;
        while (adicionarMais) {
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = scanner.nextLine();
            if (matricula.isEmpty()) {
                adicionarMais = false;
            } else {
                Aluno aluno = Aluno.obterAluno(matricula);
                if (aluno != null) {
                    alunos.add(aluno);
                } else {
                    System.out.println("Aluno não encontrado.");
                }
            }
        }

        return new Turma(codigo, professor, alunos);
    }

    public void listar() {
        System.out.println("Lista de turmas:");
        for (Turma turma : Turma.getTurmas()) {
            System.out.println("Código: " + turma.getCodigo() +
                               " | Professor: " + turma.getProfessor().getNome() +
                               " | Alunos: " + turma.getAlunos().size());
        }
    }

    public Turma remover() {
        System.out.print("Digite o código da turma a remover: ");
        String codigo = scanner.nextLine();

        Turma turma = Turma.obterTurma(new Turma(codigo, null, new ArrayList<>()));
        if (turma != null) {
            Turma.removerTurma(turma);
            System.out.println("Turma removida com sucesso!");
        } else {
            System.out.println("Turma não encontrada.");
        }
        return turma;
    }
}
