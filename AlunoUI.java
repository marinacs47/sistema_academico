package sistema_academico.visao;

import java.util.Scanner;

public class AlunoUI {

    private Scanner scanner = new Scanner(System.in);

    public Aluno criar() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        return new Aluno(matricula, nome);
    }

    public void listar() {
        System.out.println("Lista de alunos:");
        for (Aluno aluno : Aluno.getAlunos()) { 
            System.out.println("Matrícula: " + aluno.getMatricula() + " | Nome: " + aluno.getNome());
        }
    }
    
    public Aluno remover() {
        System.out.print("Digite a matrícula do aluno a remover: ");
        String matricula = scanner.nextLine();

        Aluno aluno = Aluno.obterAluno(matricula);
        if (aluno != null) {
            Aluno.removerAluno(aluno);
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
        return aluno;
