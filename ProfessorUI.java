package sistema_academico.visao;

import java.util.Scanner;

public class ProfessorUI {

    private Scanner scanner = new Scanner(System.in);

    public Professor criar() {
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o SIAPE do professor: ");
        int siape = scanner.nextLine();

        return new Professor(siape, nome);
    }

    public void listar() {
        System.out.println("Lista de professores:");
        for (Professor professor : Professor.getProfessores()) {
            System.out.println("SIAPE: " + professor.getSiape() + " | Nome: " + professor.getNome());
        }
    }

    public Professor remover() {
        System.out.print("Digite o SIAPE do professor a remover: ");
        int siape = scanner.nextLine();

        Professor professor = Professor.obterProfessor(siape);
        if (professor != null) {
            Professor.removerProfessor(professor);
            System.out.println("Professor removido com sucesso!");
        } else {
            System.out.println("Professor não encontrado.");
        }
        return professor;
    }
}
