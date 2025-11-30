/*package sistema_academico.visao;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import sistema_academico.modelo.Turma;
import sistema_academico.modelo.Professor;
import sistema_academico.modelo.Aluno;

public class TurmaUI {

public Turma criar() {
String codigo = JOptionPane.showInputDialog("Código da Turma:");
if (codigo == null) return null;

String siapeStr = JOptionPane.showInputDialog("SIAPE do Professor:");
if (siapeStr == null) return null;

int siape;
try {
siape = Integer.parseInt(siapeStr);
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(null, "SIAPE inválido.");
return null;
}

Professor professor = null;
for (Professor p : Professor.getProfessores()) {
if (p.getSiape() == siape) {
professor = p;
break;
}
}

if (professor == null) {
JOptionPane.showMessageDialog(null, "Professor não encontrado.");
return null;
}

List<Aluno> alunos = new ArrayList<>();
String adicionar;

do {
adicionar = JOptionPane.showInputDialog("Matrícula do aluno (ou deixe vazio para terminar):");
if (adicionar == null || adicionar.isEmpty()) break;

Aluno encontrado = null;
for (Aluno a : Aluno.getAlunos()) {
if (a.getMatricula().equals(adicionar)) {
encontrado = a;
break;
}
}

if (encontrado == null) {
JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
} else {
alunos.add(encontrado);
}

} while (true);

Turma turma = new Turma(codigo, professor, alunos);
Turma.inserir(turma);

return turma;
}

public void listar() {
List<Turma> turmas = Turma.getTurmas();
StringBuilder sb = new StringBuilder();

for (Turma t : turmas) {
sb.append("Código: ").append(t.getCodigo()).append("\n");
sb.append("Professor: ").append(t.getProfessor().getNome()).append("\n");
sb.append("Alunos:\n");

for (Aluno a : t.getAlunos()) {
sb.append(" - ").append(a.getNome()).append(" (").append(a.getMatricula()).append(")\n");
}

sb.append("Média da turma: ").append(t.obterMedia()).append("\n");
sb.append("-----------------------------\n");
}

JOptionPane.showMessageDialog(null,
sb.length() == 0 ? "Nenhuma turma cadastrada." : sb.toString());
}

public Turma remover() {
String codigo = JOptionPane.showInputDialog("Código da Turma para remover:");
if (codigo == null) return null;

Turma alvo = new Turma(codigo, null, null);
boolean ok = Turma.remover(alvo);

JOptionPane.showMessageDialog(null, ok ? "Turma removida." : "Turma não encontrada.");

return ok ? alvo : null;
}
}*/

package sistema_academico.visao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import sistema_academico.modelo.Turma;
import sistema_academico.modelo.Professor;
import sistema_academico.modelo.Aluno;

public class TurmaUI {

    private Scanner sc = new Scanner(System.in);

    public Turma criar() {

        System.out.print("Código da turma: ");
        String codigo = sc.nextLine();
        if (codigo.isEmpty()) return null;

        System.out.print("SIAPE do professor: ");
        String siapeStr = sc.nextLine();
        if (siapeStr.isEmpty()) return null;

        int siape;
        try {
            siape = Integer.parseInt(siapeStr);
        } catch (NumberFormatException e) {
            System.out.println("SIAPE inválido.");
            return null;
        }

        Professor professor = null;
        for (Professor p : Professor.getProfessores()) {
            if (p.getSiape() == siape) {
                professor = p;
                break;
            }
        }

        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return null;
        }

        List<Aluno> alunos = new ArrayList<>();
        while (true) {
            System.out.print("Matrícula do aluno (ENTER para finalizar): ");
            String matricula = sc.nextLine();

            if (matricula.isEmpty()) break;

            Aluno encontrado = null;
            for (Aluno a : Aluno.getAlunos()) {
                if (a.getMatricula().equals(matricula)) {
                    encontrado = a;
                    break;
                }
            }

            if (encontrado == null) {
                System.out.println("Aluno não encontrado.");
            } else {
                alunos.add(encontrado);
                System.out.println("Aluno adicionado.");
            }
        }

        Turma turma = new Turma(codigo, professor, alunos);
        Turma.inserir(turma);

        return turma;
    }

    public void listar() {
        List<Turma> turmas = Turma.getTurmas();

        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        for (Turma t : turmas) {
            System.out.println("Código: " + t.getCodigo());
            System.out.println("Professor: " + t.getProfessor().getNome());
            System.out.println("Alunos:");
            for (Aluno a : t.getAlunos()) {
                System.out.println(" - " + a.getNome() + " (" + a.getMatricula() + ")");
            }
            System.out.println("Média da turma: " + t.obterMedia());
            System.out.println("--------------------------");
        }
    }

    public Turma remover() {
        System.out.print("Código da turma para remover: ");
        String codigo = sc.nextLine();
        if (codigo.isEmpty()) return null;

        Turma alvo = new Turma(codigo, null, null);
        boolean ok = Turma.remover(alvo);

        System.out.println(ok ? "Turma removida." : "Turma não encontrada.");
        return ok ? alvo : null;
    }
}